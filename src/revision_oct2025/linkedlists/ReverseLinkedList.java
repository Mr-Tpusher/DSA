package revision_oct2025.linkedlists;

public class ReverseLinkedList {
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
        printList(one);

        ListNode head = reverse(one);
        printList(head);

    }

    static ListNode reverse(ListNode head) {
        ListNode curr, prev, next;
        curr = head;
        prev = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static void printList(ListNode temp) {

        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null)
                System.out.print("->");
            temp = temp.next;
        }
        System.out.println();
    }
}
