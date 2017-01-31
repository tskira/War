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
    
    Cor cor;
    List<Territorio> terriConquistado = new ArrayList<>(); 
    List<Terrestre> terrestreDisp = new ArrayList<>();//lista de exercitos terrestre nao alocados 
    List<Aereo> aereoDisp = new ArrayList<>();//lista de exercitos aereos nao alocados
    
    Jogador(Cor c){
        cor = c;
    }
    
    public void conqTerritorio(Territorio c){terriConquistado.add(c);}
    
    public Cor getCor(){return cor;}
    
    public void moveExercito(Territorio ori, Territorio Dest){
        //implementar
    }
    
    public void receberExercitoT(){
        for (int i = 0; i < (terriConquistado.size())/2; i++) {
            terrestreDisp.add(new Terrestre());
        }
    }
    
    public void receberExercitoA(){
        for (int i = 0; i < (terriConquistado.size())/3; i++) {
            terrestreDisp.add(new Terrestre());
        }
    }
    public int nroTExerc(){ return terrestreDisp.size();};
    
    
    public void alocarExercitoT(Territorio dest){
        Scanner in = new Scanner(System.in);
        int j = in.nextInt();
        if( j >= nroTExerc()){
            for (int i = 0; i < j; i++) {
                terrestreDisp.remove(0);
                dest.addTExercito();
            }
        }
        else{
            System.out.println("movimento nao permitido");
        }
    }
    
}
