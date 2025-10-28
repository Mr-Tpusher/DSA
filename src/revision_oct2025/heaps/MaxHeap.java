package revision_oct2025.heaps;

import java.util.Arrays;

public class MaxHeap {
    int capacity;
    int[] heap;
    int size;

    public MaxHeap(int[] input) {
        this.heap = input;
        this.capacity = input.length;
        this.size = input.length;
        heapify();
    }

    public MaxHeap() {
        this.capacity = 10;
        heap = new int[capacity];
        this.size = 0;
    }

    public void insert(int number) {
        ensureCapacity();
        heap[this.size++] = number;
        bubbleUp();
    }

    private void ensureCapacity() {
        if (size == capacity) {
            capacity *= 2;
            heap = Arrays.copyOf(heap, capacity);
        }
    }

    private void bubbleUp() {
        int index = this.size - 1;
        while (getParentIndex(index) >= 0 && heap[getParentIndex(index)] < heap[index]) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private void heapify() {
        for (int i = (size - 1) / 2; i >= 0; i--) {
            bubbleDown(i);
        }
    }

    public int getMax() {
        if (size == 0) throw new IllegalStateException("Heap is empty bro.");
        return heap[0];
    }

    public int extractMax() {
        if (size == 0) throw new IllegalStateException("Heap is empty bro.");
        int max = heap[0];
        heap[0] = heap[size - 1];
        --size;
        bubbleDown(0);
        return max;
    }

    private void bubbleDown(int index) {

        while (true) {
            int left = getLeftChildIndex(index);
            int right = getRightChildIndex(index);
            int largest = index;

            if (left < size && heap[left] > heap[largest]) largest = left;
            if (right < size && heap[right] > heap[largest]) largest = right;

            if (largest == index) break; // heap is proper

            swap(index, largest);
            index = largest;
        }

    }

    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    private int getLeftChildIndex(int i) {
        return 2 * i + 1;
    }

    private int getRightChildIndex(int i) {
        return 2 * i + 2;
    }

    private int getParentIndex(int i) {
        return (i - 1) / 2;
    }

    @Override
    public String toString() {
        return "MaxHeap:" + Arrays.toString(heap);
    }
}
