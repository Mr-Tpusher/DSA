package dsa_2024_25.linkedlist;

public class MiddleNode {
    public static void main(String[] args) {
       LinkedList<Integer> ll = new LinkedList<>(new Integer[] {1,2,3,4,5,6,7,8,9});
        System.out.println(ll);
        System.out.println(ll.getMiddle());
        System.out.println(ll.getMiddle2());
        System.out.println(ll.getMiddle3());


    }

    private static class LinkedList<T> {
        Node<T> head;

        public LinkedList(T[] elements) {
            int length = elements.length;
            if (length < 1) {
                head = null;
            } else {
                this.head = new Node<>(elements[0]);
                Node<T> curr = head;
                for (int i = 1; i < length; i++) {
                    curr.next = new Node<>(elements[i]);
                    curr = curr.next;
                }
            }
        }

        public T getMiddle() {
            if (head == null) return null;

            int size = 0;
            Node<T> curr = head;
            while (curr != null) {
                size++;
                curr = curr.next;
            }

            curr = head;
            for (int i = 1; i < (size + 1) / 2; i++) {
                curr = curr.next;
            }
            return curr.data;
        }

        public T getMiddle2() {
            if (head == null) return null;

            Node<T> slow, fast;
            slow = fast = head;

            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow.data;
        }

        public T getMiddle3() {
            if (head == null) return null;

            if (head.next == null) {
                return head.data;
            }

            Node<T> slow, fast;
            slow = head;
            fast = head.next;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow.data;
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

