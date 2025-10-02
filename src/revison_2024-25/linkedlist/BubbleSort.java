package linkedlist;

public class BubbleSort {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        Node<Integer> head = ll.populateLinkedList(new Integer[] {8, 2, 9, 1, 3, 4, 10});
        //Node<Integer> head = ll.populateLinkedList(new Integer[] {2, 3, 2, 1, 3});
        util.LinkedList.printLL(head);
        util.LinkedList.printLL(bubbleSort(head));
    }

    public static Node<Integer> bubbleSort(Node<Integer> head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        Node<Integer> dummyHead = new Node<>(0);
        dummyHead.setNext(head);

        boolean swapped;
        do {
            swapped = false;
            Node<Integer> prev = dummyHead;
            Node<Integer> curr = dummyHead.getNext();

            while (curr != null && curr.getNext() != null) {
                if (curr.getData() > curr.getNext().getData()) {
                    swapped = true;

                    // Swap the nodes
                    Node<Integer> next = curr.getNext();
                    curr.setNext(next.getNext());
                    next.setNext(curr);
                    prev.setNext(next);

                    // Update pointers
                    prev = next;
                } else {
                    prev = curr;
                }
                curr = prev.getNext();
            }
        } while (swapped);
        return dummyHead.getNext();
    }
}
