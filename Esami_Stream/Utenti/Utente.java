package Ingengeria_Del_SW.Utenti;

import java.util.List;

public class Utente {
    private String nome;
    private List<Commento> commenti;

    public Utente(String nome, List<Commento> commenti){
        this.nome = nome;
        this.commenti = commenti;
    }

    public String nome(){
        return nome;        
    }

    public List<Commento> commenti(){
        return commenti;
    }
}
