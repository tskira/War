/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

/**
 * Classe para criar lista de intruções
 * para evitar alguns erros as jogadas deverao ser adicionadas a uma lista de argumentos
 * na sequencia o jogador da "commit" na lista, confirmando suas instruções
 * assim as instruções sao realizadas
 * Argumentos para metodo de alocarExercito, caso 1
 * @author Usuario
 */
public class ArgumentoAlocI {
    
    Territorio destino;
    Exercito exercito;
    int nro;
    
    ArgumentoAlocI(Territorio t, Exercito e ){
        destino = t;
        exercito = e;
    }
    
   public Territorio getTerritorio(){return destino;}
   public Exercito getExercito(){return exercito;}
}
