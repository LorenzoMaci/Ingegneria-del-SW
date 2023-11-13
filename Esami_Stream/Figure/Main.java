package Ingengeria_Del_SW.Figure;
public class Main {
    public static void main(String[] args) {
        Figura figura = new Figura();

        int latoMinore = figura.getLatoMinore();
        int sommaPerimetri = figura.sommaPerimetro();

        System.out.println("Lato minore: " + latoMinore);
        System.out.println("Somma perimetri: " + sommaPerimetri);
    }
}
