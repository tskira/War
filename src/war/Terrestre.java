/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

/**
 *
 * @author Usuario
 */
public class Terrestre extends Exercito {
    
    Terrestre(){};
    
    @Override
    public int Combater(boolean atacante){
        return (atacante ? Dado.VERMELHO.lancar()
                         : Dado.AMARELO.lancar());
    }
}
