package linkedlist;

/**
 * 1) 单链表反转
 * 2) 链表中环的检测
 * 3) 两个有序的链表合并
 * 4) 删除链表倒数第n个结点
 * 5) 求链表的中间结点
 *
 */
public class LinkedListAlgo {

    // 单链表反转
    public static Node reverse(Node list) {
        if(list == null) return list;
        Node p = list;
        Node prev = null;
        while (p != null) {
            Node next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        return prev;
    }

    // 检测环
    public static boolean checkCircle(Node list) {
        if(list == null) return false;
        Node slow = list;
        Node fast = list.next;
        while (fast != null && fast.next != null) {
            if(fast == slow) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }


    // 有序链表合并
    public Node mergeTwoLists(Node l1, Node l2) {
        Node solider = new Node(0, null);
        Node p = solider;
        while (l1 != null && l2 != null) {
            if(l1.data < l2.data) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;// note
        }
        if(l1 != null) p.next = l1;
        if(l2 != null) p.next = l2;
        return solider.next;
    }

    // 删除倒数第K个结点 todo 重复练习
    public static Node deleteLastKth(Node list, int k) {
        if(list == null) return list;
        Node fast = list;
        //往后移动k-1次， 比如删除倒数第二个，那么slow和fast之间相差1个
        for(int i = 1;i < k; i++) {
            if(fast != null) {
                fast = fast.next;
            }
        }
        if(fast == null) return list;

        Node slow = list;
        Node prev = null;
        while (fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        if(prev == null) {
            //如果prev为null，说明要删除的是头结点
            list = list.next;
        } else {
            prev.next = prev.next.next;
        }
        return list;
    }

    // 求中间结点
    public static Node findMiddleNode(Node list) {
        if(list == null) return list;
        Node slow = list;
        Node fast = list;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static class Node {
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
