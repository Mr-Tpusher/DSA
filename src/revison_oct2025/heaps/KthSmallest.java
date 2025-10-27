package revison_oct2025.heaps;

import java.util.Arrays;

public class KthSmallest {
    public static void main(String[] args) {
        int[] arr = new int[] {13, 11, 10, 68, 25};
        MinHeap minHeap = new MinHeap(arr);
        int k = 3;
        System.out.println("Kth minimum for k: " + k + " -> " + minHeap.getKthSmallest(k));

    }

    static class MinHeap {
        int[] heap;
        int capacity;
        int size;

        MinHeap(int[] input) {
            this.heap = Arrays.copyOf(input, input.length);
            this.capacity = input.length;
            this.size = input.length;
            buildHeap();
        }

        int getKthSmallest(int k) {
            if (k > size)
                throw new IllegalArgumentException("index larger than the heap size");
            // remove min element k times, then add those k elements back
            int min = 0;

            // removing element k times
            for (int i = 0; i < k; i++) {
                min = extractMin();
            }

            System.out.println("array after k removal:" + Arrays.toString(heap));

            // adding those removed k elements
            for (int i = 0; i < k; i++) {
                size++;
                heapifyUp();
            }

            System.out.println("array at the end :" + Arrays.toString(heap));

            return min;
        }

        void heapifyUp() {

            int curr = size - 1;
            int parent = getParent(curr);
            while (parent >= 0 && heap[parent] > heap[curr]) {
                swap(curr, parent);
                curr = parent;
                parent = getParent(curr);
            }
        }

        int extractMin() {
            int min = heap[0];
            swap(0, size - 1);
            size--;
            heapifyDown(0);
            return min;
        }

        void buildHeap() {
            for (int i = (size - 1) / 2; i >= 0; i--) {
                heapifyDown(i);
            }
        }

        void heapifyDown(int index) {

            int currIndex = index;
            while (true) {
                int left = getLeft(currIndex);
                int right = getRight(currIndex);
                int smallest = currIndex;

                if (left < size && heap[left] < heap[smallest]) smallest = left;

                if (right < size && heap[right] < heap[smallest]) smallest = right;

                if (smallest == currIndex)
                    break;

                swap(currIndex, smallest);
                currIndex = smallest;
            }
        }

        int getLeft(int i) {
            return 2 * i + 1;
        }

        int getRight(int i) {
            return 2 * i + 2;
        }

        int getParent(int i) {
            return (i - 1) / 2;
        }

        void swap(int index1, int index2) {
            int temp = heap[index1];
            heap[index1] = heap[index2];
            heap[index2] = temp;
        }
    }
}
