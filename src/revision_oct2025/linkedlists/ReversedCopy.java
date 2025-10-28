package revision_oct2025.linkedlists;
/*
* Creates reversed copy of the singly linked list without modifying it.
* @param head - head of the original list
* @return reversedHead
*
* */
public class ReversedCopy {
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        System.out.print("original list: ");
        LinkedListUtil.printLL(one);
        System.out.print("reversed copy: ");
        ListNode head = reversedCopy(one);
        LinkedListUtil.printLL(head);
    }

    static ListNode reversedCopy(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode curr = new ListNode(head.val);
            curr.next = prev;
            prev = curr;
            head = head.next;
        }
        return prev;
    }
}
