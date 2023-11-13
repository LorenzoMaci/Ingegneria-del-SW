package Ingengeria_Del_SW.Design_Pattern.AbstractFactory;

public class VictorianFactory implements AbstractFactory{
    public Chair createChair(){
        return new VictorianChair();
    }

    public Table createTable(){
        return new VictorianTable();
    }
}
