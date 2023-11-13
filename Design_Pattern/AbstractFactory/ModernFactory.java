package Ingengeria_Del_SW.Design_Pattern.AbstractFactory;

public class ModernFactory implements AbstractFactory {
    public Chair createChair(){
        return new ModernChair();
    }

    
    public Table createTable(){
        return new ModernTable();
    }

}
