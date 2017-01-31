/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

/**
 *
 * @author Usuario
 */
public enum Cor {
    AZUL("Azul"),
    ROXO("Roxo"),
    CINZA_MEIO_ESCURO("Cinza Meio Escuro"),
    VERDE_LIMAO("Verde Limao"),
    PINK_CHOKE("Pink Choke"),
    TRANSPARENTE("Transparente");

    private final String cor; //nome da cor
    
    Cor(String cor){
        this.cor = cor;
    }
    
    public String getCor(){
        return cor;
    }  
}
