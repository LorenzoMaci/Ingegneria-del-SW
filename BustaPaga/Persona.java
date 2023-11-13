package Ingengeria_Del_SW.BustaPaga;

/*Classe Persona con nome e Età
 * 1) metodo che mi restituisce true se la persona ha un età < 28
 * 2) metodi get
 * 3) un metodo che mi restituisce true se il ruolo è uguale al ruolo in input
 */

public class Persona {
    private String nome;
    private int eta;
    private String ruolo;

    public Persona(String n, int e, String ruolo){
        this.nome = n;
        this.eta = e;
        this.ruolo = ruolo;
    }

    public boolean giovane(){
        return eta < 28;
    }

    public int getEta(){
        return eta;
    }

    public String getNome(){
        return nome;
    }

    public String getRuolo(){
        return ruolo;
    }

    public boolean isRuolo(String r){
        return ruolo.equals(r);
    }
}

