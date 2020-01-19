package sorts;

import java.util.Arrays;

public class InsertionSort {

    private void insertionSort(int a[]) {
        int n = a.length;
        if(n <= 1) return;

        for(int i = 1; i < n; i++) {
            int value = a[i];
            //查找要插入的位置并移动数据
            int j = i - 1;
            for(;j>=0;j--) {
                if(value < a[j]) {
                    a[j+1] = a[j];
                } else {
                    break;
                }
            }
            a[j+1] = value;
        }
    }

    public static void main(String[] args) {
        int a[] = {3,4,1,2,6,7};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.insertionSort(a);
        System.out.println(Arrays.toString(a));
    }
}
