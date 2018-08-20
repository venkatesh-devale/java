public class MyCircularQueue {
    int[] q;
    int rear;
    int front;
    int size;
    boolean empty;
    public MyCircularQueue(int k) {
        size = k;
        q = new int[size];
        front = -1;
        rear = -1;
        empty = true;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(!isFull()) {
            if(isEmpty()) {
                ++front;
                empty = false;
            }
            rear = ++rear%size;
            q[rear] = value;
            return true;
        }
        return false;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(!isEmpty()) {
            if(front == rear) {
                front = -1;
                rear = -1;
                empty = true;
            }
            else {
                front = ++front%size;
            }
            return true;
        }
        return false;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty())
            return -1;
        return q[front%size];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty())
            return -1;
        return q[rear%size];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return empty;
    }

    public void print() {
        if(!isEmpty()) {
            for(int i = front; i <= rear; i++) {
                System.out.print(q[i]+ " ");
            }
            System.out.println();
        }
        else {
            System.out.println("q empty");
        }
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if(front == (rear+1)%size) {
            return true;
        }
        return false;
    }
}
