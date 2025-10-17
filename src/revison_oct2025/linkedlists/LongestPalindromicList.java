package revison_oct2025.linkedlists;

import java.util.HashMap;

public class LongestPalindromicList {
    public static void main(String[] args) {
        ListNode head = LinkedListUtil.createSinglyLinkedList(new int[] {1, 4, 3, 4, 2, 4, 3, 9});
        //ListNode head = LinkedListUtil.createSinglyLinkedList(new int[] {2, 2});
        LinkedListUtil.printLL(head);

        System.out.println(getLongestPalindromicBF(head));


    }

    /*
    * We will use expand from the center approach.
    * But in linkedlists we cannot move backwards from a particular node.
    * for that we will get a reversed copy of the linkedlist.
    * Now moving in left direction from any node will be just iterating over the reversed copy.
    *
    * */
    static int getLongestPalindromicBF(ListNode head) {
        if (head == null) return 0;

        // create the reversed copy and also store mapping of original node and the copy
        ListNode prev = null;
        ListNode ogCurr = head;
        HashMap<ListNode, ListNode> nodesMapping = new HashMap<>();
        while (ogCurr != null) {
            ListNode curr = new ListNode(ogCurr.val);
            nodesMapping.put(ogCurr, curr);
            curr.next = prev;
            prev = curr;
            ogCurr = ogCurr.next;
        }
        ListNode reversedCopyHead = prev;
        System.out.println("reversed copy list : ");
        LinkedListUtil.printLL(reversedCopyHead);

        // for each node, expand across centres
        ListNode curr = head;
        int answer = 0;
        while (curr != null && curr.next != null) {
            int ans1 = palindromeLength(nodesMapping.get(curr), curr.next);

            int ans2 = 0;
            if (curr.next.next != null)
                ans2 = palindromeLength(nodesMapping.get(curr), curr.next.next) + 1;
            
            answer = Math.max(answer, Math.max(ans1, ans2));
            curr = curr.next;
        }
        return answer;
    }

    static int palindromeLength(ListNode head1, ListNode head2) {
        int count = 0;
        while (head1 != null && head2 != null) {
            if (head1.val == head2.val) {
                count += 2;
                head1 = head1.next;
                head2 = head2.next;
            } else {
                break;
            }
        }
        return count;
    }
}
