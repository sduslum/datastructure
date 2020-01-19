package sorts;

import java.util.Arrays;

public class SelectionSort {
    private void selectionSort(int[] a) {
        int n = a.length;
        if (n <= 1) return;


        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            //每次都选择最小的往未排序区间插入
            for (int j = i + 1; j < n; j++) {
                if(a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int a[] = {3,4,1,2,6,7};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.selectionSort(a);
        System.out.println(Arrays.toString(a));
    }
}
