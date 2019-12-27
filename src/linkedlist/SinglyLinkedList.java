package linkedlist;
/**
 * 1）单链表的插入、删除、查找操作；
 * 2）链表中存储的是int类型的数据；
 *
 */
public class SinglyLinkedList {
    private Node head;

    public Node findByValue(int value) {
        Node p = head;
        while (p != null && p.data != value) {
            p = p.next;
        }
        return p;
    }

    public Node findByIndex(int index) {
        Node p = head;
        int pos = 0;
        while(p != null && pos != index ) {
            p = p.next;
            pos++;
        }
        return p;
    }

    public void insertToHead(int value) {
        Node newNode = new Node(value, null);
        insertToHead(newNode);
    }

    public void insertToHead(Node newNode) {
        if(head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertTail(Node newNode) {

    }

    class Node {
       private int data;
       private Node next;
       public Node(int data, Node next) {
           this.data = data;
           this.next = next;
       }

       public int getData() {
           return data;
       }
    }
}
