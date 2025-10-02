package heaps;

public class HeapSort {
    public static void main(String[] args) {
        int[] Arr = {5, 3, 0, 8, 1, 2, 7, 3};
        sort(Arr);
        //System.out.println(Arrays.toString(Arr));
    }

    public static void sort(int[] Arr) {
        MaxHeap heap = new MaxHeap(Arr);
        heap.print();
        heap.sort();
        heap.print();

    }

    static class MaxHeap {
        int[] heap;
        int size;
        int capacity;

        public MaxHeap(int[] Arr) {
            this.heap = Arr;
            this.size = Arr.length;
            this.capacity = Arr.length;
            heapify();
        }

        public void sort() {
            int tempSize = size;
            for (int i = 0; i < tempSize; i++) {
                getMax();
            }
            size = tempSize;
        }

        public int getMax() {
            int max = heap[0];
            swap(0, size - 1);
            size--;
            bubbleDown(0);
            return max;
        }

        public void print() {
            System.out.print("Heap:");
            for (int i = 0; i < size; i++) {
                System.out.print(heap[i] + " ");
            }
            System.out.println();
        }

        private  void heapify() {
            for (int k = (size - 1) / 2; k >= 0; k--) {
                bubbleDown(k);
            }
        }

        private void bubbleDown(int i) {
            if (isLeaf(i))
                return;

            while (true) {

                int largest = i;
                int left = getLeftIndex(i);
                int right = getRightIndex(i);

                if (hasLeftChild(i) && heap[left] > heap[largest]) {
                    largest = left;
                }

                if (hasRightChild(i) && heap[right] > heap[largest]) {
                    largest = right;
                }

                if (largest == i) {
                    break;
                }

                swap(i, largest);
                i = largest;
            }
        }


        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

        private boolean isLeaf(int i) {
            if (getLeftIndex(i) < size || getRightIndex(i) < size) {
                return false;
            }
            return true;
        }

        private int getLeftIndex(int i) {
            return 2 * i + 1;
        }

        private boolean hasLeftChild(int i) {
            return getLeftIndex(i) < size;
        }

        private boolean hasRightChild(int i) {
            return getRightIndex(i) < size;
        }

        private int getRightIndex(int i) {
            return 2 * i + 2;
        }

        private int getParent(int i) {
            return (i - 1) / 2;
        }
    }
}
