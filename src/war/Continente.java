/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.util.Pair;

/**
 *
 * @author Usuario
 */
public enum Continente {
    
    AFRICA("Africa");
    
    private final String nome; //nome do continente
    private final Map<int[], Territorio> paises = new HashMap<>();
    
    Continente(String nome){
        this.nome = nome;
    }
    
    public Map<int[], String> getPaises(){
        return paises;
    }
}
