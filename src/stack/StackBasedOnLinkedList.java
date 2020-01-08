package stack;

public class StackBasedOnLinkedList {
    private Node top = null;

    public void push(int value) {
        Node node = new Node(value, null);
        if(top == null) {
            top = node;
        } else {
            node.next = top;
            top = node;
        }
    }

    public int pop() {
        if(top == null) return -1;
        int value = top.data;
        top = top.next;
        return value;
    }

    private static class Node {
        private int data;
        private Node next;
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
