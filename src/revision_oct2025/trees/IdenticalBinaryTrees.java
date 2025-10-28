package revision_oct2025.trees;

public class IdenticalBinaryTrees {
    public static void main(String[] args) {

    }
    public int isSameTree(BTNode A, BTNode B) {
        return areEqual(A, B) ? 1 : 0;

    }

    boolean areEqual(BTNode A, BTNode B) {
        // If both current roots are null, the tree is essentially null
        if (A == null && B == null)  return true;

        // If any of the roots is null means their values do not match, i.e. they are not equal.
        if (A == null || B == null) return false;

        return (A.val == B.val && areEqual(A.left, B.left) && areEqual(A.right, B.right));

    }
}
