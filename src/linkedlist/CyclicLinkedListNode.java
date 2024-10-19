package linkedlist;

import java.util.HashSet;

/*
* Given a LinkedList which contains cycles, return the node at which the cycle starts.
* */
public class CyclicLinkedListNode {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        Node<Integer> head = ll.populateLinkedList(new Integer[] {1, 2, 3, 4, 5, 6, 7});

        Node<Integer> cycleStartingPointer = head.getNext().getNext().getNext();
        head.getNext().getNext().getNext().getNext().getNext().getNext().setNext(cycleStartingPointer);

        Node<Integer> cycleHead = getCycleHead(head);
        System.out.println(cycleHead == null ? null : cycleHead.getData());
    }

    public static Node<Integer> getCycleHead(Node<Integer> head) {
        HashSet<Node<Integer>> nodes = new HashSet<>();
        Node<Integer> curr = head;
        while (curr != null) {
            if (!nodes.add(curr))
                return curr;
            curr = curr.getNext();
        }
        return null;
    }
}
