package dsa_2024_25.heaps;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MaxHeap {
    private int capacity;
    private int size;
    private int[] heap;

    public MaxHeap() {
        this(10);
    }
    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.heap = new int[capacity];
        this.size = 0;
    }

    public MaxHeap(int[] input) {
        this.heap = Arrays.copyOf(input, input.length);
        this.capacity = input.length;
        this.size = input.length;
        heapify();
    }

    private void heapify() {
        for (int i = (size / 2) - 1; i >= 0; i--) {
            bubbleDown(i);
        }
    }

    private int getParent(int i) {
        return (i - 1) / 2;
    }

    private int getLeftChild(int i) {
        return (2 * i) + 1;
    }

    private int getRightChild(int i) {
        return (2 * i) + 2;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }


    public void insert(int element) {
        if (size >= capacity) {
            throw new IndexOutOfBoundsException("Heap is full.");
        }
        heap[size] = element;
        bubbleUp(size);
        size++;
    }

    public void bubbleUp(int i) {
        while (i > 0 && heap[i] > heap[getParent(i)]) {
            swap(i, getParent(i));
            i = getParent(i);
        }
    }

    private void bubbleDown(int i) {
        while (true) {
            int leftChild = getLeftChild(i);
            int rightChild = getRightChild(i);
            int largest = i;

            if (leftChild < size && heap[leftChild] > heap[largest]) {
                largest = leftChild;
            }
            if (rightChild< size && heap[rightChild] > heap[largest]) {
                largest = rightChild;
            }

            if (largest == i)
                break;

            swap(i, largest);
            i = largest;
        }
    }

    public int peekMax() {
        if (isEmpty())
            throw new NoSuchElementException("Heap is empty");

        return heap[0];
    }

    public int deleteMax() {
        if (isEmpty())
            throw new NoSuchElementException("Heap is empty");

        int max = heap[0];
        swap(0, size - 1);
        size--;

        if (size > 0) {
            bubbleDown(0);
        }

        return max;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

}
