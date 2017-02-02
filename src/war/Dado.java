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
public enum Dado {
    
    AZUL(0,4), //dado para atk aereo
    LARANJA(1,6), //dado para atk terrestre
    PRETO(7,7); //dado para roubar no jogo
    
    private final int ini; //range do dado (valor inicial)
    private final int fin; //range do dado (valor final)

    Dado(int ini, int fin) { 
        this.ini = ini;
        this.fin = fin;
    }
    
    public int lancar(){ //metodo para lançar um dado
        return ((int)(Math.random()*fin + ini));
    }

}
