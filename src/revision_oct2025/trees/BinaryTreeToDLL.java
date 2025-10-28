package revision_oct2025.trees;

public class BinaryTreeToDLL {
    BTNode head = null,prev = null;
    public static void main(String[] args) {
        BTNode root = BinaryTree.buildTree(new int[] {1, 2, 3, 4, 5, -1, 6});
        System.out.println(BinaryTree.inOrder(root));

        BinaryTreeToDLL btd = new BinaryTreeToDLL();
        btd.binaryTreeToDLL(root);
        printDLL(btd.head);

    }

    void binaryTreeToDLL(BTNode node) {
        if (node == null)
            return;

        binaryTreeToDLL(node.left);
        if (prev == null) {
            head = node;
        } else {
            prev.right = node;
            node.left = prev;
        }
        prev = node;
        binaryTreeToDLL(node.right);
    }


    static void printDLL(BTNode node) {
        while (node != null) {
            System.out.print(node.val + " <--> ");
            node = node.right;
        }
        System.out.print("null");
    }
}
