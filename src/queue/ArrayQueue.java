package queue;

public class ArrayQueue {
    private int[] data;
    private int head = 0;
    private int tail = 0;
    public ArrayQueue(int capacity) {
        data = new int[capacity];
    }

    // 入队操作，将item放入队尾
    public boolean enqueue(int item) {
        if(tail == data.length) {
            //表示tail引用到了队列的尾部+1
            if(head == 0) {
                System.out.println("queue is full");
                return false;//说明队列空间满了
            }
            //移动数据
            for(int i = head ; i < tail;i ++) {
                data[i - head] = data[i];
            }
            tail = tail - head;
            head = 0;
        }
        data[tail++] = item;
        return true;
    }

    // 出队
    public int dequeue() {
        if(head == tail) {
            System.out.println("queue is empty");
            return -1;
        }
        int ret = data[head];
        head++;
        return ret;
    }
}
