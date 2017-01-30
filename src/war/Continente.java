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
    
    AFRICA("Africa", Pair.with("Nigeria", int num[] = {3,4})),
    AMERICA_NORTE("America do Norte",
            Arrays.asList("Alasca", "Vancouver", "California", "Groenlandia",
                          "Otawa", "Mexico", "Nova York")
    ),
    AMERICA_SUL("America do Sul",
            Arrays.asList("Chile", "Colombia", "Argentina", "Brasil")
    ),
    ASIA("Asia",
            Arrays.asList("Vladivostok", "Omsk", "Siberia", "Oriente Medio",
                          "India", "China", "Japao")
    ),
    EUROPA("Europa",
            Arrays.asList("Inglaterra", "Italia", "Suecia", "Alemanha",
                          "Moscou")
    ),
    OCEANIA("Oceania",
            Arrays.asList("Sumatra", "Borneu", "Australia", "Nova Guine")
    );
    
    private final String nome; //nome do continente
    private final Map<int[], Territorio> paises = new HashMap<>();
    
    Continente(String nome, Pair<int[], String>){
        this.nome = nome;
    }
    
    public List<Territorio> getPaises(){
        return paises;
    }
}
