package dsa_2024_25.linkedlist;

public class PalindromeList {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        Node<Integer> head = ll.populateLinkedList(new Integer[] {1,2,3,4,5,3,2,1});
        System.out.println(ll);
        System.out.println(isPalindrome(head));
        System.out.println(isPalindrome2(head));

    }

    public static boolean isPalindrome(Node<Integer> head) {

        if (head == null || head.getNext() == null) {
            return true;
        }

        // create clone of the given linkedlist
        Node<Integer> head2 = cloneAndReverseLL(head);

        // compare each element of both linked lists
        Node<Integer> temp1, temp2;
        temp1 = head;
        temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (!temp1.getData().equals(temp2.getData())) {
                return false;
            }
            temp1 = temp1.getNext();
            temp2 = temp2.getNext();
        }
        return true;
    }

    public static boolean isPalindrome2(Node<Integer> head) {
        if (head == null || head.getNext() == null) {
            return true;
        }

        // Find middle
        Node<Integer> slowPointer = head;
        Node<Integer> fastPointer = head;
        while (fastPointer != null && fastPointer.getNext() != null) {
            slowPointer = slowPointer.getNext();
            fastPointer = fastPointer.getNext().getNext();
        }
        // Reverse the second half
        Node<Integer> secondHalfHead = slowPointer;
        slowPointer.setNext(null);
        secondHalfHead = reverse(secondHalfHead);

        Node<Integer> temp1, temp2;
        temp1 = head;
        temp2 = secondHalfHead;

        while (temp1 != null && temp2 != null) {
            if (!temp1.getData().equals(temp2.getData())) {
                return false;
            }
            temp1 = temp1.getNext();
            temp2 = temp2.getNext();
        }
        return true;
    }


    private static Node<Integer> cloneAndReverseLL(Node<Integer> originalHead) {
        Node<Integer> clonedLLHead = new Node<>(originalHead.getData());
        Node<Integer> temp = originalHead.getNext();
        while (temp != null) {
            clonedLLHead.setNext(new Node<>(temp.getData()));
            temp = temp.getNext();
        }
        return reverse(clonedLLHead);
    }

    private static Node<Integer> reverse(Node<Integer> head) {
        // reverse the cloned linkedlist
        Node<Integer> prev, curr, next;
        curr = head;
        prev = next = null;
        while (curr != null) {
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }
}
