package Ingengeria_Del_SW.Esame.Prodotto;


public class Prodotto {
    private String nome;
    private double prezzo;

    public Prodotto(String n, double p){
        nome = n;
        prezzo = p;
    }

    public String nome(){
        return nome;
    }

    public Double prezzo(){
        return prezzo;
    }
}

