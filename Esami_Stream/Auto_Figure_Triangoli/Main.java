package Ingengeria_Del_SW.Esame.AUTO_FIGURE.prova2;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import Ingengeria_Del_SW.Auto.Auto;
import Ingengeria_Del_SW.Figura.OperazioniFigura.Figura;
import Ingengeria_Del_SW.Terne_Triangoli.Triangolo.Triangolo;

public class Main{

    private static List<Auto> al = List.of( new Auto("A", "BLU", 120.0, "Berlina"),
        new Auto("B", "ROSSO", 170.0, "Sportiva"),
        new Auto("C", "VERDE", 220.0, "SUV"));

    private static List<Figura> figure = List.of( new Figura(1, 2, 3, 4, 5, 6, 7, 8),
          new Figura(2, 3, 4, 5, 6, 7, 8, 9),
          new Figura(3, 4, 5, 6, 7, 8, 9, 10));

    private static List<Triangolo> t = List.of( new Triangolo(1, 2, 3, 90, 6, 7),
        new Triangolo(2, 3, 4, 6, 7, 8),
        new Triangolo(3, 4, 5, 7, 8, 9));
        
    public static void main(String[] args){
        List<Auto> auto5percento = incrementoCosto();
        for(Auto a : auto5percento)System.out.println("\nAuto con il 5% in più: {" + a.categoria() + " " + a.colore() + " " + a.costo() + " " + a.modello() +"}");
        System.out.println("\nSomma dei costi di tutte le auto: " + sommaAuto());
        System.out.println("\nMinimo dei costi di auto: " + minimoAuto());
        List<Auto> ordinata = ordinaLista();
        for(Auto a : ordinata) System.out.println("\nLista Ordinata: {" + a.categoria() + " " + a.colore()  + " " + a.costo() + " " + a.modello() + "}");
        Auto max = costoMax();
        System.out.println("\nL'auto con il costo massimo é: " + max.costo());
        Auto min = costoMin();
        System.out.println("\nL'auto con il costo minimo é: " + min.costo());
        System.out.println("\nLista di lati maggiori per ogni figura: " + latiMax());
        System.out.println("\nLista di lati minori per ogni figura: " + latiMin());
        System.out.println("\nPerimetro max: " + perimetroMax());
        System.out.println("\nLa somma dei perimetri é: "+ sommaPerimetri());
        System.out.println("\nI triangoli rettangoli sono: " + areeTriangoliRettangoli());
        System.out.println("\nLista lati minori di t:" + latiMinori());
        List<Triangolo> rettangolo = listaTriangoliRettangoli();
        for(Triangolo tr : rettangolo) System.out.println("\nLista Triangoli rettangoli presenti in t: {" + tr.l1()  + " " + tr.l2() + " " + tr.l3() + " " + tr.a1() + " " + tr.a2() + " " + tr.a3() + "}");
        List<Auto> verdi = autoVerdi();
        for(Auto a : verdi) System.out.println("\nLista Auto verdi: " + a.categoria() + " " + a.colore()  + " " + a.costo() + " " + a.modello());
        List<Figura> perimtroDop = perimetroDoppioLati();
        for(Figura f : perimtroDop) System.out.println("\nLista Periemtri doppi Lati: {" + f.l1() + " " + f.l2() + " " + f.l3() + " "+ f.l4() + " " + f.a1() + " " + f.a2()+  " " + f.a3() + " " + f.a4() + "}");
        System.out.println("\nPerimetro Doppio: " + perimetroDoppio());
    }  
    
    public static List<Auto> incrementoCosto(){
        return al.stream()
        .map(x-> new Auto(x.categoria(), x.colore(), x.costo() + (x.costo() * 0.05), x.modello()))
        .collect(Collectors.toList());
    }

    public static Double sommaAuto(){
        return al.stream()
        .mapToDouble(Auto::costo)
        .sum();
    }

    public static Double minimoAuto(){
        return al.stream()
        .mapToDouble(Auto::costo)
        .min()
        .orElse(0.0);
    }

    public static List<Auto> ordinaLista(){
        return al.stream()
        .sorted(Comparator.comparing(Auto::costo))
        .collect(Collectors.toList());
    }

    public static Auto costoMax(){
        return al.stream()
        .max(Comparator.comparing(Auto::costo))
        .get();
    }

    public static Auto costoMin(){
        return al.stream()
        .min(Comparator.comparing(Auto::costo))
        .get();
    }

    public static List<Integer> latiMax(){
        return figure.stream()
        .map(x -> List.of(x.l1(), x.l2() , x. l3(), x.l4()))
        .map(f->f.stream().max(Integer::compareTo).get())
        .collect(Collectors.toList());
    }


    public static List<Integer> latiMin(){
        return figure.stream()
        .map(x->List.of(x.l1(), x.l2(), x.l3(), x.l4()))
        .map(f->f.stream().min(Integer::compareTo).get())
         .collect(Collectors.toList());
    }

    public static Integer perimetroMax(){
        return figure.stream()
        .mapToInt(x-> x.l1() + x.l2() + x.l3() + x.l4())
        .max()
        .orElse(0);
    }

    public static Integer sommaPerimetri(){
        return figure.stream()
        .mapToInt(x-> x.l1() + x.l2() + x.l3() + x.l4())
        .sum();
    }

    public static List<Integer> areeTriangoliRettangoli(){
        return t.stream()
        .filter(x -> x.a1() == 90 || x.a2() == 90 || x.a3() == 90)
        .map( t -> t.l1() *  t.l2())
        .collect(Collectors.toList());
    }

    public static List<Integer> latiMinori(){
        return figure.stream()
        .map(x-> List.of(x.l1(), x.l2() , x.l3() , x.l4()))
        .map(tr -> tr.stream().reduce(Integer::min).get())
        .collect(Collectors.toList());
    }

    public static List<Triangolo> listaTriangoliRettangoli(){
        return t.stream()
        .filter(x -> x.a1() == 90 || x.a2() == 90 || x.a3() == 90)
        .collect(Collectors.toList());
    }

    public static List<Auto> autoVerdi(){
        return al.stream()
        .map(x-> new Auto(x.categoria(), "VERDI ", x.costo(),  x.modello()))
        .collect(Collectors.toList());
    }
    
    public static List<Figura> perimetroDoppioLati(){
        return figure.stream()
        .map(x -> new Figura(x.l1()*2, x.l2()*2, x.l3()*2, x.l4()*2, x.a1(), x.a2(), x.a3(), x.a4()))
        .collect(Collectors.toList());
    }

    public static List<Integer> perimetroDoppio(){
        return figure.stream()
        .map(x -> new Figura(x.l1()*2, x.l2()*2, x.l3()*2, x.l4()*2, x.a1(), x.a2(), x.a3(), x.a4()))
        .map(fi -> fi.l1() + fi.l2() + fi.l3() + fi.l4())
        .collect(Collectors.toList());
    }
}
