package revision_oct2025.linkedlists;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class ReverseBetween {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        LinkedListUtil.printLL(head);
        ListNode reversedHead = reverseBetween(head, 2, 4);
        LinkedListUtil.printLL(reversedHead);
    }
    static ListNode reverseBetween(ListNode A, int B, int C) {
        if (B == C)
            return A;

        ListNode prev, start, end, next;
        prev = next = null;
        start = end = A;

        ListNode curr = A;
        int position = 1;
        while (curr != null) {
            if (position == B - 1) {
                prev = curr;
            }
            if (position == B) {
                start = curr;
            }
            if (position == C) {
                end = curr;
            }
            if (position == C + 1) {
                next = curr;
                break;
            }

            curr = curr.next;
            position++;
        }


        ListNode reversedHead = reverse(start, C - B + 1);
        System.out.println("reversed ll");
        LinkedListUtil.printLL(A);

        if (prev != null)
            prev.next = reversedHead;
        start.next = next;

        if (B == 1)
            return end;
        return A;
    }

    static ListNode reverse(ListNode start, int pos) {
        ListNode prev, curr, next;
        prev = null;
        curr = start;
        int count = 0;

        while (curr != null && count < pos) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        return prev;
    }
}
