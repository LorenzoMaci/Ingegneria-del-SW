package Ingengeria_Del_SW.Esame.Lavoratori;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
 * a)Metodo che restituisce la Lista dell'età delle persone
 * b)metodo che restituisce la somma dell'età delle persone
 * c)metodo che trova la persona più grande dei giovani con un età minore di 26
 * d)metodo che trova  la Persona Con un Età Minore
 */

public class Main {
    private static List<Persona> l1 = Arrays.asList(new Persona("Lorenzo", 21), new Persona("Giovanni", 30), new Persona("Patrick", 23), new Persona("Gabriele", 22),
    new Persona("Giuliana", 27));

    public static void main(String[] args){
        System.out.println("\nLista età lavoratori: " + etaPersone());
        System.out.println("\nSomma età Persone: " + sommaEta());
        Persona piuGrandeGiovani = personapiugrandedeiGiovani();
        System.out.println("\nLa persona più grande dei Giovani è: " + piuGrandeGiovani.nome());
        Persona piuPiccola = personaEtaMinore();
        System.out.println("\nLa persona più piccola è: " + piuPiccola.nome());
    }

    public static List<Integer> etaPersone(){
        return l1.stream()
        .map(Persona::eta)  
        .collect(Collectors.toList());
    }

    public static int sommaEta(){
        return l1.stream()
        .map(Persona::eta)
        .reduce(0, (v, t) -> v+t);
    }

    public static Persona personapiugrandedeiGiovani(){
        Comparator<Persona> eta = Comparator.comparing(x->x.eta());
        return l1.stream()
        .filter(x->x.giovane())
        .max(eta)
        .orElse(null);
    }

    public static Persona personaEtaMinore(){
        return l1.stream()
        .min(Comparator.comparingInt(Persona::eta))
        .get();
    }
}
