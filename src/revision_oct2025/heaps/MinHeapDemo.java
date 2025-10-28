package revision_oct2025.heaps;

public class MinHeapDemo {
    public static void main(String[] args) {
        MinHeap heap1 = new MinHeap(new int[] {70, 100, 20, 100, 5, 70, 80});
        System.out.println(heap1);

        heap1.insert(15);
        System.out.println(heap1);
        heap1.insert(114);
        heap1.insert(55);
        heap1.insert(16);
        heap1.insert(1000);
        System.out.println(heap1);

        System.out.println("Min element : " + heap1.extractMin());
        System.out.println(heap1);
    }
}
