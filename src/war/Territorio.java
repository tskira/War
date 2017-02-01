    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Territorio {
    
    String nome; //nome do territorio
    int cordX; //cordenadas no mapa
    int cordY; //cordenadas no mapa
    List<Territorio> fazFronteira = new ArrayList<>(); //paises vizinhos
    List<Exercito> exercitosT = new ArrayList<>(); //exercitos terrestre
    List<Exercito> exercitosA = new ArrayList<>(); //exercitos aereos
    Cor dono; //cor do atual dono do territorio
    
    Territorio(String nome, int x, int y){ //construtor
        this.nome = nome;
        cordX = x;
        cordY = y;
    }
    
    /* metodo para atribuir exercito a um territorio
     * utiliza sobrecarga interna
     */
    public void recebeExercito(Exercito exercito){
        if (exercito instanceof Terrestre){
            exercitosT.add(exercito);
        }
        else{
            exercitosA.add(exercito);
        }
    }
    
    public void setFronteira(Mapa mapa ){
        fazFronteira.add(mapa.get());
    }
    
    public String getNome(){return nome;}
    
    public void setDono(Cor c){dono = c;}
    
    public Cor getDono(){ return this.dono;}
    
}
