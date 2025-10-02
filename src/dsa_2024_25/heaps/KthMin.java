package dsa_2024_25.heaps;

import java.util.Arrays;

/*
 * Given an unsorted array, find kth smallest element.
 * Arr = {13, 11, 10, 68, 25}, k = 4
 * Answer = 25
 *
 * */
public class KthMin {
    public static void main(String[] args) {
        int[] Arr = {13, 11, 10, 68, 25};
        int k = 4;
        //System.out.println(bruteForce(Arr, k));
        System.out.println("kth min:" + solve(Arr, k));

    }

    public static int bruteForce(int[] Arr, int k) {
        Arrays.sort(Arr);
        return Arr[k - 1];
    }

    public static int solve(int[] Arr, int k) {
        MinHeap heap = new MinHeap(Arr);
        heap.print();
        int answer = heap.getKthMin(k);
        heap.print();
        return answer;
    }


    static class MinHeap {
        int[] heap;
        int size;
        int capacity;

        public MinHeap(int[] Arr) {
            this.heap = Arrays.copyOf(Arr, Arr.length);
            this.size = heap.length;
            this.capacity = heap.length;
            heapify();
        }

        private int leftChildIndex(int i) {
            return (2 * i + 1);
        }

        private int rightChildIndex(int i) {
            return (2 * i + 2);
        }

        private int parent(int i) {
            return (i - 1) / 2;
        }

        private boolean isLeaf(int i) {
            return leftChildIndex(i) >= size && rightChildIndex(i) >= size;
        }

        private void heapify() {
            for (int i = (size - 1) / 2; i >= 0; i--) {
                bubbleDown(i);
            }
        }

        private void bubbleDown(int i) {
            while (true) {
                int smaller = i;
                int left = leftChildIndex(i);
                int right = rightChildIndex(i);

                if (isLeaf(i))
                    return;

                if (left < size && heap[left] < heap[smaller]) {
                    smaller = left;
                }

                if (right < size && heap[right] < heap[smaller]) {
                    smaller = right;
                }

                if (smaller == i) {
                    break;
                }

                swap(i, smaller);
                i = smaller;

            }
        }

        public void bubbleUp(int i) {
            while (heap[parent(i)] > heap[i]) {
                swap(i, parent(i));
                i = parent(i);
            }
            size++;
        }

        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

        public void print() {
            System.out.print("heap:");
            for (int i = 0; i < size; i++) {
                System.out.print(heap[i] + " ");
            }
            System.out.println();
        }

        public int getKthMin(int k) {
            // delete the root k times
            for (int i = 1; i < k; i++) {
                getMin();
            }
            int answer = getMin();

            // restore the heap
            int tempSize = size;
            for (int i = tempSize; i < tempSize + k; i++) {
                bubbleUp(i);
            }

            return answer;
        }

        public int getMin() {
            int min = heap[0];
            swap(0, size - 1);
            size--;
            bubbleDown(0);
            return min;
        }
    }
}

