package revision_oct2025.stack;

public class MyStackDemo {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        System.out.println(myStack.isEmpty());
        System.out.println(myStack.push(1));
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack);
        System.out.println("current top = " + myStack.top());
        System.out.println("popped = " + myStack.pop());
        System.out.println("stack : " + myStack);
        System.out.println("popped = " + myStack.pop());
        System.out.println("stack : " + myStack);
        myStack.push(4);
        System.out.println(myStack);
    }
}
