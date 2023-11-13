package Ingengeria_Del_SW.Esame.Lista;

public class Book {
    private String title, category;
    private Integer price, amount;
    
    public Book(String title, String category, Integer price, Integer amount){
        this.title = title;
        this.category = category;   
        this.price = price;
        this.amount = amount;
    }

    public String title(){
        return title;
    }

    public String category(){
        return category;
    }

    public Integer price(){
        return price;
    }

    public Integer amount(){
        return amount;
    }
}
