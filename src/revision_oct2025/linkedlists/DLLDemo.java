package revision_oct2025.linkedlists;

public class DLLDemo {
    public static void main(String[] args) {
        printDLL(insert(null , 1));
        DLLNode head = new DLLNode(1);
        DLLNode two = new DLLNode(2);
        DLLNode three = new DLLNode(3);
        DLLNode four = new DLLNode(4);
        DLLNode five = new DLLNode(5);
        head.next = two;
        two.prev = head;
        two.next = three;
        three.prev = two;
        three.next = four;
        four.prev = three;
        four.next = five;
        five.prev = four;
        printDLL(head);

        head = insert(head, 10);
        printDLL(head);

        head = insert(head, 2, 55);
        printDLL(head);

        head = insert(head, 0, 8);
        printDLL(head);

        head = delete(head, 2);
        printDLL(head);

        head = insert(head, 7, 7);
        printDLL(head);

        head = insert(head, 8, 8);
        printDLL(head);

        head = delete(head, 8);
        printDLL(head);

        head = insert(head, 8,9);
        printDLL(head);

        head = insert(head, 0, 100);
        printDLL(head);

    }

    static DLLNode insert(DLLNode head, int x) {
        DLLNode dummy = new DLLNode(0);
        DLLNode curr = dummy;
        dummy.next = head;
        DLLNode newNode = new DLLNode(x);
        while (curr.next != null) {
            curr = curr.next;
        }
        // re-arrange pointers
        curr.next = newNode;
        newNode.prev = curr;

        return dummy.next;
    }

    static DLLNode insert(DLLNode head, int index, int value) {
        if (index < 0)
            return head;

        // 1 - 2 - 3 - 4 - 5 - 10
        //          55
        // insert 55 at index 3
        int tempIndex = 0;
        DLLNode dummy = new DLLNode(0);
        dummy.next = head;
        DLLNode curr = dummy;
        while (curr.next != null && tempIndex < index) {
            tempIndex++;
            curr = curr.next;
        }
        if (tempIndex != index)
            return head;

        DLLNode newNode = new DLLNode(value);

        newNode.next = curr.next;
        if (curr.next != null)
            newNode.next.prev = newNode;
        newNode.prev = curr;
        curr.next = newNode;

        return dummy.next;
    }

    static DLLNode delete(DLLNode head, int index) {
        // 1 - 2 - 3 - 55 - 4 - 5 - 10  , delete element at index 2
        // 1 - 2 - 55 - 4 - 5 - 10
        DLLNode dummy = new DLLNode(0);
        dummy.next = head;
        DLLNode curr = dummy;
        int tempIndex = 0;
        while (curr != null && tempIndex < index) {
            curr = curr.next;
            tempIndex++;
        }

        if (curr != null && curr.next != null) {
            DLLNode toDelete = curr.next;
            curr.next = toDelete.next;
            if (toDelete.next != null)
                curr.next.prev = curr;
        }

        return dummy.next;
    }

    static void printDLL(DLLNode head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null) {
                if (head.next.prev == head)
                    System.out.print(" <");
                System.out.print("--> ");
            }
            head = head.next;
        }
        System.out.println();
    }

    static class DLLNode {
        int data;
        DLLNode prev;
        DLLNode next;
        DLLNode(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
}
