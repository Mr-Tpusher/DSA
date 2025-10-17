package revison_oct2025.linkedlists;

public class MyLinkedList {
    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList();

        ListNode head = ll.insertUsingDummyHead(null, 1);
        LinkedListUtil.printLL(head);

        ListNode head2 = ll.insertUsingDummyHead(head, 2);
        LinkedListUtil.printLL(head2);

        ListNode head3 = ll.insertUsingDummyHead(head2, 5);
        LinkedListUtil.printLL(head3);



    }

    ListNode insert(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            return newNode;
        }

        ListNode prev = head;
        ListNode curr = head.next;
        while (curr != null) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = newNode;
        return head;
    }

    ListNode insertUsingDummyHead(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = dummy.next;
        while (curr != null) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = new ListNode(val);
        return dummy.next;
    }
}
