package Ingengeria_Del_SW.Esame.Libro;


/*
  * Usando la programmazione funzionale di Java, dato una lista lib di istanza di Libro, 
 * implemenate una classe con: 
 * 1) un metodo che restituisce una lista dei pesi dei libri presenti in lib. 
 * 2) un metodo  che restituisce la lista concatenata della somma dei costi dei libri di ciascun genere di libri presenti in lib. 
 * 3) un metodo che restituisce il libro di genere Giallo, che ha il costo maggiore. 
 * 4) un metodo che restitusice la lista di autori delle istanze di lib senza ripetizione
 */


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static List<Libro> lib = List.of(new Libro("Il nome della rosa", 400, 7.30, "Giallo", "Umberto Ego"),
    new Libro("Il codice da Vinci", 300, 8.90 ,"Thriller", "Dan Brown"), new Libro("Harry Potter e la pietra filosofale",  200, 9.50 ,"Fantasy", "J.K. Rowling"),
    new Libro("Sherlock Holmes1", 250, 14.15, "Giallo", "Conan Doyle"), new Libro("Sherlock Holmes2", 350, 15.10, "Giallo", "Conan Doyle"));

    public static void main(String[] args){
        System.out.println("\nLista pesi Libri: " + pesiLibri());

        System.out.println("\nSomma Costi Per Genere:" + sommaCostiperGenere());

        Libro giallo = getGiallomax();
        System.out.println("\nIl Libro giallo con Costo Maggiore è: " + giallo.titolo() + " " + giallo.costo() + "$ " + giallo.genere() + " " + giallo.autore());

        System.out.println("\nLista ordinata di Autori: " + listaordinataAutori());
    }

    public static List<Double> pesiLibri(){
        return lib.stream()
        .map(Libro::peso)
        .collect(Collectors.toList());
    }

    public static List<Double> sommaCostiperGenere(){
        return lib.stream()
        .collect(Collectors.groupingBy(Libro::genere, Collectors.summingDouble(Libro::costo)))
        .values()
        .stream()
        .collect(Collectors.toList());
    }

    public static Libro getGiallomax(){
        return lib.stream()
        .filter(x -> x.genere() == "Giallo")
        .max(Comparator.comparing(Libro::costo))
        .get();
    }

    public static List<String> listaordinataAutori(){
        return lib.stream()
        .map(Libro::autore)
        .distinct()
        .collect(Collectors.toList());
    }

}