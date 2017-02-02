/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

/**
 * Classe para criaçao de lista de instruçoes
 * Implementa argumentos para o metodo de alocarExercito caso 2
 * @author Usuario
 */
public class ArgumentoAlocII {
    
    Territorio origem;
    Territorio destino;
    Exercito exercito;
    
    ArgumentoAlocII(Territorio o, Territorio d, Exercito e){
        origem = o;
        destino = d;
        exercito = e;
    }
    
    public Territorio getOrigem(){
        return origem;
    }
    
    public Territorio getDestino(){
        return destino;
    }
    
    public Exercito getExercito(){
        return exercito;
    }
}
