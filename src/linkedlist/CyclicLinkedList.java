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
        System.out.println(checkCycleUsingSlowFastPointer(head));

    }

    public static boolean checkCycleUsingHashing(Node<Integer> head) {
        HashSet<Node<Integer>> nodes = new HashSet<>();
        Node<Integer> curr = head;
        while (curr != null) {
            if (!nodes.add(curr))
                return true;
            curr = curr.getNext();
        }
        return false;
    }

    public static boolean checkCycleUsingSlowFastPointer(Node<Integer> head) {
        if (head == null || head.getNext() == null) return false;
        Node<Integer> slow = head;
        Node<Integer> fast = head.getNext();

        while (fast != null && fast.getNext() != null) {
            if (slow.equals(fast)) {
                return true;
            }

            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return false;
    }
}
