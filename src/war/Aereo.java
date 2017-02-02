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
public class Aereo extends Exercito{
    
    Aereo(){};
    
    @Override
    public int Combater(boolean atacante){
        return Dado.AZUL.lancar();
    };
    
}
