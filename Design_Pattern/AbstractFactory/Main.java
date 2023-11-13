package Ingengeria_Del_SW.Design_Pattern.AbstractFactory;
public class Main {
    private static AbstractFactory factory;
    public static void main(String[] args){
        client(new ModernFactory());
        
        client(new VictorianFactory());
    }

    static void client(AbstractFactory f){
        factory = f;
        Chair chair;
        Table table;

        chair = factory.createChair();
        table = factory.createTable();
        chair.sitOn();
        table.eatOn();
        System.out.println("");
    }
}
