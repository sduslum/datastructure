package leetcode;

import java.util.HashMap;

public class LRUCache {

    HashMap<Integer, DNode> hashMap = new HashMap();
    int capacity = 0;
    DNode head;
    DNode tail;
    int size = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DNode(0, 0);
        tail = new DNode(0, 0);
        head.prev = null;
        head.next = tail;

        tail.prev = head;
        tail.next = null;
    }

    public int get(int key) {
        DNode node = hashMap.get(key);
        if(node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DNode cache = hashMap.get(key);
        if(cache == null) {
            DNode node = new DNode(key, value);
            addNode(node);
            hashMap.put(key, node);
            size++;

            if(size > capacity) {
                //delete tail
                DNode tail = popTail();
                hashMap.remove(tail.key);
                size--;
            }

        } else {
            cache.value = value;
            moveToHead(cache);
        }

    }

    private void addNode(DNode node) {
        //add node after head
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private DNode popTail() {
        DNode node = tail.prev;
        removeNode(node);
        return node;
    }

    private void moveToHead(DNode node) {
        removeNode(node);
        addNode(node);
    }

    class DNode {
        int key;
        int value;
        DNode prev;
        DNode next;

        DNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}