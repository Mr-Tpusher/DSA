package dsa_2024_25.linkedlist;

public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>(new Integer[]{1, 2, 3, 4, 5});
        System.out.println(ll);
        ll.reverse();
        System.out.println(ll);
    }


    private static class LinkedList<T> {
        Node<T> head;

        public LinkedList(T[] elements) {
            int length = elements.length;
            if (length < 1) {
                throw new IllegalArgumentException("Array cannot be empty.");
            }
            this.head = new Node<>(elements[0]);
            Node<T> curr = head;
            for (int i = 1; i < length; i++) {
                Node<T> newNode = new Node<>(elements[i]);
                curr.next = newNode;
                curr = curr.next;
            }
        }

        public void reverse() {
            Node<T> prev, next;
            prev = next = null;
            Node<T> curr = head;

            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            head = prev;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            Node<T> curr = head;
            while (curr != null) {
                sb.append(curr.data);
                curr = curr.next;
                if (curr != null) {
                    sb.append(",");
                }
            }
            sb.append("}");
            return sb.toString();
        }


        private static class Node<T> {
            T data;
            Node<T> next;

            public Node(T data) {
                this.data = data;
                this.next = null;
            }

            @Override
            public String toString() {
                return "Node{" + "data=" + data + '}';
            }
        }
    }
}
