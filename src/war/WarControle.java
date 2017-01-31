/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  
 * @author Usuario
 */
public class WarControle {
    
    private static List<Jogador> players = new ArrayList<>(); //lista para jogadores no jogo
    private static Mapa mapaJogo = new Mapa(); //mapa do jogo
    
    private WarControle() { //construtor
    }
    
    public static WarControle getInstance() { //singleton
        return WarControleHolder.INSTANCE;
    }
    
    private static class WarControleHolder { //singleton
        private static final WarControle INSTANCE = new WarControle();
    }
    
    //metodo que retorna numero de jogadores
    public static int numeroPlayers(){ return players.size(); }
    
    //metodo para adicionar o numero de jogadores
    public static void setJogador(int i){ 
        for (int j = 0; j < i; j++) {
            players.add(new Jogador(Cor.values()[j]));
        }
    }
    
    //metodo para distribuição de territorios
    public static void distribuirTerritorio(){
        List<Territorio> init = new ArrayList<>(); //lista para armazenar os territorios
        for(Territorio c: mapaJogo.getTabuleiro().values()){ //adiciona os territorios a lista
            init.add(c);
        }
        Collections.shuffle(init); // embaralha lista
        for (int i = 0; i < init.size(); i++) {
            players.get(i% numeroPlayers()).conqTerritorio(init.get(i));
        }
        
    }
    
}
