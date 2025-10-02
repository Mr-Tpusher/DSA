package linkedlist;

import java.util.HashMap;

/*
 * Given a modified linkedlist where each node has two pointers next and random,
 * clone the LL in exact same manner.
 * */
public class CloneRandomPointerLL {
    public static void main(String[] args) {
        RandomPointerNode<Integer> head = RandomPointerNode.populate();
        RandomPointerNode<Integer> clonedHead = cloneWithMap(head);
        RandomPointerNode.printNodes(clonedHead);


    }

    public static RandomPointerNode<Integer> clone(RandomPointerNode<Integer> head) {
        if (head == null) {
            return null;
        }

        // Step 1: Create cloned nodes and attach next to original nodes
        RandomPointerNode<Integer> curr = head;
        while (curr != null) {
            RandomPointerNode<Integer> next = curr.next;
            curr.next = new RandomPointerNode<>(curr.val);
            curr.next.next = next;
            curr = next;
        }

        // Step 2: Set the random pointers for the cloned nodes
        RandomPointerNode<Integer> ogPrev = head;
        curr = head.next; // cloned head
        while (curr != null) {
            curr.random = (ogPrev.random != null) ? ogPrev.random.next : null;
            ogPrev = curr.next;
            curr = (ogPrev != null) ? ogPrev.next : null; // Move to the next cloned node
        }

        // Step 3: Separate the cloned list from the original list
        RandomPointerNode<Integer> clonedHead = head.next;
        ogPrev = head;
        curr = clonedHead;
        while (curr != null) {
            RandomPointerNode<Integer> next = curr.next;
            ogPrev.next = next; // Restore original next pointer
            curr.next = next.next; // Restore cloned next pointer

            ogPrev = ogPrev.next; // Move to the next original node
            curr = curr.next; // move to the next cloned node
        }
        return clonedHead;
    }

    public static RandomPointerNode<Integer> cloneWithMap(RandomPointerNode<Integer> head) {

        RandomPointerNode<Integer> curr = head;
        HashMap<RandomPointerNode<Integer>, RandomPointerNode<Integer>> nodes = new HashMap<>();
        while (curr != null) {
            nodes.put(curr, new RandomPointerNode<>(curr.val));
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            RandomPointerNode<Integer> copy = nodes.get(curr);
            copy.next = nodes.get(curr.next);
            copy.random = nodes.get(curr.random);
            curr = curr.next;
        }
        return nodes.get(head);
    }
}

class RandomPointerNode<T> {
    T val;
    RandomPointerNode<T> next;
    RandomPointerNode<T> random;

    public RandomPointerNode(T val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    static RandomPointerNode<Integer> populate() {

        RandomPointerNode<Integer> head = new RandomPointerNode<>(0);
        RandomPointerNode<Integer> curr = head;
        HashMap<Integer, RandomPointerNode<Integer>> randoms = new HashMap<>();
        randoms.put(0, curr);
        for (int i = 1; i < 5; i++) {
            curr.next = new RandomPointerNode<>(i);
            curr = curr.next;
            randoms.put(i, curr);

        }

        curr = head;
        for (int i = 4; i >= 0; i--) {
            curr.random = randoms.get(i);
            curr = curr.next;
        }

        printNodes(head);
        return head;
    }

    public static void printNodes(RandomPointerNode<Integer> head) {
        RandomPointerNode<Integer> curr = head;
        StringBuilder sb = new StringBuilder("next: ");
        while (curr != null) {
            sb.append(curr.val).append(" ");
            curr = curr.next;
        }

        curr = head;
        StringBuilder sb2 = new StringBuilder("random: ");
        while (curr != null) {
            sb2.append(curr.random.val).append(" ");
            curr = curr.next;
        }
        System.out.println(sb);
        System.out.println(sb2);
    }
}

