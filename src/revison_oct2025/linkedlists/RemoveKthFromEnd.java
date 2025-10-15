package revison_oct2025.linkedlists;

import java.util.List;

public class RemoveKthFromEnd {
    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        A.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        ListNode head = removeNthFromEndUsing2Pointers(A, 2);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    static ListNode removeNthFromEnd(ListNode A, int B) {
        // Find out the size of the LinkedList
        int size = 0;
        ListNode temp = A;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        // If the size is 1 or B is greater than equal to size
        if (size == 1 || B >= size)
            return A.next;

        temp = A;
        int count = 0;
        while (temp != null && count < size - B - 1) {
            count++;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return A;
    }

    static ListNode removeNthFromEndUsing2Pointers(ListNode A, int B) {
        ListNode p1 = A;
        ListNode p2 = A;

        int count = 0;
        while(p2 != null && count < B) {
            p2 = p2.next;
            count++;
        }
        if (p2 == null) {
            return p1.next;
        }

        while(p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return A;
    }
}
