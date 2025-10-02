package util;

import linkedlist.Node;

public class LinkedList {
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
        System.out.println(sb);
    }
}
