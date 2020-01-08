package queue;

public class CircularQueue {
    private int[] data;
    private int head = 0;
    private int tail = 0;
    private int size = 0;

    public CircularQueue(int capacity) {
        data = new int[capacity];
    }

    // 入队
    public boolean enqueue(int item) {
        if(size == data.length) {
            System.out.println("queue is full");
            return false;
        }
        data[tail] = item;
        size++;
        tail = (tail + 1) % data.length;
        return true;
    }

    // 出队
    public int dequeue() {
        if(size == 0) {
            System.out.println("queue is empty");
            return -1;
        }
        int value = data[head];
        size--;
        head = (head + 1) % data.length;
        return value;
    }

    public void printAll() {
        if(size == 0) {
            System.out.println();
            return;
        }
        for(int i = 0, index = head; i < size; i++, index = (index + 1) % data.length) {
            System.out.print(data[index] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(3);
        queue.enqueue(2);
        queue.enqueue(1);
        queue.enqueue(3);
        queue.printAll();
        System.out.println("dequeue :" + queue.dequeue());
        queue.printAll();
        System.out.println("dequeue :" + queue.dequeue());
        queue.printAll();
        System.out.println("dequeue :" + queue.dequeue());
        queue.printAll();
        System.out.println("dequeue :" + queue.dequeue());
    }
}
