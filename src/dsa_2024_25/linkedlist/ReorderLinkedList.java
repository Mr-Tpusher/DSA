package dsa_2024_25.linkedlist;
/*
* Given a LL   : 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
* reordered LL : 1 -> 6 -> 2 -> 5 -> 3 -> 4 -> null
* */
public class ReorderLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>(new Integer[] {1,2,3,4,5,6});
        System.out.println(ll);
        ll.reorder();
        System.out.println(ll);
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

        public void reorder() {

            if (head == null || head.next == null || head.next.next == null) {
                return;
            }

            /*
                Consider 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
                We'll divide it into two LLs
                1 -> 2 -> 3
                4 -> 5 -> 6 -> null
                then reverse second LL
                6 -> 5 -> 4 -> null
                merge them
                1 -> 6 -> 2 -> 5 -> 3 -> 4 -> null
            */

            Node<T> slow, fast;
            slow = fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            // head2 is the start of the 2nd LL
            Node<T> head2 = slow.next;
            // Make end of first LL null
            slow.next = null;

            while (fast.next != null) {
                fast = fast.next;
            }

            // reverse LL2 (head2,fast)
            Node<T> prev, next, curr;
            curr = head2;
            prev = next = null;
            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            // Update head after reversing the LL
            head2 = prev;

            // Now join these two LLs
            Node<T> f1, f2, s1, s2;
            f1 = head;
            f2 = head2;
            while (f1 != null && f2 != null) {
                s1 = f1.next;
                s2 = f2.next;
                f1.next = f2;
                f2.next = s1;
                f1 = s1;
                f2 = s2;
            }
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
