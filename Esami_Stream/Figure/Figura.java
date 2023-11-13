package Ingengeria_Del_SW.Figure;

import java.util.List;
import java.util.stream.Collectors;

public class Figura {
    private List<int[]> lato = List.of(new int[]{6,3,6,3}, new int[]{4,5,4,5}, new int[]{5,5,5,5});
    private List<int[]> angolo = List.of(new int[]{90,90,90}, new int[]{90,90,90}, new int[]{90,90,90});

    public List<int[]> getLato(){
        return lato;
    }

    public List<int[]> getAngolo(){
        return angolo;
    }

    public List<Integer> getPerimetro(final List<int[]> Perimetrolato){
        return Perimetrolato.stream()
        .map(t->t[0] + t[1] + t[2]+ t[3])
        .collect(Collectors.toList());
    }

    public int sommaPerimetro(){
        List<Integer> sommaPerimetro = getPerimetro(lato);
        int somma = sommaPerimetro.stream()
        .mapToInt(Integer::intValue)
        .sum();
        return somma;
    }
    
    public int getLatoMinore() {
        if (lato.isEmpty()) {
            return 0; // Restituisci 0 se la lista dei lati è vuota
        }
    
        int minimaLunghezza = lato.get(0)[0]; // Inizializza con la prima lunghezza
        for (int[] l : lato) {
            for (int lunghezza : l) {
                if (lunghezza < minimaLunghezza) {
                    minimaLunghezza = lunghezza;
                }
            }
        }
        return minimaLunghezza;
    }    
}
