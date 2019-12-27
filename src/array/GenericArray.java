package array;

import java.util.ArrayList;

public class GenericArray<T> {
    private T data[];
    private int size;

    public GenericArray(int capacity) {
        data = (T[])new Object[capacity];
        size = 0;
    }

    public GenericArray() {
        this(10);
    }

    // 获取数组容量
    public int getCapacity() {
        return data.length;
    }

    // 获取当前元素个数
    public int count() {
        return size;
    }

    // 判断数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 修改 index 位置的元素
    public void set(int index, T e) {
        checkIndex(index);
        data[index] = e;
    }

    // 获取对应 index 位置的元素
    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    // 查看数组是否包含元素e
    public boolean contains(T e) {
        for(int i = 0; i < size; i++) {
            if(data[i].equals(e)) {
               return true;
            }
        }
        return false;
    }

    // 获取对应元素的下标, 未找到，返回 -1
    public int find(T e) {
        for(int i = 0; i < size; i++) {
            if(data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    // 在 index 位置，插入元素e, 时间复杂度 O(m+n)
    public void add(int index, T e) {
        checkIndexForAdd(index);
        if(size == data.length) {
            resize(2 * data.length);
        }
        for(int i = size; i > index; i--) {
            data[i] = data[i-1];
        }
        data[index] = e;
        size++;
    }

    // 向数组头插入元素
    public void addFirst(T e) {
        add(0, e);
    }

    // 向数组尾插入元素
    public void addLast(T e) {
        add(size, e);
    }

    // 删除 index 位置的元素，并返回
    public T remove(int index) {
        checkIndex(index);
        T ret = data[index];
        for(int i = index; i < size - 1; i++) {
            data[i] = data[i+1];
        }
        data[size - 1] = null;
        size--;
        return ret;
    }

    // 删除第一个元素
    public T removeFirst() {
        return remove(0);
    }

    // 删除末尾元素
    public T removeLast() {
        return remove(size - 1);
    }

    // 从数组中删除指定元素
    public void removeElement(T e) {
        int index = find(e);
        if(index != -1) {
            remove(index);
        }
    }

    // 扩容方法，时间复杂度 O(n)
    private void resize(int capacity) {
        T newData[] = (T[]) new Object[capacity];
        for(int i= 0; i < data.length;i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    private void checkIndex(int index) {
        if(index < 0 || index >= size) {
            throw  new IllegalArgumentException("index out of bounds");
        }
    }

    private void checkIndexForAdd(int index) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("add failed! Require index >=0 and index <= size.");
        }
    }

    public void printAll() {
        for(int i = 0; i < size; i++ ) {
            System.out.print(data[i] + " ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        GenericArray array = new GenericArray(5);
        array.addLast(1);
        array.printAll();
        array.addLast(2);
        array.printAll();
        array.addLast(3);
        array.printAll();
        array.addLast(4);
        array.printAll();
        array.remove(3);
        array.printAll();
    }

}
