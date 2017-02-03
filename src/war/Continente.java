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
        new Territorio("Nigeria", 2, 3),
        new Territorio("Egito", 2, 4),
        new Territorio("Congo", 3, 3),
        new Territorio("Africa do Sul", 4, 3),
        new Territorio("Madagascar", 4, 4)
        },
        new String[] {
            "America do Norte",
            "Europa",
            "Asia",
            "Oceania",
        }
        
    ),

    AMERICA_NORTE("America do Norte", new Territorio[]{
        new Territorio("Alasca", 0, 0),
        new Territorio("Vancouver", 0, 1),
        new Territorio("Groenlandia", 0, 2),
        new Territorio("California", 1, 1),
        new Territorio("Otawa", 1, 2),
        new Territorio("Mexico", 2, 1),
        new Territorio("Nova York", 2, 2)
        },
        new String[] {
            "Europa",
            "America do Sul",
            "Africa"
        }
    ),
    
    AMERICA_SUL("America do Sul", new Territorio[]{
        new Territorio("Chile", 3, 0),
        new Territorio("Colombia", 3, 1),
        new Territorio("Argentina", 4, 0),
        new Territorio("Brasil", 4, 1)
        },
        new String[]{
            "America do Norte"
        }
    ),
    
    ASIA("Asia", new Territorio[]{
        new Territorio("Vladivostok", 0, 7),
        new Territorio("Omsk", 1, 6),
        new Territorio("Siberia", 1, 7),
        new Territorio("Oriente Medio", 2, 5),
        new Territorio("India", 2, 6),
        new Territorio("China", 2, 7),
        new Territorio("Japao", 3, 7)
    },
        new String[]{
            "Europa",
            "Oceania",
            "Africa"
        }
    ),
    
    EUROPA("Europa", new Territorio[]{
        new Territorio("Inglaterra", 0, 3),
        new Territorio("Italia", 0, 4),
        new Territorio("Suecia", 0, 5),
        new Territorio("Alemanha", 1, 4),
        new Territorio("Moscou", 1, 5)
    },
        new String[] {
            "America do Norte",
            "Africa",
            "Asia"
        }
    ),
    
    OCEANIA("Oceania", new Territorio[]{
        new Territorio("Sumatra", 3, 5),
        new Territorio("Borneu", 3, 6),
        new Territorio("Australia", 4, 6),
        new Territorio("Nova Guine", 4, 7)
    },
        new String[] {
            "Africa",
            "Asia"
        }
    );
    
    private final String nome; //nome do continente
    private final List<Territorio> paises = new ArrayList<>();
    private final List<String> adjacentes = new ArrayList<>();
    
    Continente(String nome, Territorio[] p, String[] a){
        this.nome = nome;
        paises.addAll(Arrays.asList(p));
        adjacentes.addAll(Arrays.asList(a));
    }
    
    public List<Territorio> getPaises(){
        return paises;
    }
    
}
