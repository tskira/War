/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *  
 * @author Usuario
 */
public class WarControle {
    
    private static List<Jogador> players = new ArrayList<>(); //lista para jogadores no jogo
    private static Mapa mapaJogo = new Mapa(); //mapa do jogo
    
    private WarControle() { //construtor
    }
    
    public static WarControle getInstance() { //singleton
        return WarControleHolder.INSTANCE;
    }
    
    private static class WarControleHolder { //singleton
        private static final WarControle INSTANCE = new WarControle();
    }
    
    //metodo que retorna numero de jogadores em jogo
    public static int numeroPlayers(){ return players.size(); }
    
    //metodo que pega o mapa
    public Mapa getMapaJogo(){return mapaJogo;}
    
    public static List<Jogador> jogadores(){
        return players;
    }
    
    /* metodo para adicionar o numero de jogadores
     * define uma cor para cada jogador
     */
    public static void setJogador(int nroJogadores){ 
        for (int j = 0; j < nroJogadores; j++) {
            players.add(new Jogador(Cor.values()[j]));
        }
    }
    
    /* metodo para distribuição de territorios
     * itera-se sobre o enum continente, adicionando todos os territorio a uma  lista
     * embaralha a lista distribuindo os territorios entre os jogadores
     * inicializa cada territorio atribuindo a cor de respectivo jogador
     * adiciona um exercito aereo e um terrestre em cada territiorio
     */
    public static void distribuirTerritorio(){
        List<Territorio> territDist = new ArrayList<>(); //lista para armazenar os territorios
        for(Territorio iterador: mapaJogo.getTabuleiro().values()){ 
            territDist.add(iterador);//adiciona os territorios a lista
        }
        Collections.shuffle(territDist); // embaralha lista
        for (int i = 0; i < territDist.size(); i++) { //distribui a lista entre os jogadores
            Jogador atualPlayer = players.get(i% numeroPlayers());
            atualPlayer.conqTerritorio(territDist.get(i)); //atribui o ter. ao jogador
            territDist.get(i).setDono(atualPlayer.cor); //seta o dono
            territDist.get(i).exercitosA.add(new Aereo()); //adiciona um aereo
            territDist.get(i).exercitosT.add(new Terrestre()); //adiciona um terrestre
        }   
    }
    
    /* metodo para atribuir novos exercitos para jogador
     * este metodo foi atualizado para o modelo de jogo de war de verdade
     * para terrestre nroTerritorios/2
     * para aereos nroTerritoios/3
     * todos os continentes contam com um bonus
     * caso o jogador alvo tenha consquistado algum continente ele tera bonus adicional
     */
    public static void atribuirExercBonus(Jogador jogador){
        for (int i = 0; i < jogador.nroTerritorios()/2; i++) {
            jogador.recebeExercito(new Terrestre());
        }
        for (int i = 0; i < jogador.nroTerritorios()/3; i++) {
            jogador.recebeExercito(new Aereo());
        }
    }
    
    /* metodo para comitar jogadas
     * ao receber o comando de commit do jogador este controlador processa as
     * ações definidas pelo jogador
     * utiliza polimorfismo para diferentes contextos
     */
   
    public void commit(List<ArgumentoAlocI> ai, List<ArgumentoAlocII> aii){
   
        //commit da lista de instruções alocI
        for (ArgumentoAlocI args: ai){
            args.getTerritorio().recebeExercito(args.getExercito());   
        }
        
        //commit da lista de instruções alocII
        for (ArgumentoAlocII args: aii){
            args.getDestino().recebeExercito(args.getExercito());
        }
    } 
    
    // os metodos a seguir definem as ações dentro de um turno da jogada
    
    /* primeira etapa: distribuição dos exercitos de bonificaçao
     * faz chamadas sucessivas do metodo alocarExercito()
     * apos o jogador ter alocado todos os exercitos é realizado o commit dos movimentos
     * na sequencia essas listas sao esvaziadas.
     */
    public void distribuição(Jogador jogador){
        Scanner scan = new Scanner(System.in);
        int cord[] = new int[2]; //inteiro para armazenar cordenada
        while(jogador.getTerDisp().isEmpty()){ //enquanto houverem eercitos terrestre disponiveis
            cord[0] = scan.nextInt();
            cord[1] = scan.nextInt();
            jogador.alocarExercito(mapaJogo.getTabuleiro().get(cord), Constante.TERRESTRE);
        } // alocou todos os exercitos terrestres disponiveis
        while(jogador.getAerDisp().isEmpty()){ //enquanto houverem eercitos terrestre disponiveis
            cord[0] = scan.nextInt();
            cord[1] = scan.nextInt();
            jogador.alocarExercito(mapaJogo.getTabuleiro().get(cord), Constante.AEREO);
        } //alocou todos os aereos disponiveis
        //commit joagadas
        commit(jogador.commitJogadaI(),jogador.commitJogadaII());
        jogador.resetaMovimentos();
    }
    
    /* segunda etapa: conquisa de territorios
     * nesta etapa o jogador ira realizar ataques sucessivos aos territorios inimigos
     * respeitando as regras de combate
     * os atks poderao ser alternados entre aereo e terrestre
     */
    
    public void disputa(Jogador jogador){
        /* seleciona o metodo de atk
         * seleciona o territorio de origem e o territorio de destino
         * seleciona o numero de exercitos que irao atacar < salva uma variavel para isso
         * ocorre dentro do loop que verifica se o atual jogador ainda deseja atacar
         */
        
        int acao;
        Scanner scan = new Scanner(System.in);
        // 1 para terrestre
        // 2 para aereo
        // 0 sai
        do{ //enquanto o jogador quiser atacar, arrumar isso dpois
            acao = scan.nextInt();
            switch(acao){
                case 1:{
                    int[] atk = new int[3]; //vetor para armazenar os resultados de atk
                    int[] def = new int[3]; //vetor para armazenar os resultados de def
                    int numDeAtks; //variavel para o numero de exercitos deslocados para o atk
                    /*tem q fazer a verificação de limite para atks (>1)
                     */
                    int[] cordOri = new int[2];
                    int[] cordDest = new int[2];
                    cordOri[0] = scan.nextInt();
                    cordOri[1] = scan.nextInt(); //pega territorio de origem
                    cordDest[0] = scan.nextInt();
                    cordDest[1] = scan.nextInt();//pega territorio de destino
                    numDeAtks = scan.nextInt();
                    atk = jogador.atacarTerritorio(mapaJogo.getTabuleiro().get(cordOri),
                                             mapaJogo.getTabuleiro().get(cordDest),
                                             Constante.TERRESTRE,
                                             numDeAtks); //recebe resultados do dado laranja
                    def = mapaJogo.getTabuleiro().get(cordDest).defender(Constante.TERRESTRE); //recebe resultados do dado azul
                    for(int i = (numDeAtks - 1); i >= 0 ; i--){ //inverter o for por causa do Arrays.sort
                        if (atk[i] > def[i]){ // atk venceu
                            mapaJogo.getTabuleiro().get(cordDest).removeExercito(Constante.TERRESTRE);
                        } 
                        else{ //atk empatou ou perdeu
                            mapaJogo.getTabuleiro().get(cordOri).removeExercito(Constante.TERRESTRE);
                        }
                    }//fim do para
                    mapaJogo.getTabuleiro().get(cordDest).resetaDefs(); //reseta os dados de defesa
                    jogador.resetaAtks(); //reseta os dados de atk
                    if(mapaJogo.getTabuleiro().get(cordDest).getNroExercitos(Constante.TERRESTRE) == 0){
                        jogador.conqTerritorio(mapaJogo.getTabuleiro().get(cordDest));
                        jogador.alocarExercito(mapaJogo.getTabuleiro().get(cordOri),
                                               mapaJogo.getTabuleiro().get(cordDest),
                                               Constante.TERRESTRE, numDeAtks);
                        commit(jogador.commitJogadaI(), jogador.commitJogadaII());
                        jogador.resetaMovimentos();
                    }
                    break;
                }//fim do case terrestre
                
                case 2:{
                    int[] atk = new int[3];
                    int[] cordDest = new int[2];
                    cordDest[0] = scan.nextInt();
                    cordDest[1] = scan.nextInt(); //pega o territorio alvo
                    atk = jogador.atacarTerritorio(Constante.AEREO, mapaJogo.getTabuleiro().get(cordDest));
                    for(int i = 0; i < Constante.MAXIMO; i++){
                        switch (atk[i]){
                            case 0:
                                break;
                            case 1: {
                                mapaJogo.getTabuleiro().get(cordDest).removeExercito(Constante.AEREO);//remove 1 areo
                                mapaJogo.getTabuleiro().get(cordDest).removeExercito(Constante.TERRESTRE); //remove 1 terrestre
                                break;
                            }//fim do caso 1
                            
                            case 2: {
                                mapaJogo.getTabuleiro().get(cordDest).removeExercito(Constante.AEREO); //remove 1 aereo
                                mapaJogo.getTabuleiro().get(cordDest).removeExercito(Constante.TERRESTRE);
                                mapaJogo.getTabuleiro().get(cordDest).removeExercito(Constante.TERRESTRE); //remove 2 terrestre
                                break;
                            }//fim do case 2
                            
                            case 3:{
                                mapaJogo.getTabuleiro().get(cordDest).removeExercito(Constante.AEREO); //remove 1 aereo
                                mapaJogo.getTabuleiro().get(cordDest).removeExercito(Constante.TERRESTRE);
                                mapaJogo.getTabuleiro().get(cordDest).removeExercito(Constante.TERRESTRE); 
                                mapaJogo.getTabuleiro().get(cordDest).removeExercito(Constante.TERRESTRE);//remove 3 terrestres
                                break;
                            }//fim do case 3
                        }//fim doc case interno
                    }
                break;
                }//fim do case aereo
                    
            }//fim da clausula switch
        }while( acao != 0);
    }
    
    public void alocar(Jogador jogador){
        
    }
}
