/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

import java.awt.Color;

/**
 *
 * @author Usuario
 */
public enum Cor {
    AZUL("Azul", Color.BLUE),
    AMARELO("Amarelo", Color.YELLOW),
    CINZA_MEIO_ESCURO("Cinza Meio Escuro", Color.DARK_GRAY),
    VERDE_LIMAO("Verde Limao", Color.GREEN),
    PINK_CHOKE("Pink Choke", Color.PINK),
    TRANSPARENTE("Transparente",Color.RED);

    private final String cor; //nome da cor
    private final Color color;
    
    Cor(String cor, Color c){
        this.cor = cor;
        this.color = c;
    }
    
    public String getCor(){
        return cor;
    }
    
    public Color getColor(){
        return color;
    }
}
