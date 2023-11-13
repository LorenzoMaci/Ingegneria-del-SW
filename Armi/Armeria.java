package Armi;

public class Armeria {
    public Arma getFucilePesante(){
        Munizionipesanti munizioni = new Munizionipesanti();
        return new Fucile(munizioni);
    }

    public Arma getPistola(){
        Munizioni munizioni = new Munizioni();
        return new Pistola(munizioni);
    }
}
