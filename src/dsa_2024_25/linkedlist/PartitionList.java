package dsa_2024_25.linkedlist;
/*
* Given a single LinkedList and a value k, partition the list such that all values
* less than k come before all values greater than equals to k.
* e.g.  2 -> 9 -> 1 -> 1 -> 3 -> 8 -> 4 -> 2 -> 1 -> null       k = 3
* ans:  2 -> 1 -> 1 -> 2 -> 1 -> 9 -> 4 -> 3 -> 8 -> null
*
* */

public class PartitionList {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        Node<Integer> head = ll.populateLinkedList(new Integer[] {2, 9, 1, 1, 3, 8, 4, 2, 1});
        util.LinkedList.printLL(head);
        int k = 3;
        Node<Integer> partitionedListNode = partition(head, 3);
        util.LinkedList.printLL(partitionedListNode);

    }

    public static Node<Integer> partition(Node<Integer> head, int k) {
        Node<Integer> lessThanHead, greaterThanEqualsToHead, pointer1, pointer2;
        lessThanHead = new Node<>(0);
        greaterThanEqualsToHead = new Node<>(0);

        Node<Integer> curr = head;
        pointer1 = lessThanHead;
        pointer2 = greaterThanEqualsToHead;

        while (curr != null) {
            if (curr.getData() < k) {
                pointer1.setNext(curr);
                pointer1 = pointer1.getNext();
                curr = curr.getNext();
                pointer1.setNext(null);
            } else {
                pointer2.setNext(curr);
                pointer2 = pointer2.getNext();
                curr = curr.getNext();
                pointer2.setNext(null);
            }
        }
        pointer1.setNext(greaterThanEqualsToHead.getNext());
        return lessThanHead.getNext();
    }
}
