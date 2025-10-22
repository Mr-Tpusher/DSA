package revison_oct2025.bst;
/*
* Given a BST root and a node ptr, find the next node after the pointer in inorder traversal of the bst
*           20
*         /    \
*       8       22
*      / \
*     4   12
*         /\
*       10   14
* ptr: 8 , ans = 10
*
* */
public class InOrderSuccessor {
    public static void main(String[] args) {
        BSTNode root = BinarySearchTree.constructBST(new int[] {20, 8, 22, 4, 12, 10, 14});
        System.out.println(inOrderSuccessor(root, 8));
        System.out.println(inOrderSuccessor(root, 20));
        System.out.println(inOrderSuccessor(root,4));
        System.out.println(inOrderSuccessor(root,22));
    }

    static int inOrderSuccessor(BSTNode root, int ptr) {
        BSTNode ans = inOrderSuccessorRecursive(root, ptr, null);
        return ans == null ? -1 : ans.val;
    }

    static BSTNode inOrderSuccessorRecursive(BSTNode node, int ptr, BSTNode candidate) {
        if (node == null) return null;

        if (ptr == node.val) {
            // if the ptr has a right subtree then find the next element in that
            // else candidate is the answer
            if (node.right != null) {
                BSTNode temp = node.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                return temp;

            } else {
                return candidate;
            }

        } else if (ptr < node.val) {
            return inOrderSuccessorRecursive(node.left, ptr, node);
        } else {
            return inOrderSuccessorRecursive(node.right,ptr, candidate);
        }
    }

}
