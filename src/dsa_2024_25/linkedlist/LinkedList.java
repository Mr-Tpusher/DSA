package dsa_2024_25.linkedlist;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    public Node<T> populateLinkedList(T[] elements) {
        int length = elements.length;
        if (length < 1) {
            head = null;
        } else {
            this.head = new Node<>(elements[0]);
            size++;
            Node<T> curr = head;
            for (int i = 1; i < length; i++) {
                curr.setNext(new Node<>(elements[i]));
                curr = curr.getNext();
                size++;
            }
            this.tail = curr;
        }
        return head;
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
                temp = temp.getNext();
            }
            temp.setNext(newNode;
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
    
    public boolean search(T x) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.getData().equals(x)) {
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    public T deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Illegal Index:" + index);
        }

        if (index == 0) {
            Node<T> element = head;
            head = head.getNext();
            size--;
            return element.getData();
        }

        int tempIndex = 0;
        Node<T> temp = head;
        while (tempIndex < index - 1) {
            temp = temp.getNext();
            tempIndex++;
        }
        Node<T> element = temp.getNext();
        temp.setNext(temp.getNext().getNext());

        if (temp.getNext() == null) {
            tail = temp;
        }

        size--;
        return element.getData();
    }

    public T delete(T data) {
        if (head == null) {
            return null;
        }

        if (head.getData().equals(data)) {
            Node<T> element = head;
            head = head.getNext();
            size--;
            if (head == null) {
                tail = null;
            }
            return element.getData();
        }

        Node<T> temp = head;
        while (temp.getNext() != null && !temp.getNext().getData().equals(data)) {
            temp = temp.getNext();
        }
        // Element not found
        if (temp.getNext() == null) {
            return null;
        }

        Node<T> element = temp.getNext();
        temp.setNext(temp.getNext().getNext());
        if (temp.getNext() == null) {
            tail = temp;
        }
        size--;
        return element.getData();
    }

    public Node<T> reverse() {
        Node<T> prev, next;
        prev = next = null;
        Node<T> curr = head;

        while (curr != null) {
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    public LinkedList<T> clone() {
        LinkedList<T> newList = new LinkedList<>();
        if (head == null) {
            return newList;
        }
        Node<T> curr = head;
        while (curr != null) {
            newList.insert(curr.getData());
            curr = curr.getNext();
        }
        return newList;
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
