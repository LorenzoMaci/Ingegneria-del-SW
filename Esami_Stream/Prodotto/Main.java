package Ingengeria_Del_SW.Esame.Prodotto;

import java.util.Comparator;
import java.util.List;

// Data una lista di prodotti, restituire il costo totale dei prodotti che hanno un prezzo maggiore di 10.
// Restituire il prodotto più economico 
// Restituire la somma totale dei costi dei 2 prodotti meno cari

public class Main {
    public static List<Prodotto> lista = List.of(new Prodotto("p1", 5.0), 
                                       new Prodotto("p2", 10.0),
                                       new Prodotto("p3", 15.0), 
                                       new Prodotto("p4", 20.0));
    public static void main(String[] args){
        System.out.println("\nIl costo totale è: " + costoTot());
        //Prodotto economic = economico();
        System.out.println("\nil prodotto più economico è: " + economico().nome() + " " + economico().prezzo());
        System.out.println("\nSomma prodotti meno cari: " + sommaMenoCari());
    }


    public static double costoTot(){
        return lista.stream()
        .filter(x-> x.prezzo() > 10.0)
        .mapToDouble(p->p.prezzo())
        .sum();
    }

    public static double minimo(){
        return lista.stream()
        .mapToDouble(Prodotto::prezzo)
        .min()
        .orElse(0.0);
    }
    
    public static Prodotto economico(){
        return lista.stream()
        .min(Comparator.comparingDouble(Prodotto::prezzo))
        .get();
    }

    public static double sommaMenoCari(){
        double somma =  lista.stream()
        .filter(x-> x.prezzo() > minimo())
        .map(p->p.prezzo())
        .min(Comparator.naturalOrder())
        .orElse(0.0);

        return somma + minimo();
    }
}
