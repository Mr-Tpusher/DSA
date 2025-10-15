package revison_oct2025.linkedlists;

import java.util.List;

public class KReverseLinkedList {
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        ListNode seven = new ListNode(7);
        ListNode eight = new ListNode(8);
        ListNode nine = new ListNode(9);

        one.next  = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = eight;
        eight.next = nine;

        printList(one);

        ListNode head = reverseList(one, 3);
        printList(head);
    }

    static ListNode reverseList(ListNode A, int B) {
        ListNode prev, start, end, next;
        // set the pointers initially
        prev = null;
        start = A;
        end = A;
        int count = 1;
        while (count < B) {
            end = end.next;
            count++;
        }
        next = end.next;

        // head of the overall linkedlist is last element of the first B-sized window i.e. if B=3,  3 is the head ie. 3->2->1->.....
        ListNode head = end;

        while(true) {
            reverse(start, B);
            // link the reversed linkedlist
            if (prev != null)
                prev.next = end;

            start.next = next;

            if (next == null)
                break;

            // increment the pointers
            prev = start;
            start = next;
            end = start;
            count = 1;
            while (count < B) {
                count++;
                end = end.next;
            }
            next = end.next;
        }

        return head;
    }

    static void reverse(ListNode start, int B) {
        ListNode prev, curr, next;
        prev = null;
        next = null;
        curr = start;
        int count = 0;

        while (curr != null && count < B) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;

            count++;
        }
    }

    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null)
                System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();

    }
}
