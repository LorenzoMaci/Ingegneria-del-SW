/*
 * Data una lista di terne di numeri verificare se essa costituisce un triangolo.
 * Restituire la lista dei perimetri per le terne che rappresentano triangoli
 */

import java.util.List;
import java.util.stream.Collectors;

/*
 * Data una lista di terne di numeri verificare se essa costituisce un triangolo.
 * Restituire la lista dei perimetri per le terne che rappresentano triangoli
 */
public class Main {
    public static void main(String args[]){
        List<int[]> list = List.of(new int[]{3, 5, 7}, new int[]{2,3,4});

        List<Integer> output = list.stream()
                                    .filter(v-> v[0] < v[1] + v[2])
                                    .filter(v-> v[1] < v[0] + v[2]) 
                                    .filter(v-> v[2] < v[0] + v[1])
                                    .map(v -> v[0] + v[1] + v[2])
                                    .collect(Collectors.toList());

        System.out.println(output);
    }    
}
