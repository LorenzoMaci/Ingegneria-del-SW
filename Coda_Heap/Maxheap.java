package Ingengeria_Del_SW.Coda_Heap;

import java.util.Comparator;

public class Maxheap<T extends Comparable<T>> extends Queue<T> {

    public Maxheap() {
        super(Comparator.reverseOrder());
    }

    protected void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && compare(getValue(index), getValue(parentIndex)) > 0) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    protected void heapifyDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int largestIndex = index;

        if (leftChildIndex < getSize() && compare(getValue(leftChildIndex), getValue(largestIndex)) > 0) {
            largestIndex = leftChildIndex;
        }

        if (rightChildIndex < getSize() && compare(getValue(rightChildIndex), getValue(largestIndex)) > 0) {
            largestIndex = rightChildIndex;
        }

        if (largestIndex != index) {
            swap(index, largestIndex);
            heapifyDown(largestIndex);
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
