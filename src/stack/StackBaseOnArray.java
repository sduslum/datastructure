package stack;

public class StackBaseOnArray {
    private int[] data;
    private int top = 0;
    public StackBaseOnArray(int capacity) {
        data = new int[capacity];
    }

    public void push(int value) {
        if(top == data.length) {
            System.out.println("stack is full");
            return;
        }
        data[top++] = value;
    }

    public int pop() {
        if(top == 0) {
           System.out.println("stack is empty");
           return -1;
        }
        return data[--top]; //注意这里是先减1
    }
}
