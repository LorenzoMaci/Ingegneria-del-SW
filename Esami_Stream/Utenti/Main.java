package Ingengeria_Del_SW.Utenti;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/*
 *  1-Data una lista di utenti, restituire tutti i 
 *  loro commenti ordinati per data.
 *  2-Restituire gli utenti che hanno 
 *  pubblicato almeno un commento prima di una certa data
 * 3-Restituire il commento più recente
 */

public class Main {
    public static void main(String[] args){
        LocalDate date = LocalDate.of(2021,1,3);
        List<Utente> utenti = List.of(new Utente("u1", List.of(new Commento("c2", LocalDate.of(2021, 1, 2)),
                                                                    new Commento("c1", LocalDate.of(2021, 1, 1)),
                                                                    new Commento("c5", LocalDate.of(2021, 1, 5)))),
                                      new Utente("u2", List.of(new Commento("c4", LocalDate.of(2021, 1, 4)),
                                                                    new Commento("c3", LocalDate.of(2021, 1, 3)))));

        metodo1(utenti);
        System.out.println("\n");

        utentiPrimaData(utenti, date);

        commentoRecente(utenti);

    }

    static void metodo1(List<Utente> utenti){
        utenti.stream()
        .flatMap(comment->comment.commenti().stream())
        .sorted(Comparator.comparing(Commento::data))
        .forEach(p->System.out.println(p.testo() + "\n"));
    }

    static void utentiPrimaData(List<Utente> utenti, LocalDate date){
        List<Utente> utente = utenti.stream()
        .filter(u->u.commenti().stream().anyMatch(c->c.data().isBefore(date)))
        .collect(Collectors.toList());
        utente.forEach(u->System.out.println("i primi commenti sono di: " + u.nome()));
    }

    static void commentoRecente(List<Utente>utenti){
        Optional<Utente> utenteCommento = utenti.stream()
        .flatMap(u->u.commenti().stream())
        .max(Comparator.comparing(Commento::data))
        .map(commento->utenti.stream().filter(u->u.commenti().contains(commento)).findFirst())
        .orElse(Optional.empty());
        
        utenteCommento.ifPresent(u->System.out.println("il commento recente è di " + u.nome()));
    }
}
