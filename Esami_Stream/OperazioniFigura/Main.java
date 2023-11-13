package Ingengeria_Del_SW.Figura.OperazioniFigura;


import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static List<Figura> figura = List.of(new Figura(1, 2, 3, 4, 5, 6, 7, 8), new Figura(2, 3, 4, 5, 6, 7, 8, 9),
    new Figura(3, 4, 5, 6, 7, 8, 9, 10));

    public static void main(String[] args){
        List<Integer> latiMax = latiMaggiori(figura);

        List<Integer> angoloMin = angoloMinore(figura);

        List<Figura> periemetrodp = perimetroDoppio(figura);

        System.out.print("\nLati max: " + latiMax);
        System.out.print("\nAngolo min: " + angoloMin);
        System.out.print("\nPerimetroDp: "+ periemetrodp);
    }

    public static List<Integer> latiMaggiori(List<Figura> figura){
        return figura.stream()
        .map(x->List.of(x.l1(), x.l2(), x.l3(),x.l4()))
        .map(x->x.stream().reduce(Integer::max).get())
        .collect(Collectors.toList());
    }


    public static List<Integer> angoloMinore(List<Figura> figura){
        return figura.stream()
        .map(x->List.of(x.a1(), x.a2(), x.a3(), x.a4()))
        .map(x->x.stream().reduce(Integer::min).get())
        .collect(Collectors.toList());
    }

    public static List<Figura> perimetroDoppio(List<Figura> figura){
        return figura.stream()
        .map(x->new Figura(x.l1()*2, x.l2()*2, x.l3()*2, x.l4()*2, x.a1(), x.a2(), x.a3(), x.a4()))
        .collect(Collectors.toList());
    }
}

