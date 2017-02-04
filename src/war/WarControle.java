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
  
    public void distribuição(Jogador jogador){
        Scanner scan = new Scanner(System.in);
        int cord[] = new int[2]; //inteiro para armazenar cordenada
        while(jogador.getTerDisp().isEmpty()){ //enquanto houverem eercitos terrestre disponiveis
            cord[0] = scan.nextInt();
            cord[1] = scan.nextInt();
            jogador.alocarExercito(mapaJogo.getTabuleiro().get(cord), jogador.getTerDisp().get(0));
        } // alocou todos os exercitos terrestres disponiveis
        while(jogador.getAerDisp().isEmpty()){ //enquanto houverem eercitos terrestre disponiveis
            cord[0] = scan.nextInt();
            cord[1] = scan.nextInt();
            jogador.alocarExercito(mapaJogo.getTabuleiro().get(cord), jogador.getAerDisp().get(0));
        } //alocou todos os aereos disponiveis
        
    }
    
}
