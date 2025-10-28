package revision_oct2025.linkedlists;

public class PalindromeList {
    public static void main(String[] args) {
        ListNode one1 = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode one2 = new ListNode(1);
        one1.next = two;
        two.next = one2;
//        LinkedListUtil.printLL(one1);
//        System.out.println(isPalindrome(one1) == 1? "true" : "false");

        ListNode three = new ListNode(3);
        one2.next = three;
        LinkedListUtil.printLL(one1);

        System.out.println(isPalindromeBF(one1) == 1? "true" : "false");
    }

    static int isPalindromeBF(ListNode A) {
        // copy the LL
        ListNode dummy = new ListNode(0);
        ListNode copyListTail = dummy;
        ListNode ogListCurr = A;
        while (ogListCurr != null) {
            copyListTail.next = new ListNode(ogListCurr.val);
            copyListTail = copyListTail.next;
            ogListCurr = ogListCurr.next;
        }

        // reverse the linkedlist
        ListNode prev = null, curr = dummy.next;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode reversedHead = prev;

        while (A != null && reversedHead != null) {
            if (A.val != reversedHead.val)
                return 0;
            A = A.next;
            reversedHead = reversedHead.next;
        }
        return 1;
    }

    static int isPalindrome(ListNode A) {
        ListNode slow = A, fast = A;

        // find the middle element
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // split the linkedlist into two parts from the middle
        ListNode head2 = slow.next;
        slow.next = null;

        // reverse second parts
        ListNode prev = null;
        ListNode curr = head2;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head2 = prev;
        ListNode head1 = A;
        // compare list1 and reversed list2
        while (head1 != null || head2 != null) {
            if (head1 == null || head2 == null)
                return 1;
            if (head1.val != head2.val) {
                return 0;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        return 1;
    }
}
