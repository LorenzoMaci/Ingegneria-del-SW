package Ingengeria_Del_SW.Coda_Heap;

import java.util.Comparator;

public class Minheap<T extends Comparable<T>> extends Queue<T> {

    public Minheap() {
        super(Comparator.naturalOrder());
    }

   protected void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && compare(getValue(index), getValue(parentIndex)) < 0) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    protected void heapifyDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int smallestIndex = index;

        if (leftChildIndex < getSize() && compare(getValue(leftChildIndex), getValue(smallestIndex)) < 0) {
            smallestIndex = leftChildIndex;
        }

        if (rightChildIndex < getSize() && compare(getValue(rightChildIndex), getValue(smallestIndex)) < 0) {
            smallestIndex = rightChildIndex;
        }

        if (smallestIndex != index) {
            swap(index, smallestIndex);
            heapifyDown(smallestIndex);
        }
    }
    
    private int compare(T val1, T val2) {
        return val1.compareTo(val2);
    }

    private T getValue(int index) {
        Nodo<T> node = getNodeAtIndex(index);
        if (node != null) {
            return node.getVal();
        }
        throw new IndexOutOfBoundsException();
    }

    private Nodo<T> getNodeAtIndex(int index) {
        Nodo<T> node = getHead();
        for (int i = 0; i < index; i++) {
            if (node != null) {
                node = node.getNext();
            } else {
                return null;
            }
        }
        return node;
    }

    private void swap(int i, int j) {
        T temp = getValue(i);
        setValue(i, getValue(j));
        setValue(j, temp);
    }

    private void setValue(int index, T value) {
        Nodo<T> node = getNodeAtIndex(index);
        if (node != null) {
            node.setVal(value);
        }
    }
}
