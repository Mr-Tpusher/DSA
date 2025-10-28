package revision_oct2025.queues;

class SimpleArrayDequeueMain {
    public static void main(String[] args) {
        SimpleArrayQueue queue = new SimpleArrayDequeueMain().new SimpleArrayQueue(10);
        System.out.println(queue);
        queue.enqueue(5);
        queue.enqueue(8);
        queue.enqueue(3);
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(queue);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        System.out.println(queue);
        queue.enqueue(10);
    }

    class SimpleArrayQueue {
        int[] q;
        int front = 0;
        int rear = -1;

        SimpleArrayQueue(int size) {
            q = new int[size];
        }

        boolean isEmpty() {
            return front > rear;
        }

        void enqueue(int x) {
            if (rear - front == q.length - 1) {
                throw new RuntimeException("Overflow");
            }
            q[++rear % q.length] = x;
        }

        void dequeue() {
            if (isEmpty())
                throw new RuntimeException("Underflow");
            front++;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("queue: [");
            for (int i = front; i <= rear; i++) {
                sb.append(q[i % q.length]);
                if (i != rear) {
                    sb.append(" ,");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }
}
