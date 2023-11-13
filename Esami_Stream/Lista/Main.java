package Ingengeria_Del_SW.Esame.Lista;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class Main {
    
    public static void main(String[] args){
        es1();
        es2();
        es3();
        es4();
    }
    //Trovare la parola più lunga di una lista di frasi
    public static void es1(){
        List<String> l = List.of("Ciao , come stai ?", "Supercalifragilistichespiralidoso , sono io", " ", "Questa è la stringa più lunga ma non contiene la parola più lunga");

        Optional<String> parolaMax = l.stream()
        .map(s -> s.split(" "))
        .map(a -> Arrays.stream(a)
        .max(Comparator.comparing(String::length)).orElse(""))
        .max(Comparator.comparing(String::length));

        System.out.println("La Parola più lunga è: ");
        if(parolaMax.isPresent()){
            System.out.println(parolaMax.get());
        }
    }

    // il numero totale di caratteri minuscoli in una lista di stringhe
    public static void es2(){
        List<String> l = List.of("Ciao , come stai ?", "Supercalifragilistichespiralidoso , sono io", " ", "Questa è la stringa più lunga ma non contiene la parola più lunga");

        Long numCaraterri = l.stream()
        .flatMap(s-> Arrays.stream(s.split(" ")))
        .map(s->(s.length() > 0 ? s.charAt(0) : ' ' ))
        .filter(p -> p >= 'a' && p <= 'z')
        .count();

        System.out.println("Il numero totale di caratteri è: " + numCaraterri);
    }
    // Possibile guadagno per ogni categoria di libro 
    public static void es3(){
        List<Book> l = List.of(new Book("Libro1", "CategoriaA", 20, 1),
        new Book("Libro2", "CategoriaB", 12, 1),
        new Book("Libro3", "CategoriaA", 4, 1),
        new Book("Libro4", "CategoriaB", 18, 2),
        new Book("Libro5", "CategoriaB", 30, 1));

        l.stream()
        .map(Book::category)
        .distinct()
        .map(g -> new String(g + " " + l.stream()
        .filter(lib-> lib.category() == g)
        .map(lib-> lib.amount() * lib.price())
        .reduce(0, Integer::sum)))
        .forEach(System.out::println);
    }


    // libri il cui titolo è composto da sole due parole
    public static void es4(){
        List<Book> l = List.of(new Book("Libro1", "CategoriaA", 20, 1),
        new Book("Libro2", "CategoriaB", 12, 1),
        new Book("Libro3", "CategoriaA", 4, 1),
        new Book("Libro4", "CategoriaB", 18, 2),
        new Book("Libro5", "CategoriaB", 30, 1));

        Function<String, Boolean> twoWords = s->Arrays.stream(s.split(" "))
        .filter(w -> w.length() > 0)
        .count() == 2;

        l.stream()
        .map(Book::title)
        .filter(s-> twoWords.apply(s))
        .forEach(System.out::println);
    }

}
