import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String args[]){
        List<String> l1 = Arrays.asList("Ciao", "roller", "incastro", "stronzo", "tronco","ippopotamo", "naso", "ape");
        
        String output = l1.stream()
                          .map(s->s.substring(0,1)) //substring = sottostringa, deve prendere il primo carattere e finire al secondo ecco perchè 0 e 1
                          .reduce("", (r,v)->r.concat(v)); //concat = concatenare r e v sono due stringhe 
        System.out.println(output);
    }
}
