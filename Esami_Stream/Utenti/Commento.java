package Ingengeria_Del_SW.Utenti;

import java.time.LocalDate;

public class Commento {
    private String testo;
    private LocalDate data;
    
    public Commento(String testo, LocalDate localDate){
        this.testo = testo;
        this.data = localDate;
    }


    public String testo(){
        return testo;
    }

    public LocalDate data(){
        return data;
    }
}
