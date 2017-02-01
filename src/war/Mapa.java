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
    
        Map<int[], Territorio> mapa = new HashMap<>(); //mapa do jogo
        
        Mapa(){ //construtor
            for (Continente c : Continente.values()){ //que porra é essa???
                for(Territorio p: c.getPaises() ){
                    mapa.put(new int[]{p.getCordX(),p.getCordY()}, p);
                }
            }
        }
        
        /* metodo para retornar a lista de paises vizinhos
         * recebe um territorio como referencia
         * determina e retorna a lista de seus vizinhos
         */
        
        public List<Territorio> setVizinhos(Territorio territorio){
            
        }    
        
        public Map<int[], Territorio> getTabuleiro(){return mapa;}
        
}
