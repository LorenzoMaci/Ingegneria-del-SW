package Ingengeria_Del_SW.Esame.People;

public class People {
    private String name;
    private int eta;
    private String nazione;

    public People(String name, int eta, String nazione){
        this.name = name;
        this.eta = eta;
        this.nazione = nazione;
    }

    public String name(){
        return name;
    }

    public int eta(){
        return eta;
    }

    public String nazione(){
        return nazione;
    }
}
