package revision_oct2025.linkedlists;

public class RemoveDupesFromSortedList {
    public static void main(String[] args) {
        ListNode one1 = new ListNode(1);
        ListNode one2 = new ListNode(1);
        ListNode one3 = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three1 = new ListNode(3);
        ListNode three2 = new ListNode(3);
        one1.next = one2;
        one2.next = one3;
        one3.next = two;
        two.next = three1;
        three1.next = three2;
        printList(one1);

        ListNode head = deleteDuplicates(one1);
        printList(head);
    }

    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null)
                System.out.print("->");
            head = head.next;
        }
        System.out.println();
    }

    static ListNode deleteDuplicates(ListNode A) {
        ListNode slow = A, fast = A;
        while(fast != null && fast.next != null) {
            if (fast.val == slow.val) {
                fast = fast.next;
            } else {
                slow.next = fast;
                slow = fast;
                fast = fast.next;
            }
        }
        if (fast.val == slow.val)
            slow.next = null;
        return A;
    }
}
