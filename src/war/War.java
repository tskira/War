/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */

public class War {
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Aereo teste = new Aereo();
        Terrestre teste1 = new Terrestre();
        WarControle.getInstance().setJogador(2);
        WarControle.getInstance().distribuirTerritorio();
        for(Jogador p: WarControle.getInstance().jogadores()){
            System.out.println("--------------------------------------------");
            for(Territorio t: p.getTerritorio()){
                System.out.println(t.getNome());
            }
        }
        System.out.println(teste1.Combater());
        System.out.println(teste.Combater());
    }
   
}
