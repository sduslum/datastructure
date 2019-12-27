package array;

/**
 * 1)数组的插入，删除，按照下标随机访问操作
 * 2）数组中的数据是int类型的
 */
public class Array {
    private int[] data;
    private int count;
    public Array(int capacity) {
        data = new int[capacity];
        count = 0;
    }

    //根据索引，找到数据中的元素并返回
    public int find(int index) {
        if(index < 0 || index >= count) {
            System.out.println("index is out of bounds");
            return -1;
        }
        return data[index];
    }

    //插入元素
    public boolean insert(int index, int value) {
        if(count == data.length) {
            //数组已经满了
            System.out.println("array is full, no space left");
            return false;
        }
        if(index < 0 || index >= data.length) {
            System.out.println("index is out of bounds");
            return false;
        }
        
        for(int i = count; i > index; i--) {
            data[i] = data[i-1];
        }
        data[index] = value;
        count++;
        return true;
    }

    //根据索引，删除数组中元素
    public boolean delete(int index) {
        if(index < 0 || index >= count) {
            System.out.println("index is out of bounds");
            return false;
        }
        for(int i = index;i < count - 1;i++) {
            data[i] = data[i+1];
        }
        count--;
        return true;
    }

    public void printAll() {
        for(int i = 0; i < count; i++ ) {
            System.out.print(data[i] + " ");
        }

    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        array.delete(3);
        array.printAll();
    }
 
}