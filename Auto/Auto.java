package Ingengeria_Del_SW.Auto;

public class Auto{
    private String categoria,  colore,  modello;
    private Double costo;

    public Auto(String categoria, String colore, Double costo, String modello){
        this.categoria = categoria;
        this.colore = colore;
        this.costo = costo;
        this.modello = modello;
    }

    public String categoria(){
        return categoria;
    }

    public String colore(){
        return colore;
    }

    public String modello(){
        return modello;
    }

    public Double costo(){
        return costo;
    }

 
}
