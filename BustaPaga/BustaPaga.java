package Ingengeria_Del_SW.BustaPaga;

public class BustaPaga implements Comparable <BustaPaga> {
    private Persona dipendente;
    private int totale;
    private int costoBase;

    public BustaPaga(Persona p, int costo){
        dipendente = p;
        this.costoBase = costo;
    }

    public BustaPaga calcoBustaPaga(){
        totale = costoBase*25;
        return this;
    }

    public int getCosto(){
        return totale;
    }

    public BustaPaga aggiungiBonus(){
        totale = (int) Math.round(totale*1.1);
        return this;
    }

    public Persona getPersona(){
        return dipendente;
    }

    public BustaPaga stampa(){
        System.out.println(dipendente.getNome() + "\t" + totale);
        return this;
    }
    
    @Override
    public int compareTo(BustaPaga b){
      return dipendente.getNome().compareTo(b.getPersona().getNome());
    }
}
