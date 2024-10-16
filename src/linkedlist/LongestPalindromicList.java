package linkedlist;

import java.util.HashMap;

/*
* Given a singly LL, find the longest palindrome present and return its length.
*  1 -> 4 -> 3 -> 4 -> 2 -> 4 -> 3 -> 9 -> null
* */
public class LongestPalindromicList {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        Node<Integer> head = ll.populateLinkedList(new Integer[]{ 1,2,2,7,1});
        System.out.println(ll);
        int length = palindromeLengthUsingExpansionAcrossCenter(head);
        System.out.println(length);
    }

    public static int palindromeLengthUsingExpansionAcrossCenter(Node<Integer> head) {
        Node<Integer> curr = head;
        Node<Integer> dummyHead = new Node<>(0);
        Node<Integer> prev = dummyHead;
        HashMap<Node<Integer>, Node<Integer>> nodeMapping = new HashMap<>();

        // Clone LL
        while (curr != null) {
            Node<Integer> newNode = new Node<>(curr.getData());
            prev.setNext(newNode);
            prev = newNode;
            nodeMapping.put(curr, newNode);
            curr = curr.getNext();
        }
        Node<Integer> head2 = dummyHead.getNext();

        // Reverse the LL
        Node<Integer> previous, current, next;
        previous = null;
        current = head2;
        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        head2 = previous;

        // Check palindrome length by iterating on LL1 towards right and LL2 towards left
        Node<Integer> node1 = head;
        int palindromeLength = 0;
        while (node1 != null) {
            Node<Integer> node2 = nodeMapping.get(node1);
            int length1 = 1 + getPalindromeLength(node1.getNext(), node2.getNext());
            int length2 = getPalindromeLength(node1, node2.getNext());
            palindromeLength = Math.max(palindromeLength, Math.max(length1, length2));
            node1 = node1.getNext();
        }
        return palindromeLength;
    }

    public static int getPalindromeLength(Node<Integer> node1, Node<Integer> node2) {
        int length = 0;
        while (node1 != null && node2 != null && node1.getData().equals(node2.getData())) {
            length+=2;
            node1 = node1.getNext();
            node2 = node2.getNext();
        }
        return length;
    }

    public static void printLL(Node<Integer> head) {
        StringBuilder sb = new StringBuilder("LinkedList{ ");
        Node<Integer> current = head;
        int size = 0;
        while (current != null) {
            sb.append(current.getData()).append(" ");
            current = current.getNext();
            size++;
        }
        sb.append("}, size=").append(size).append('}');
    }
}
