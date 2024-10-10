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
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
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
            this.tail.next = newNode;
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
            newNode.next = head;
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
        } else {
            // Insert anywhere else in the linkedlist
            Node<T> temp = head;
            int tempIndex = 0;
            while (temp.next != null && tempIndex < index - 1) {
                temp = temp.next;
                tempIndex++;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        size++;
        if (index == size - 1) {
            tail = newNode;
        }
    }
    
    public boolean search(T x) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(x)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public T deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Illegal Index:" + index);
        }

        if (index == 0) {
            Node<T> element = head;
            head = head.next;
            size--;
            return element.data;
        }

        int tempIndex = 0;
        Node<T> temp = head;
        while (tempIndex < index - 1) {
            temp = temp.next;
            tempIndex++;
        }
        Node<T> element = temp.next;
        temp.next = temp.next.next;

        if (temp.next == null) {
            tail = temp;
        }

        size--;
        return element.data;
    }

    public T delete(T data) {
        if (head == null) {
            return null;
        }

        if (head.data.equals(data)) {
            Node<T> element = head;
            head = head.next;
            size--;
            if (head == null) {
                tail = null;
            }
            return element.data;
        }

        Node<T> temp = head;
        while (temp.next != null && !temp.next.data.equals(data)) {
            temp = temp.next;
        }
        // Element not found
        if (temp.next == null) {
            return null;
        }

        Node<T> element = temp.next;
        temp.next = temp.next.next;
        if (temp.next == null) {
            tail = temp;
        }
        size--;
        return element.data;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("LinkedList{ ");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
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
        System.out.println(ll.search(10));
        System.out.println(ll.search(10000));

        // Delete
        System.out.println(ll.deleteAtIndex(0));
        System.out.println(ll);
        System.out.println(ll.deleteAtIndex(3));
        System.out.println(ll);
        System.out.println(ll.delete(13));
        System.out.println(ll);

    }
}
