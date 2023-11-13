package Ingengeria_Del_SW.BustaPaga;
public class Main {
    public static void main(String args[]){
        ListaPersone persone = new ListaPersone();

        persone.genListaPagamaenti();
        int somma = persone.stampaCalcolaSomma();
        System.out.println("Totale:\t" + somma);

        persone.stampaRuoliPersone();
        System.out.println();
    }
}
