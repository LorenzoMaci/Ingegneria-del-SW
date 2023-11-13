package Armi;

public class Pistola implements Arma{
    private Munizioni munizioni;

    public Pistola(Munizioni munizioni){
        this.munizioni = munizioni;
    }

    @Override
    public String getTipo(){
        return "Pistola";
    }

    @Override
    public int getDanno(){
        int moltiplicatore = munizioni.getMoltiplicatoreDanno();
        int dannoBase = 20;
        return dannoBase*moltiplicatore;
    }

    @Override
    public int getDannoMirato(){
        int moltiplicatore = munizioni.getMoltiplicatoreDanno();
        int dannoMirato = 40;
        return dannoMirato*moltiplicatore;
    }
}
