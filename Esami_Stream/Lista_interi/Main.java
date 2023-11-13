package Ingengeria_Del_SW.Lista_interi;
public class Main {
    public static void main(String args[]){
        Importi imp = new Importi();
        int somma = imp.calcoloSomma();
        System.out.println("Somma: " + somma);
        int max = imp.estraiMassimo();
        System.out.println("Massimo: " + max);
        System.out.println("Estrai i valori superiori: " + imp.estraiValori(56));
        System.out.println("Stringa concatenata: " + imp.congiungi()+ "\n");
    }
}
