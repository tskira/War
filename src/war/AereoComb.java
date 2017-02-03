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
public class AereoComb {
    
    List<Aereo> esquadrilha = new ArrayList<>();
    
    AereoComb(){} //construtor
    
    public List<Aereo> getEsquadrilha(){
        return esquadrilha;
    }
    
    /* o metodo a seguir 
    public void setEsquadrilha(Territorio alvo, Jogador player){
        //lista para armazenar range do atk
        List<Territorio> range = new ArrayList<>();
        //definindo a range do atk
        for(Territorio t: alvo.fronteira()){
            if(t.dono == player.cor && t.getNroExercitos(Constante.AEREO) > 0 ){
                System.out.println(t.getNome());
                Scanner scan = new Scanner(System.in);
                //verifica da onde vai partir o atk
                if (scan.nextInt() == 1){
                    range.add(t);
            }
        }
        int x = range.size(); //pega o numero de territorios vizinho ao alvo
        for(Te){
            
        }
    
    }
    
}
