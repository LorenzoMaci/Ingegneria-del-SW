package Ingengeria_Del_SW.Esame.Eta;



public class Persona{
    private String name;
    private int age;
    private String role;

    public Persona(String nome, int eta, String ruole) {
        name = nome;
        age = eta;
        role = ruole;
    }

    public String name(){
        return name;
    }

    public int age(){
        return age;
    }

    public String role(){
        return role;
    }
}

