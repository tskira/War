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
    List<Terrestre> exercitosT = new ArrayList<>(); //exercitos terrestre
    List<Aereo> exercitosA = new ArrayList<>(); //exercitos aereos
    Cor dono; //cor do atual dono do territorio
    
    Territorio(String nome, int x, int y){ //construtor
        this.nome = nome;
        cordX = x;
        cordY = y;
    }
    
    public String getNome(){return nome;}
    
    public void setDono(Cor c){dono = c;}
    
    public Cor getDono(){ return this.dono;}
    
    public int getCordX(){return cordX;}
    
    public int getCordY(){return cordY;}
    
    public int getTExercito(){ return exercitosT.size();}
    
    public int getAExercito(){ return exercitosA.size();}
        
    public void addTExercito(){exercitosT.add(new Terrestre());}
    
    public void addAExercito(){exercitosA.add(new Aereo());}
    
    public void remTExercito(){exercitosT.remove(0);}
    
    public void remAExercito(){ exercitosA.remove(0);}
}
