package dsa_2024_25.linkedlist;
/*
 * Remove Kth node from the end of a LinkedList
 * */
public class RemoveKthNodeFromEnd {
    public static void main(String[] args) {
        LinkedListt<Integer> ll = new LinkedListt<>(new Integer[]{11, 12, 13, 14, 15});
        System.out.println(ll);
        System.out.println("removed : " + ll.removeKthFromEnd(1));
        System.out.println(ll);
    }
}

class LinkedListt<T> {
    Node<T> head;
    int size;

    public LinkedListt(T[] elements) {
        head = null;
        size = elements.length;
        Node<T> temp = head;
        for (int i = 0; i < size; i++) {
            Node<T> newNode = new Node<>(elements[i]);
            if (temp == null) {
                head = temp = newNode;
            } else {
                temp.next = newNode;
                temp = temp.next;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        Node<T> temp = head;
        while (temp != null) {
            sb.append(temp.data);
            temp = temp.next;
            if (temp != null) {
                sb.append(", ");
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
            next = null;
        }
    }

    public T removeKthFromEnd(int k) {
        // kth from end is (size - k + 1)th from start
        if (k > size || k <= 0) {
            throw new IndexOutOfBoundsException("Invalid k:" + k);
        }

        if (k == size) {
            T removedData = head.data;
            head = head.next;
            size--;
            return removedData;
        }
        Node<T> temp = head;
        int tempK = size - k + 1;
        for (int i = 1; i < tempK - 1; i++) {
            temp = temp.next;
        }
        Node<T> toBeDeleted = temp.next;
        size--;
        temp.next = temp.next.next;
        return toBeDeleted.data;
    }
}
