package linkedlist;

public class MergeSort {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        Node<Integer> head = ll.populateLinkedList(new Integer[] {2, 9, 1, 3, 4, 2, 9});
        util.LinkedList.printLL(head);
        head = mergeSort(head);
        util.LinkedList.printLL(head);

    }

    public static Node<Integer> mergeSort(Node<Integer> head) {
        if (head == null) {
            return null;
        }
        if (head.getNext() == null) {
            return head;
        }

        Node<Integer> mid = getMid(head);
        Node<Integer> leftHead = head;
        Node<Integer> rightHead = mid.getNext();
        mid.setNext(null);

        leftHead = mergeSort(leftHead);
        rightHead = mergeSort(rightHead);

        return merge(leftHead, rightHead);
    }

    public static Node<Integer> merge(Node<Integer> left, Node<Integer> right) {
        Node<Integer> dummyHead = new Node<>(0);
        Node<Integer> ptr = dummyHead;
        Node<Integer> ptr1 = left;
        Node<Integer> ptr2 = right;

        while (ptr1 != null && ptr2 != null) {
            if (ptr1.getData() < ptr2.getData()) {
                ptr.setNext(ptr1);
                ptr1 = ptr1.getNext();
                ptr.getNext().setNext(null);
                ptr = ptr.getNext();
            } else {
                ptr.setNext(ptr2);
                ptr2 = ptr2.getNext();
                ptr.getNext().setNext(null);
                ptr = ptr.getNext();
            }
        }
        if (ptr1 != null) {
            ptr.setNext(ptr1);
        } else {
            ptr.setNext(ptr2);
        }
        return dummyHead.getNext();
    }

    public static Node<Integer> getMid(Node<Integer> head) {
        if (head == null) return null;
        if (head.getNext() == null) return head;

        Node<Integer> slowPointer = head;
        Node<Integer> fastPointer = head.getNext();

        while (fastPointer != null && fastPointer.getNext() != null) {
            slowPointer = slowPointer.getNext();
            fastPointer = fastPointer.getNext().getNext();
        }
        return slowPointer;

    }
}
