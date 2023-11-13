package Ingengeria_Del_SW.Coda_Heap;

import java.util.Comparator;

public class Queue<T> {
    private Nodo<T> head;
    private int size;

    public Queue(){
        this.head = null;
        this.size = 0;
    }

    public Queue(Comparator<T> comparator) {
    }

    public boolean isEmpty(){
        return head == null;
    }   

    public int getSize(){
        return size;
    }

    public Nodo<T> getHead(){
        return head;
    }

    public void insertHead(T val){
        if(this.isEmpty()){
            head = new Nodo<T>(val);
            size++;
            return;
        }
    }

    public void insert(T val){
        if(this.isEmpty()){
            insertHead(val);
            return;
        }

        Nodo<T> toInsert = new Nodo<T>(val);
        toInsert.setNext(head);
        head = toInsert;
        size++;
        return;
    }

    public void delete(){
         if(this.isEmpty()){
            System.err.println("Empty Queue");
            return;
        }

        Nodo<T> cur = head;
        Nodo<T> prev = null;
        while(cur.getNext() != null){
            prev = cur;
            cur = cur.getNext();
        }

        prev.setNext(null);
        size--;
        return;
    }
}
