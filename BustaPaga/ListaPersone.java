package Ingengeria_Del_SW.BustaPaga;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListaPersone {
    private List <Persona> team = List.of(new Persona("Kent Gray", 29, "CTO"),
    new Persona("Luigi Rossi", 25, "Programmer"),
    new Persona("Al White", 25, "Programmer"),
    new Persona("Andrea Verdi", 26, "GroupLeader"),
    new Persona("Joe Black", 26, "Programmer"),
    new Persona("Jill Purple", 26, "Tester"),
    new Persona("Bill Green", 26, "Analyst"),
    new Persona("Luc Brown", 26, "Tester"));

    private Map < String, Integer > roleCost = Map.of("Programmer", 50, "GroupLeader", 60, "CTO", 65, "Tester", 56, "Analyst", 54);

    private List <BustaPaga > pagamenti;

    public void genListaPagamaenti(){
        pagamenti = team.stream()
        .map(pers-> new BustaPaga(pers, roleCost.getOrDefault(pers.getRuolo(), 50)))
        .map(busta->busta.calcoBustaPaga())
        .map(busta->busta.aggiungiBonus())
        .sorted()
        .collect(Collectors.toList());
    }

    public int stampaCalcolaSomma(){
        return pagamenti.stream()
        .map(BustaPaga::stampa)
        .mapToInt(BustaPaga::getCosto)
        .sum();
    }

    public void stampaRuoliPersone(){
        roleCost.keySet()
        .stream()
        .sorted()
        .peek(role->System.out.println("\n" + role+ ":"))
        .forEach(role->team.stream()
        .filter(pers->pers.getRuolo().equals(role))
        .sorted(Comparator.comparing(Persona::getNome))
        .forEach(pers->System.out.print(pers.getNome() + ",")));
    }
}
