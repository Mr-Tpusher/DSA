package dsa_2024_25.linkedlist;
/*
* Reverse the k nodes of a linkedlist at a time.
* 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> null     k = 3
* 3 -> 2 -> 1 -> 6 -> 5 -> 4 -> 9 -> 8 -> 7 -> null
*
* */
public class ReverseKNodes {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>(new Integer[] {1,2,3,4,5,6,7,8,9, 10, 11});
        System.out.println(ll);
        ll.reverseKNodes(3);
        System.out.println(ll);
    }

    private static class LinkedList<T> {
        Node<T> head;

        public LinkedList(T[] elements) {
            head = new Node<>(elements[0]);
            Node<T> curr = head;
            for (int i = 1; i < elements.length; i++) {
                curr.next = new Node<>(elements[i]);
                curr = curr.next;
            }
        }

        public Node<T> reverseKNodes(int k) {
            Node<T> prev, start, end, next;
            prev = null;
            start = head;
            end = start;
            for (int i = 1; i < k; i++) {
                if (end.next == null) {
                    return head;
                }
                end = end.next;
            }
            next = end.next;

            // Now the head of the LL will be the end of the first reversed sub-LL
            head = end;

            while (true) {
                reverse(start, k);
                // Link previous pointer to the reversed LL
                if (prev != null) {
                    prev.next = end;
                }

                // Break if next is null indicating job is done
                if (next == null) {
                    break;
                }

                // Link reversed sub-LL to the rest of the LL
                start.next = next;

                // Move pointers further
                prev = start;
                start = start.next;
                end = start;
                for (int i = 1; i < k; i++) {
                    if (end.next == null) {
                        return head;
                    }
                    end = end.next;
                }
                next = end.next;
            }
            return head;
        }

        public void reverse(Node<T> start, int k) {
            Node<T> prev, curr, next;
            prev = next = null;
            curr = start;
            int count = 0;
            while (curr != null && count < k) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }
        }


        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node<T> curr = head;
            while (curr != null) {
                sb.append(curr.data);
                if (curr.next != null)
                    sb.append(" -> ");
                curr = curr.next;
            }
            return sb.toString();
        }

        private static class Node<T> {
            T data;
            Node<T> next;
            public Node(T data) {
                this.data = data;
                this.next = null;
            }
        }
    }
}
