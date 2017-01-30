/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class WarControle {
    
    
    List<Jogador> players = new ArrayList<>(); //lista para jogadores no jogo
    Mapa mapaJogo = new Mapa();
    
    public void setJogador(int i){ //adiciona jogadores ao jogo
        for (int j = 0; j < i; j++) {
            players.add(new Jogador(Cor.values()[j]));
        }
    }
    
    public void distribuirTerritorio(){ //distribuição de territorio aleatoria entre os jogadores
        for(Territorio c: mapaJogo.getTabuleiro().values()){
            c.setDono(players.get((int)(Math.random() * players.size())).getCor());
        }
    }
    
    public int numeroPlayers(){ //retorna numero de jogadores
        return players.size();
    }
    
    WarControle(){}; //construtor
}
