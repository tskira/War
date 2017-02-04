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
public class Territorio {
    
    String nome; //nome do territorio
    int cordX; //cordenadas no mapa
    int cordY; //cordenadas no mapa
    List<Territorio> fazFronteira = new ArrayList<>(); //paises vizinhos
    List<Exercito> exercitosT = new ArrayList<>(); //exercitos terrestre
    List<Exercito> exercitosA = new ArrayList<>(); //exercitos aereos
    Cor dono; //cor do atual dono do territorio
    //vetor com resultados de defesa
    int resultadosDef[] = new int[3];
    
    Territorio(String nome, int x, int y){ //construtor
        this.nome = nome;
        cordX = x;
        cordY = y;
    }
    
       
    //alguns metodos get e set
    
    public String getNome(){return nome;}
    
    public void setDono(Cor c){dono = c;}
    
    public Cor getDono(){ return dono;}
    
    public int getCordX(){ return cordX;}
    
    public int getCordY(){ return cordY;}
    
    // metodo para pegar os paises fronteira
    public List<Territorio> fronteira(){
        return fazFronteira;
    }
    
    /* metodo para atribuir exercito a um territorio
     * utiliza sobrecarga interna
     */
    public void recebeExercito(Exercito exercito){
        if (exercito instanceof Terrestre){
            exercitosT.add(exercito);
        }
        else{
            exercitosA.add(exercito);
        }
    }
 
    /* metodo para exercito exercito do territorio
     * utiliza sobrecarga interna
     */
    public void removeExercito(Exercito exercito){
        if (exercito instanceof Terrestre){
            exercitosT.remove(0);
        }
        else{
            exercitosA.remove(0);
        }      
    }
    
    /* metodo para retornar o numero de exercitos
     * de acordo com o parametro retorna o tamanho de aereo ou terrestre
     */
    public int getNroExercitos(Exercito exercito){
        if (exercito instanceof Terrestre){
            return exercitosT.size();
        }
        else{
            return exercitosA.size();
        }
    }
    
    /* os metodos a seguir verificar a possibilidade de atacar determinado territorio
     * utiliza polimorfismo
     */
    
    //primeiro caso pra um ataque terrestre
    public boolean podeSerAtacado(Territorio origem){
        return (fazFronteira.contains(origem));
    }
    //segundo caso para um ataque aereo
    public boolean podeSerAtacado(){
        return ((getNroExercitos(Constante.TERRESTRE) > 3 )&& 
                 getNroExercitos(Constante.AEREO) > 1 );
    }
    
    //metodo que verifica a permanencia de pelo menos 1 exercito no territorio
    public boolean podeAtacar(){
        return (getNroExercitos(Constante.TERRESTRE)>0);
    }
    
    /* metedo chamado para defesa de um territorio ao ser atacado
     * implementa polimorfismo para caso de defesa terrestre ou aerea
     */

    public int[] defender(Terrestre exercito){
        if(exercitosT.size()>=3){
            for(int i = 0; i < 3; i++){
                resultadosDef[i] = exercito.combater();
            }
        }
        else{
            for(int i = 0; i < exercitosT.size(); i++){
                resultadosDef[i] = exercito.combater();
            }
        }
        Arrays.sort(resultadosDef);
        return resultadosDef;
    }
    
        public int[] defender(Aereo exercito){
        if(exercitosT.size()>=3){
            for(int i = 0; i < 3; i++){
                resultadosDef[i] = exercito.combater();
            }
        }
        else{
            for(int i = 0; i < exercitosT.size(); i++){
                resultadosDef[i] = exercito.combater();
            }
        }
        Arrays.sort(resultadosDef);
        return resultadosDef;
    }
}
