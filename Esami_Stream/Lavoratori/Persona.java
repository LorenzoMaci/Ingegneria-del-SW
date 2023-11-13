package Ingengeria_Del_SW.Esame.Lavoratori;

/*Classe Persona con nome e Età
 * 1) metodo che mi restituisce true se la persona ha un età < 26
 */

public class Persona {
    private String nome;
    private int eta;
    
    public Persona(String nome, int eta){
        this.nome = nome;
        this.eta = eta;
    }

    public int eta(){
        return eta;
    }

    public String nome(){
        return nome;
    }

    public boolean giovane(){
        return eta < 26;
    }
}
