package sorts;

import java.util.Arrays;

public class QuickSort {
    private void sort(int[] a) {
        quick_sort(a, 0, a.length - 1);
    }

    private void quick_sort(int[] a, int p, int r) {
        if(p >= r) return;
       int middle = partition(a, p, r);
       quick_sort(a, p, middle - 1);
       quick_sort(a, middle + 1, r);
    }

    private int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p, j = p; //j用于遍历数组， i之前的用于存放比pivot小的数据
        for(;j < r;j++) {
            if(a[j] <= pivot) {
                //swap a[j] and a[i]
                if(i == j) {
                    i++; //如果i==j，就不用交换了，浪费时间
                } else {
                    int tmp = a[j];
                    a[j] = a[i];
                    a[i] = tmp;
                    i++;
                }
            }
        }
        //swap a[i] and a[r]
        int temp = a[r];
        a[r] = a[i];
        a[i] = temp;
        return i;
    }

    public static void main(String[] args) {
        int arr[] = new int[] {1,5,6,2,3,4};
//        int arr[] = new int[] {1,1,2};
        QuickSort sort = new QuickSort();
        sort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
