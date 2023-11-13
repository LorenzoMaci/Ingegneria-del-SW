package Ingengeria_Del_SW.Esame.Eta;




import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        List<Persona> l = List.of(new Persona("Kent", 29, "CTO"),
        new Persona("Luigi", 25, "Programmer"),
        new Persona("Andrea", 26, "GrLeader"),
        new Persona("Sofia", 26, "Programmer"),
        new Persona("Alfio", 63, "Programmer"));

        List<String> programmatoriGiovani = l.stream()
        .filter(persona->persona.age() < 30 && "Programmer".equals(persona.role()))
        .map(Persona::name)
        .collect(Collectors.toList());

        System.out.println("programmatori con età < 30: " + programmatoriGiovani);

        List<String> ruoli = l.stream()
        .map(Persona::role)
        .distinct()
        .collect(Collectors.toList());

        System.out.println("I diversi ruoli sono: " + ruoli);
    }
}
