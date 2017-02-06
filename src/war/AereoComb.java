/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class AereoComb {
    
    List<Territorio> esquadrilha = new ArrayList<>();
    
    AereoComb(){} //construtor
    
    public List<Territorio> getEsquadrilha(){
        return esquadrilha;
    }
    
    /* o metodo a seguir implementa a formação de uma esquadrilha para atk aereo
     * toma como base as restrições de atk aereo 
     */
    public void setEsquadrilha(Territorio alvo, Jogador player){
        //lista para armazenar range do atk
        List<Territorio> range = new ArrayList<>();
        //nro de exercitos utilizado na esquadrilha
        int max;
        //definindo a range do atk
        for(Territorio t: alvo.fronteira()){
            if(t.dono == player.cor && t.getNroExercitos(Constante.AEREO) > 0 ){
                System.out.println(t.getNome());
                Scanner scan = new Scanner(System.in);
                //verifica da onde vai partir o atk
                if (scan.nextInt() == 1){ //selecionou
                    range.add(t);
                    esquadrilha.add(t);
                }
            }
        }
        max = range.size(); //pega o numero de territorios vizinhos ao alvo que foram selecionados como origem do atk
        if(max <= Constante.MAXIMO){
            for(int j = 0; j < max; j++ ){ //determinando a qual continente pertence
                for(Continente c: Continente.values()){
                    if(c.getPaises().contains(range.get(j))){
                        range.addAll(c.getPaises()); //axou o continente e add os paises
                        for(String n : c.getAdj()){
                            for(Continente ca: Continente.values()){
                                if( n == ca.getNome()){
                                    range.addAll(ca.getPaises()); //adiciona os paises dos continentes vizinhos
                                }
                            }
                        }   
                    }
                }
            }
        } //fim do if esquisito ali
        //termina de adicionar exercitos para o atk
        while(esquadrilha.size() <= Constante.MAXIMO){
            Scanner in = new Scanner(System.in);
            int cord[] = new int[2]; //cordenadoas
            cord[0] = in.nextInt();
            cord[1] = in.nextInt();
            if(range.contains(
                        WarControle.getInstance(). //singleton
                        getMapaJogo(). //classe mapa do singleton
                        getTabuleiro(). //tabuleiro do jogo
                        get(cord))){ //territorio selecionado
                        esquadrilha.add(WarControle.getInstance().
                                        getMapaJogo().
                                        getTabuleiro().
                                        get(cord)); //territorio do exercito fonte adicionado
                        }
        } //fim desse bagui loco
    }
}
