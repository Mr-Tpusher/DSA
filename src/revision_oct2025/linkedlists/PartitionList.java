package revision_oct2025.linkedlists;
/*
* Given a linkedlist and a value B, partition it such that, all the values less B come before
* all the values greater than or equal to B.
*
* */
public class PartitionList {
    public static void main(String[] args) {
        ListNode head = LinkedListUtil.createSinglyLinkedList(new int[] {1, 4, 3, 2, 5, 2});
        LinkedListUtil.printLL(head);
        ListNode partitionedHead = partition(head, 3);
        LinkedListUtil.printLL(partitionedHead);
    }

    static ListNode partition(ListNode A, int B) {
        ListNode dummy1, dummy2;
        dummy1 = new ListNode(0);
        dummy2 = new ListNode(0);

        ListNode curr = A, curr1 = dummy1, curr2 = dummy2;
        while (curr != null) {
            ListNode next = curr.next;

            if (curr.val < B) {
                curr1.next = curr;
                curr1 = curr1.next;
            } else {
                curr2.next = curr;
                curr2 = curr2.next;
            }
            curr.next = null;
            curr = next;
        }
        curr1.next = dummy2.next;

        return dummy1.next;
    }
}
