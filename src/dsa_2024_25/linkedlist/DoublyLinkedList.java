package dsa_2024_25.linkedlist;

public class DoublyLinkedList<T> {
    DllNode<T> head;
    int size = 0;

    public void insert(T data) {
        DllNode<T> newNode = new DllNode<>(data);

        if (head == null) {
            head = newNode;
            size++;
            return;
        }

        DllNode<T> curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        newNode.prev = curr;
        curr.next = newNode;
        size++;
    }

    // consider 0 based indexing
    public void insertAtIndex(T data, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        DllNode<T> newNode = new DllNode<>(data);

        if (index == 0) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
            size++;
            return;
        }

        DllNode<T> curr = head;
        for (int counter = 0; counter < index - 1; counter++) {
            curr = curr.next;
        }

        newNode.next = curr.next;
        newNode.prev = curr;
        curr.next = newNode;

        if (newNode.next != null) {
            newNode.next.prev = newNode;
        }
        size++;
    }

    public T removeAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        DllNode<T> curr = head;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }
        T data = curr.next.data;

        curr.next = curr.next.next;
        if (curr.next != null) {
            curr.next.prev = curr;
        }
        size--;
        return data;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DLL (size=" + size + ") = { ");
        DllNode<T> curr = head;
        while (curr != null) {
            sb.append(curr.data).append(" ");
            curr = curr.next;
        }
        sb.append("}");

        return sb.toString();
    }


    static class DllNode<T> {
        DllNode<T> prev;
        T data;
        DllNode<T> next;

        public DllNode(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
}

class DoublyLinkedListMain {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        dll.insertAtIndex(5, 0);
        System.out.println(dll);
        dll.insertAtIndex(4, 0);
        System.out.println(dll);
        dll.insertAtIndex(3, 1);
        dll.insertAtIndex(13, 3);
        dll.insert(10);
        dll.insert(11);
        System.out.println(dll);
        dll.removeAtIndex(3);
        System.out.println(dll);


    }
}
