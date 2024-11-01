package trees;

public class BTNode<T> {
    private T value;
    private BTNode<T> left;
    private BTNode<T> right;

    public BTNode(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public BTNode<T> getLeft() {
        return left;
    }

    public void setLeft(BTNode<T> left) {
        this.left = left;
    }

    public BTNode<T> getRight() {
        return right;
    }

    public void setRight(BTNode<T> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "BTNode{" +
                "value=" + value +
                '}';
    }
}
