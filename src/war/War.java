/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

import java.util.Arrays;

/**
 *
 * @author Usuario
 */

public class War {
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        int[] a = new int[3];
        int[] b = {3,6,1};
        
        Arrays.sort(b);
        a = b;
        WarControle.getInstance().setJogador(2);
        WarControle.getInstance().distribuirTerritorio();
        for(Jogador p: WarControle.getInstance().jogadores()){
            System.out.println("--------------------------------------------");
            for(Territorio t: p.getTerritorio()){
                System.out.println(t.getNome());
            }
        }
       // System.out.println(Constante.AEREO.combater());
       // System.out.println(Constante.TERRESTRE.combater());
        for(int i: a){
            System.out.println(i);
    
        }
    }    
   
}
