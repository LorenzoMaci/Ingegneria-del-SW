package Ingengeria_Del_SW.Auto.AutoMain;


import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import Ingengeria_Del_SW.Auto.Auto;

public class Main {
    private static List<Auto> l1 = List.of( new Auto("A", "BLU", 120.0, "Berlina"),
        new Auto("B", "ROSSO", 170.0, "Sportiva"),
        new Auto("C", "VERDE", 220.0, "SUV"));

    
    public static void main(String[] args){
        List<Auto> incremento = incrementoCosto(l1);
        System.out.println("incremento 5%: " + incremento);

        double sommaCosti = getSommaCosti(l1);
        System.out.println("Somma dei costi: " + sommaCosti);

        Optional<Double> minimocosto = minimoCosti(l1);
        System.out.println("Costo minimo: " + minimocosto);

        List<Auto> listaOrdinata = ordinaLista(l1);
        System.out.println("ListaOrdinata: " + listaOrdinata);

        Optional<Double> costomaggiore = costoMaggiore(l1);
        System.out.println("CostoMaggiore: " + costomaggiore);
    }
    

     public static List<Auto> incrementoCosto(List<Auto> l1){
        return l1.stream()
        .map(x -> new Auto(x.categoria(), x.colore(), x.costo()*(1.05), x.modello()))
        .collect(Collectors.toList());
    }


    //Somma dei costi di tutte le auto
    public static double getSommaCosti(List<Auto> l1){
        double costiauto = l1.stream()
        .mapToDouble(Auto::costo)
        .sum();

        return costiauto;
    }

    //Trovare il minimo dei costi delle istanze di auto
    public static Optional<Double> minimoCosti(List<Auto> l1){
        Optional<Double> minimo = l1.stream()
        .map(Auto::costo)
        .min(Double::compare);

        return minimo;
    }

    //Ordinare una Lista per costo
    public static List<Auto> ordinaLista(List<Auto> l1){
        return l1.stream()
        .sorted(Comparator.comparing(Auto::costo))
        .collect(Collectors.toList());
    }

    //auto con costo maggiore
    public static Optional<Double> costoMaggiore(List<Auto> l1){
        Optional<Double> costomaggiore = l1.stream()
        .map(Auto::costo)
        .max(Double::compare);

        return costomaggiore;
    }
}
