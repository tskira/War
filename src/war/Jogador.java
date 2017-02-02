/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

import java.util.ArrayList;
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
    //variavel para definir o jogador atual
    boolean atacante;
    //lista de instruções do jogador para alocar eercito caso 1
    List<ArgumentoAlocI> alocI = new ArrayList<>();
    
    Jogador(Cor c){ //construtor
        cor = c;
        atacante = false;
    }
    
    // metodos get e set para atributo atacante
    public void setAtacante(){
        atacante = !atacante;
    }
    
    public boolean getAtacante(){
        return atacante;
    }
    
    /* metodo para adicionar a lista de territorios um novo conquisado
     * atualiza o campo dono do territorio
     */
    public void conqTerritorio(Territorio conquistado){
        terriConquistado.add(conquistado);
        conquistado.setDono(cor);
    }
    
    //metodo para retornar o numero de territorios
    public int nroTerritorios(){ return terriConquistado.size();}
    
    //metodo para pegar a lista de territorios conquistados
    public List<Territorio> getTerritorio(){
        return terriConquistado;
    }
    
    //retorna cor que representa o jogador
    public Cor getCor(){return cor;}
    
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
     * utilização de polimorfismo para implemenação de diferentes contexto
     * 1) alocar exercito disponivel em um territorio
     * 2) alocar exercito disponivel de um territorio para outro
     */
    
    public void alocarExercito(Territorio destino, Exercito exercito){ //primeiro caso
        Scanner scan = new Scanner(System.in);
        int x; //variavel para o nro de exercitos a serem deslocados
        if(terriConquistado.contains(destino)){ //territorio pertence ao jogador
            do {    
                x = scan.nextInt();
            } while (x < nroExercitos(exercito));
            if (exercito instanceof Terrestre){
                for (int i = 0; i < x; i++) {
                    alocI.add(new ArgumentoAlocI(destino, exercito)); //adiciona a instruçao a lista
                    terDisp.remove(0);
                }
            }
            else{
                for (int i = 0; i < x; i++) {
                    alocI.add(new ArgumentoAlocI(destino, exercito)); //adiciona a instruçao a lista
                    aerDisp.remove(0);    
                }
            }
        }       
    }
    
    //caso 2
    public void alocarExercito(Territorio origem, Territorio destino, Exercito exercito){
        Scanner scan = new Scanner(System.in);
        int x; //variavel para numero de exercitos a serem deslocados
        if (origem.fazFronteira.contains(destino)){ //se faz fronteira com o territorio
        do {
            x = scan.nextInt();
        } while (x < origem.getNroExercitos(exercito));
            if(exercito instanceof Terrestre){
                for (int i = 0; i < x; i++) {
                    destino.recebeExercito(exercito);
                    origem.removeExercito(exercito);
                }
            }
            else{
                for (int i = 0; i < x; i++) {
                    destino.recebeExercito(exercito);
                    origem.removeExercito(exercito);
                }
            }
        }
        else{
            System.out.println("Movimento nao permitido");
        }
    }
    
    

}