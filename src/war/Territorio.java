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
    /* metodo para exercito exercito do territorio
     * utiliza sobrecarga interna
     */
    public void removeExercito(Exercito exercito){
        if (exercito instanceof Terrestre){
            exercitosT.remove(0);
        }
        else{
            exercitosA.remove(0);
        }      
    }
    
    public int getNroExercitos(Exercito exercito){
        if (exercito instanceof Terrestre){
            return exercitosT.size();
        }
        else{
            return exercitosA.size();
        }
    }
    public String getNome(){return nome;}
    
    public void setDono(Cor c){dono = c;}
    
    public int getCordX(){ return cordX;}
    
    public int getCordY(){ return cordY;}
    
}
