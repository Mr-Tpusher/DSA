package revison_oct2025.heaps;

public class MaxHeapDemo {
    public static void main(String[] args) {

        // offline heap creation
        MaxHeap maxHeap1 = new MaxHeap(new int[] {70, 50, 40, 80, 30, 65, 45, 90, 20});
        System.out.println(maxHeap1);

        // Online heap
        MaxHeap maxHeap2 = new MaxHeap();
        maxHeap2.insert(10);
        maxHeap2.insert(20);
        maxHeap2.insert(30);
        maxHeap2.insert(5);
        maxHeap2.insert(8);
        maxHeap2.insert(2);
        maxHeap2.insert(1);
        System.out.println(maxHeap2);
        System.out.println("max=" + maxHeap2.getMax());
        System.out.println("extracted max = " + maxHeap2.extractMax());
        System.out.println(maxHeap2);


    }
}
