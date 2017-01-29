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
    List<Territorio> fazFronteira = new ArrayList<Territorio>(); //paises vizinhos
    List<Exercito> exercitosT = new ArrayList<Exercito>(); //exercitos
    List<Exercito> exercitosA = new ArrayList<Exercito>();
    Cor dono; //cor do atual dono do territorio
    
    Territorio(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setDono(Cor c){
        dono = c;
    }
    
    public Cor getDono(){
        return this.dono;
    }
    
}
