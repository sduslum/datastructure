package linkedlist;

/**
 * 1）单链表的插入、删除、查找操作；
 * 2）链表中存储的是int类型的数据；
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
        while (p != null && pos != index) {
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
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    //链表尾部插入
    public void insertTail(int value) {
        Node newNode = new Node(value, null);
        insertTail(newNode);
    }

    public void insertTail(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            Node p = head;
            while (p.next != null) {
                p = p.next;
            }
            p.next = newNode;
        }
    }

    public void insertAfter(Node p, int value) {
        Node newNode = new Node(value, null);
        insertAfter(p, newNode);
    }

    public void insertAfter(Node p, Node newNode) {
        if (p == null) return;
        newNode.next = p.next;
        p.next = newNode;
    }

    public void insertBefore(Node p, int value) {
        Node newNode = new Node(value, null);
        insertBefore(p, newNode);
    }

    public void insertBefore(Node p, Node newNode) {
        if (p == null) return;
        if (p == head) {
            newNode.next = p;
            head = newNode;
        } else {
            Node previousNode = head;
            while (previousNode != null && previousNode.next != p) {
                previousNode = previousNode.next;
            }
            if (previousNode == null) {
                //目标节点不在链表中
                return;
            }
            newNode.next = p;
            previousNode.next = newNode;
        }
    }

    public void deleteByNode(Node p) {
        if (p == null || head == null) return;
        if (p == head) {
            head = head.next;
        } else {
            Node temp = head;
            while (temp.next != p && temp != null) {
                temp = temp.next;
            }
            if (temp == null) return;
            temp.next = p.next;
            p.next = null;
            p = null;
        }
    }

    //todo 重复练习
    public void deleteByValue(int value) {
        if (head == null) return;
        while (head != null && head.data == value) {
            head = head.next;
        }
        Node p = head;
        while (p != null) {
            if (p.next != null && p.next.data == value) {
                p.next = p.next.next;
                continue;
            }
            p = p.next;
        }
    }

    //链表翻转
    public Node inverseLinkList(Node p){
        Node r = head;
        Node prev = null;
        Node next = null;
        while (r != p) {
            next = r.next;
            r.next = prev;
            prev = r;
            r = next;
        }
        r.next = prev;
        return r;
    }

    //todo 重复练习
    public Node inverseLinkList() {
        Node r = head;
        Node prev = null;
        Node next = null;
        while (r.next != null) {
            next = r.next;
            r.next = prev;
            prev = r;
            r = next;
        }
        r.next = prev;
        head = r;
        return r;
    }

    //判断true or false
    public boolean TFResult(Node left, Node right){
        boolean flag = true;
        while (left != null && right != null) {
            if(left.data != right.data) {
                flag = false;
                break;
            }
            left = left.next;
            right = right.next;
        }
        return flag;
    }

    //判断是否是回文字符串
    public boolean palindrome() {
        if(head == null) return false;
        Node p = head;
        Node q = head;
        while (q.next != null && q.next.next != null) {
            p = p.next;
            q = q.next.next;
        }
        Node leftIndex = null;
        Node rightIndex = null;
        if(q.next == null) {
            //奇数
            rightIndex = p.next;
            leftIndex = inverseLinkList(p).next;

        } else {
            //偶数
            rightIndex = p.next;
            leftIndex = inverseLinkList(p);
        }
        return TFResult(leftIndex, rightIndex);
    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
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

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertTail(2);
        list.insertTail(3);
        list.insertTail(3);
        list.insertTail(2);
        list.printAll();
        boolean isPalindrome = list.palindrome();
        System.out.println("isPalindrome : " + isPalindrome);
    }
}
