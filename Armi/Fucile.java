package Armi;

public class Fucile implements Arma {
    private Munizioni munizioni;

    public Fucile(Munizioni munizioni){
        this.munizioni = munizioni;
    }

    @Override
    public String getTipo() {
        return "Fucile";
    }

    @Override
    public int getDanno() {
        int moltiplicatore = munizioni.getMoltiplicatoreDanno();
        int dannoBase = 45;
        return dannoBase*moltiplicatore; 
    }

    @Override
    public int getDannoMirato() {
        int moltiplicatore = munizioni.getMoltiplicatoreDanno();
        int dannoMirato = 90;
        return dannoMirato*moltiplicatore;
    }
}
