package bst;

import java.util.ArrayList;

/*
* Given a BST and provided its two pointers i.e. root and ptr,
* find what is the next element after ptr in In-Order traversal.
*                       20
*                     /    \
*                   8       22
*                 /   \
*               4       12
*                     /    \
*                   10      14
* ptr=8, ans=10
*
*
* */
public class NextPointer {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        BSTNode<Integer> root = bst.buildBST(new int[]{20,8,22,4,12,10,14});
        int ptr = 8;
        System.out.println(getNextPointer1(root, ptr));

        System.out.println(getNextPointer2(root, ptr));
    }

    private static Integer getNextPointer2(BSTNode<Integer> root, int ptr) {
        // The idea is to find the next pointer while traversing recursively
        // instead of calculating whole inorder traversal
        return getNextPointerRecursively(root, ptr, null);
    }

    private static Integer getNextPointerRecursively(BSTNode<Integer> root, int ptr, Integer candidate) {
        if (root == null) {
            return null;
        }

        if (root.getValue() == ptr) {
            if (root.getRight() == null) {
                return candidate;
            } else {
                BSTNode<Integer> temp = root.getRight();
                while (temp.getLeft() != null) {
                    temp = temp.getLeft();
                }
                return temp.getValue();
            }
        } else if (root.getValue() < ptr) {
           return getNextPointerRecursively(root.getRight(),ptr, candidate);
        } else {
            return getNextPointerRecursively(root.getLeft(),ptr, root.getValue());
        }
    }


    public static Integer getNextPointer1(BSTNode<Integer> root, int ptr) {
        ArrayList<Integer> inorder = getInOrderTraversal(root);
        int left = 0, right = inorder.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (inorder.get(mid) == ptr) {
                if ((mid + 1) < inorder.size()) {
                    return inorder.get(mid + 1);
                }
            } else if (inorder.get(mid) < ptr) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    private static ArrayList<Integer> getInOrderTraversal(BSTNode<Integer> root) {
        ArrayList<Integer> inorder = new ArrayList<>();
        inorderRecursive(root, inorder);
        return inorder;
    }

    private static void inorderRecursive(BSTNode<Integer> root, ArrayList<Integer> inorder) {
        if (root == null) {
            return;
        }
        inorderRecursive(root.getLeft(), inorder);
        inorder.add(root.getValue());
        inorderRecursive(root.getRight(), inorder);
    }
}
