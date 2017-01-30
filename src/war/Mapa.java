/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Usuario
 */
public class Mapa {
    
        Map<int[], Territorio> tabuleiro = new HashMap<>(); //mapa do jogo
        
        Mapa(){ //construtor
            for (Continente c : Continente.values()){ //que porra é essa???
                for(Territorio p: c.getPaises() ){
                    tabuleiro.put(new int[]{p.getCordX(),p.getCordY()}, p);
                }
            }
        }
        
        public Map<int[], Territorio> getTabuleiro(){
            return tabuleiro;
        }
        
}
