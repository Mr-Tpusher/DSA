package revision_oct2025.linkedlists;
/*
* Given a LinkedList create its copy.
* */
public class CopyLinkedList {
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
        LinkedListUtil.printLL(one);

        ListNode head2 = copyLL(one);
        LinkedListUtil.printLL(head2);

        ListNode head3 = copyLL(null);
        LinkedListUtil.printLL(head3);

        ListNode head4 = copyUsingDummyNode(one);
        LinkedListUtil.printLL(head4);

        ListNode head5 = copyUsingDummyNode(null);
        LinkedListUtil.printLL(head5);


    }

    static ListNode copyLL(ListNode head) {
        if (head == null)
            return null;

        ListNode newHead = new ListNode(head.val);
        ListNode curr = head;
        ListNode tail = newHead;

        while (curr != null && curr.next != null) {
            curr = curr.next;
            tail.next = new ListNode(curr.val);
            tail = tail.next;
        }
        return newHead;
    }

    static ListNode copyUsingDummyNode(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode curr1 = head, curr2 = dummy;
        while (curr1 != null) {
            curr2.next = new ListNode(curr1.val);
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return dummy.next;
    }
}
