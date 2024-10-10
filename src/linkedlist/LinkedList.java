package linkedlist;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    /*
    // This method inserts at the end by iterating over the linkedlist
    public void insert(T x) {
        Node<T> newNode = new Node<>(x);
        if (head == null) {
            this.head = newNode;
        } else {
            Node<T> temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
        size++;
    }
    */

    // This method inserts at the end using a tail pointer
    public void insert(T x) {
        Node<T> newNode = new Node<>(x);
        if (head == null) {
            this.head = newNode;
        } else {
            this.tail.setNext(newNode);
        }
        this.tail = newNode;
        size++;
    }

    public void insert(T x, int index) {
        Node<T> newNode = new Node<>(x);
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("illegal index: " + index);
        }

        if (index == 0) {
            // Insert at the start of the linkedlist
            newNode.setNext(head);
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
        } else {
            // Insert anywhere else in the linkedlist
            Node<T> temp = head;
            int tempIndex = 0;
            while (temp.getNext() != null && tempIndex < index - 1) {
                temp = temp.getNext();
                tempIndex++;
            }
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
        }
        size++;
        if (index == size - 1) {
            tail = newNode;
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("LinkedList{ ");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.getData()).append(" ");
            current = current.getNext();
        }
        sb.append("}, size=").append(size).append('}');
        return sb.toString();
    }


    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            next = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }
}


class LinkedListMain {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.insert(11);
        ll.insert(12);
        ll.insert(14);
        System.out.println(ll);
        ll.insert(10, 0);
        System.out.println(ll);
        ll.insert(15);
        System.out.println(ll);
        ll.insert(13, 3);
        System.out.println(ll);

    }
}
