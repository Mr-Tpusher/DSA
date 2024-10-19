package linkedlist;

import java.util.HashMap;
import java.util.HashSet;

/*
* Given a LL which might have a cycle, return true if cycle is present.
* */
public class CyclicLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        Node<Integer> head = ll.populateLinkedList(new Integer[] {1, 2, 3, 4, 5, 6, 7});
        Node<Integer> cycleStartingPointer = head.getNext().getNext();
        head.getNext().getNext().getNext().getNext().getNext().getNext().setNext(cycleStartingPointer);

        System.out.println(checkCycleUsingHashing(head));

    }

    public static boolean checkCycleUsingHashing(Node<Integer> head) {
        HashSet<Node> nodes = new HashSet<>();
        Node<Integer> curr = head;
        while (curr != null) {
            if (!nodes.add(curr))
                return true;
            curr = curr.getNext();
        }
        return false;
    }
}
