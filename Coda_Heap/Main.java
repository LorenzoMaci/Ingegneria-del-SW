package Ingengeria_Del_SW.Coda_Heap;
public class Main {
    public static void main(String[] args) {
        Maxheap<Integer> maxHeap = new Maxheap<>();
        maxHeap.insert(5);
        maxHeap.insert(10);
        maxHeap.insert(2);
        maxHeap.insert(8);

        System.out.println("Max value: " + maxHeap.getHead().getVal());
        maxHeap.delete();
        System.out.println("Max value after deletion: " + maxHeap.getHead().getVal());

        Minheap<Integer> minHeap = new Minheap<>();
        minHeap.insert(5);
        minHeap.insert(10);
        minHeap.insert(2);
        minHeap.insert(8);

        System.out.println("Min value: " + minHeap.getHead().getVal());
        minHeap.delete();
        System.out.println("Min value after deletion: " + minHeap.getHead().getVal());
    }
}
