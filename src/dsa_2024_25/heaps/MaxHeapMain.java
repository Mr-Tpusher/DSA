package dsa_2024_25.heaps;

public class MaxHeapMain {
    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap();
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);

        heap.print();

        MaxHeap heap2 = new MaxHeap(new int[]{11,32,83,4,95});
        heap2.print();
        System.out.println(heap2.deleteMax());
        heap2.print();
    }
}
