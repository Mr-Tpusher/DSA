package revison_oct2025.heaps;

import java.util.Arrays;

public class MinHeap {
    int[] heap;
    int capacity;
    int size;

    public MinHeap() {
        this.capacity = 10;
        this.heap = new int[capacity];
        this.size = 0;
    }

    public MinHeap(int[] arr) {
        this.heap = arr;
        this.capacity = arr.length;
        this.size = arr.length;
        heapifyDown();
    }

    public void insert(int element) {
        ensureCapacity();
        heap[size++] = element;
        heapifyUp();
    }

    public int getMin() {
        return heap[0];
    }

    public int extractMin() {
        int min = heap[0];
        // replace it with the last element
        heap[0] = heap[size - 1];
        // reduce size
        size--;
        heapifyDown(0);
        return min;
    }


    private void heapifyUp() {
        int curr = size - 1;

        while (true) {
            int parent = getParentIndex(curr);
            if (parent >= 0 && heap[parent] > heap[curr]) {
                swap(parent, curr);
                curr = parent;
            } else {
                break;
            }
        }
    }

    private void ensureCapacity() {
        if (size == capacity) {
            capacity *= 2;
            int[] arr = new int[capacity];
            arr = Arrays.copyOf(heap, arr.length);
            heap = arr;
        }
    }

    private void heapifyDown() {
        for (int i = (size - 2) / 2; i >= 0; i--) {
            heapifyDown(i);
        }
    }

    private void heapifyDown(int index) {

        int currIndex = index;

        while (true) {
            int left = getLeftChildIndex(currIndex);
            int right = getRightChildIndex(currIndex);
            int smallest = currIndex;

            if (left < size && heap[smallest] > heap[left]) smallest = left;
            if (right < size && heap[smallest] > heap[right]) smallest = right;

            if (smallest == currIndex)
                break;// heap is proper, no need to swap

            swap(currIndex, smallest);
            currIndex = smallest;
        }
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

    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("MinHeap : [");

        for (int i = 0; i < size; i++) {
            sb.append(heap[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
