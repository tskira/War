/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

import java.util.List;

/**
 *
 * @author Usuario
 */
public class Jogador {
    
    Cor cor;
    List<Territorio> terriConquistado; //lista com territorios conquistados
    
    Jogador(Cor c){
        cor = c;
    }
    
    public void conqTerritorio(Territorio c){//adiciona novo territorio conquistado
        terriConquistado.add(c);
    }
}
