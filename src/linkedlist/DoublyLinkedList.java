package linkedlist;

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
