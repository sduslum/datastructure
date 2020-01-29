package hash;

import java.util.HashMap;

public class LRUBaseHashTable<K,V> {
    private static int DEFAULT_CAPACITY = 10; //默认链表容量
    private DNode<K, V> headNode;
    private DNode<K, V> tailNode;
    private HashMap<K, DNode<K, V>> table;
    private int length;//链表当前长度
    private int capacity;//链表容量
    static class DNode<K, V> {
        private K key;
        private V value;
        private DNode<K, V> prev;
        private DNode<K, V> next;
        DNode() {

        }

        public DNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUBaseHashTable(int capacity) {
        this.length = 0;
        this.capacity = capacity;
        headNode = new DNode<>();
        tailNode = new DNode<>();
        headNode.next = tailNode;
        tailNode.prev = headNode;

        table = new HashMap<>();

    }

    public LRUBaseHashTable() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 将新节点加到头部(是指headNode的下一个，headNode是作为哨兵用的)
     * @param newNode
     */
    private void addNode(DNode<K, V> newNode) {
        newNode.next = headNode.next;
        newNode.prev = headNode;

        headNode.next.prev = newNode;
        headNode.next = newNode;
    }

    /**
     * 移除节点
     * @param node
     */
    private void removeNode(DNode<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 弹出尾部数据节点(是指tailNode的上一个，tailNode是作为哨兵用的)
     */
    private DNode<K, V> popTail() {
        DNode<K, V> node = tailNode.prev;
        removeNode(node);
        return node;
    }

    /**
     * 把节点移动到头部
     * @param node
     */
    private void moveToHead(DNode<K, V> node) {
        removeNode(node);
        addNode(node);
    }

    /**
     * 新增
     * @param key
     * @param value
     */
    public void add(K key, V value) {
        DNode<K, V> node = table.get(key);
        if(node == null) {
            //如果不存在
            node = new DNode(key, value);
            addNode(node);
            table.put(key, node);
            length++;
            if(length > capacity) {
                popTail();
                table.remove(node); //note 这里要删除
                length--; //note 这里要删除
            }
        } else {
            //如果存在，更新value，并把节点移动到头部
            node.value = value;
            moveToHead(node);
        }
    }

    /**
     * 获取数据
     * @param key
     */
    public V get(K key) {
        DNode<K, V> node = table.get(key);
        if(node == null) {
            return null;
        }
        moveToHead(node);
        return node.value;
    }

    /**
     * 删除数据
     * @param key
     */
    public void remove(K key) {
        DNode<K, V> node = table.get(key);
        if(node != null) {
            removeNode(node);
            length--;
            table.remove(node); //note table中的也要删除
        }
    }

    public void printAll() {
        DNode<K, V> node = headNode.next;
        while (node.next != null) {
            System.out.print(node.next.value + ",");
            node = node.next;
        }
        System.out.println();

    }

}
