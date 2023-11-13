package Ingengeria_Del_SW.Lista_interi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*1) creare un metodo che restituisca la somma di tutti i numeriù
 * 2) creare un metodo che restituisca il valore massimo della lista
 * 3) creare un metodo che restituisca una Lista contenente tutti i valori maggiori
 *   del valore inserito 
 * 4) creare un metodo che restituisca una stringa concatenata di tutti i numeri presenti nella lista
 */

public class Importi {
    private List<Integer> importi = Arrays.asList(12,34,56,78,90,45);

    public int calcoloSomma(){
        return importi.stream()
                 .reduce(0, (v, t)-> v+t);
    }

    public int estraiMassimo(){
        return importi.stream()
                      .max(Integer::compare)
                      .get();
    }

    public List<Integer> estraiValori(int val){
        return importi.stream()
                      .filter(s->s > val)
                      .collect(Collectors.toList());
    }

    public String congiungi(){
        return importi.stream()
                      .map(s->String.valueOf(s))
                      .reduce("", (v,t) -> v.concat(t));
    }
}
