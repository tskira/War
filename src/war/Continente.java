/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Usuario
 */
public enum Continente {
    
    AFRICA("Africa",new Territorio[]{
        new Territorio("Nigeria", 3, 4),
        new Territorio("Egito", 3, 5),
        new Territorio("Congo", 4, 4),
        new Territorio("Africa do Sul", 5, 4),
        new Territorio("Madagascar", 5, 5)
    }),

    AMERICA_NORTE("America do Norte", new Territorio[]{
        new Territorio("Alasca", 1, 1),
        new Territorio("Vancouver", 1, 2),
        new Territorio("Groenlandia", 1, 3),
        new Territorio("California", 2, 2),
        new Territorio("Otawa", 2, 3),
        new Territorio("Mexico", 3, 2),
        new Territorio("Nova York", 3, 3)
    }),
    
    AMERICA_SUL("America do Sul", new Territorio[]{
        new Territorio("Chile", 4, 1),
        new Territorio("Colombia", 4, 2),
        new Territorio("Argentina", 5, 1),
        new Territorio("Brasil", 5, 2)
    }),
    
    ASIA("Asia", new Territorio[]{
        new Territorio("Vladivostok", 1, 8),
        new Territorio("Omsk", 2, 7),
        new Territorio("Siberia", 2, 8),
        new Territorio("Oriente Medio", 3, 6),
        new Territorio("India", 3, 7),
        new Territorio("China", 3, 8),
        new Territorio("Japao", 4, 8)
    }),
    
    EUROPA("Europa", new Territorio[]{
        new Territorio("Inglaterra", 1, 4),
        new Territorio("Italia", 1, 5),
        new Territorio("Suecia", 1, 6),
        new Territorio("Alemanha", 2, 5),
        new Territorio("Moscou", 2, 6)
    }),
    
    OCEANIA("Oceania", new Territorio[]{
        new Territorio("Sumatra", 4, 6),
        new Territorio("Borneu", 4, 7),
        new Territorio("Australia", 5, 7),
        new Territorio("Nova Guine", 5, 8)
    });
    
    private final String nome; //nome do continente
    private final List<Territorio> paises = new ArrayList<>();
    
    Continente(String nome, Territorio[] p){
        this.nome = nome;
        paises.addAll(Arrays.asList(p));
    }
    
    public List<Territorio> getPaises(){
        return paises;
    }
}
