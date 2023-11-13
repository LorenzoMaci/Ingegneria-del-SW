package Ingengeria_Del_SW.Coda_Heap;

public class Nodo<T> {
    private Nodo<T> next;
    private T val;

    public Nodo(T val){
        this.next = null;
        this.val = val;
    }

    public Nodo<T> getNext(){
        return next;
    }

    public T getVal(){
        return val;
    }

    public void setNext(Nodo<T> next){
        this.next = next;
    }

    public void setVal(T val){
        this.val = val;
    }
}
