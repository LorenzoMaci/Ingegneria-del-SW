package Ingengeria_Del_SW.Esame.People;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    private static List<People> lista = List.of(new People("p1", 10, "n1"),
                                     new People("p2", 20, "n1"),
                                     new People("p3", 30, "n2"),
                                     new People("p4", 40, "n3"),
                                     new People("p5", 50, "n3"));
     public static void main(String[] args){
        int min = 20;
        int max = 40;

    
        List<String> personeFiltrate = etaMedia(min, max)
                .stream()
                .map(p -> p.name() + " " + p.eta() + " " + p.nazione())
                .collect(Collectors.toList());

        System.out.println("Le persone con un'età media sono:");
        for (String persona : personeFiltrate) {
            System.out.println(persona);
        }

        System.out.println("\nLa somma dell'età delle persone è: " + sommaEta());

        System.out.println("Lista delle nazioni senza ripetizioni: " + nazioniSenzaRipetizione());

        System.out.println("\nMapper con nome e nazione: " + personePerNazione());
    }

    // Creare un metodo che prende in ingresso due parametri, min e max, e restituisce una lista di 
    // istanze di persona costituita da elementi di gente che hanno età compresa fra min e max.
    public static List<People> etaMedia(int min, int max){
        return lista.stream()
        .filter(x->x.eta() >= min)
        .filter(x->x.eta() <= max)
        .collect(Collectors.toList());
    }

     // Calcolare la somma delle età di tutte le persone nella lista
    public static int sommaEta(){
        return lista.stream()
        .mapToInt(People::eta)
        .sum();
    }

     // Restituire la lista di nazioni senza ripetizioni presenti in una lista di gente
    public static List<String> nazioniSenzaRipetizione(){
        return lista.stream()
        .map(People::nazione)
        .distinct()
        .collect(Collectors.toList());
    }
    
    // Restituire una mappa contenente le coppie (nome persone - nazione)
    public static Map<String, String> personePerNazione() {
        return lista.stream()
                .collect(Collectors.toMap(People::name, People::nazione));
    }
}
