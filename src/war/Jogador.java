/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Jogador {
    
    //cor para representar o jogador
    Cor cor;
    //lista de territorios conquistados pelo jogador 
    List<Territorio> terriConquistado = new ArrayList<>();
    //lista de ex. terrestre disponiveis para alocação
    List<Exercito> terDisp = new ArrayList<>();
    //lista de ex. aereos disponiveis para alocação
    List<Exercito> aerDisp = new ArrayList<>();
    //lista de instruções do jogador para alocar eercito caso 1
    List<ArgumentoAlocI> alocI = new ArrayList<>();
    // lista de intruçoes do jogador para alocar exercito caso 2
    List<ArgumentoAlocII> alocII = new ArrayList<>();
    //vetor de inteiros que armazena o resultado dos dados lançads
    int resultadosAtk[] = new int[3];
    //esquadrao de ataque combinado aereo
    AereoComb esquadrao = new AereoComb();
    //atributo que determina se o jogador venceu
    boolean ganhou;
    
    Jogador(Cor c){ //construtor
        cor = c;
    }
    

    /* metodo para adicionar a lista de territorios um novo conquisado
     * atualiza o campo dono do territorio
     */
    public void conqTerritorio(Territorio conquistado){
        terriConquistado.add(conquistado);
        conquistado.setDono(cor);
        ganhou = verificaGanhou();
    }
    
    //metodo para retornar o numero de territorios
    public int nroTerritorios(){ return terriConquistado.size();}
    
    //metodo para pegar a lista de territorios conquistados
    public List<Territorio> getTerritorio(){
        return terriConquistado;
    }
    
    //retorna cor que representa o jogador
    public Cor getCor(){return cor;}
    
    //metodo que retorna o nro de exercitos terrestre para alocação disponiveis
    public List<Exercito> getTerDisp(){
        return terDisp;
    }
    
    //metodo que retorna o nro de exercitos aereos disponiveis para alocação
    public List<Exercito> getAerDisp(){
        return aerDisp;
    }
    //metodo para retornar o numero de continentes
    public int nroExercitos(Exercito exercito){
        if(exercito instanceof Terrestre){
            return terDisp.size();
        }
        else{ return aerDisp.size();}
    }
    /* metodo para receber exercitos
     * Se o exercito for do tipo terrestre adiciona em terDisp
     * Se for aereo adiciona em aerDisp
     * polimorfismo sobrecarga interno
     */
    public void recebeExercito(Exercito novo){
        if (novo instanceof Terrestre){
            terDisp.add(novo);
        }
        else{
            aerDisp.add(novo);
        }
    }
    
    /* metodo para alocação de exercito
     * Utiliza polimorfismo para duas situações:
     * 1) alocar exercito disponivel em um territorio
     * 2) alocar exercito disponivel de um territorio para outro
     */
    
    //primeiro caso
    public void alocarExercito(Territorio destino, Exercito exercito){ 
        Scanner scan = new Scanner(System.in);
        int x; //variavel para o nro de exercitos a serem deslocados
        if(terriConquistado.contains(destino)){ //territorio pertence ao jogador
            do {    
                x = scan.nextInt();
            } while (x < nroExercitos(exercito)); //nro de exercitos disponiveis
            if (exercito instanceof Terrestre){
                for (int i = 0; i < x; i++) {
                    alocI.add(new ArgumentoAlocI(destino, exercito)); //adiciona a instruçao a lista
                    terDisp.remove(0); //remove o exercito da lista
                }
            }
            else{
                for (int i = 0; i < x; i++) {
                    alocI.add(new ArgumentoAlocI(destino, exercito)); //adiciona a instruçao a lista
                    aerDisp.remove(0); //remove o exercito da lista
                }
            }
        }       
    }
    
    //caso 2
    public void alocarExercito(Territorio origem, Territorio destino, Exercito exercito, int max){
        Scanner scan = new Scanner(System.in);
        int x; //variavel para numero de exercitos a serem deslocados
        //verifica se faz fronteira com o territorio e pertence ao atual jogador
        if (origem.fazFronteira.contains(destino) && (destino.getDono() == cor) ){
        do {
            x = scan.nextInt();
        } while (x < origem.getNroExercitos(exercito) && x <= max);
            for (int i = 0; i < x; i++) {
                alocII.add(new ArgumentoAlocII(origem, destino, exercito)); //adiciona a instrução a lista
                origem.removeExercito(exercito); //remove exercito do territorio de origem
            }
        }
    }
    
    /* metodo para executar as lista de instrução do jogador
     * recebe como parametro as duas lista de argumentos e executa elas
     * este metodo foi implementado para prevenção e tratamento de erro
     * no contexto do remanejamento de um exercito o mesmo nao podera ser realocado
     * mais de uma vez
     * a lista de instrução previne esse tipo de ação
     */
    public List<ArgumentoAlocI> commitJogadaI(){
       return alocI;
    }
    
    public List<ArgumentoAlocII> commitJogadaII(){
        return alocII;
    }    
    
    /* metodo para resetar as referefidas listas de instruções
     * deve ser chamada a cada fim de rodada
     */
    public void resetaMovimentos(){
        alocI.clear();
        alocII.clear();
    }
    
    /* metodo que inicia o ataque a um territorio
     * recebe como parametro o territorio alvo a ser atacado,
     * o territorio de origem do ataque
     * e o tipo de ataque (terrestre ou aereo)
     * o numero de exercitos deslocados para o ataque
     * este metodo nao implementara o metodo do commit
     * implementa o polimorfismo
     */
    public int[] atacarTerritorio(Territorio origem, Territorio alvo,
                                  Terrestre exercito, int nroAtk){
        //verifica restriçoes de ataque
        if(origem.podeAtacar() && alvo.podeSerAtacado(origem)){ //tem mais de 1 exercito e faz franteira
            for (int i = 0; i < nroAtk; i++){
               resultadosAtk[i] = exercito.combater();
            }
        }
        Arrays.sort(resultadosAtk);
        return resultadosAtk; //retorna o vetor de resultados
    }
    
    /* metodo para o atk caso aereo
     * o metodo recebe uma lista de para um ataque aereo combinado
     */
    public int[] atacarTerritorio(Aereo exercito, Territorio alvo){
        if(alvo.podeSerAtacado()){
            esquadrao.setEsquadrilha(alvo, this);
            for(int k = 0; k < esquadrao.getEsquadrilha().size(); k++){
                resultadosAtk[k] = exercito.combater();
            }
        }
        return resultadosAtk;
    }
    
    //metodo que verifica se o eujogador ven
    public boolean verificaGanhou(){
        int x = 0; //contador para numero de continentes conquistados
        for(Continente c :Continente.values()){
            if(terriConquistado.contains(c.getPaises())){
                x++;
            }
        }
        return(x>=2);
    }
    
    public void resetaAtks(){
        Arrays.fill(resultadosAtk, 0);
    }
}