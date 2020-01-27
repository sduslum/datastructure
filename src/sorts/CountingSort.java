package sorts;

import java.util.Arrays;

public class CountingSort {
    public static void countingSort(int[] a) {
        if(a.length < 2) return;
        int n = a.length;

        int max = a[0];
        for(int i = 1; i < n; i++) {
            if(a[i] > max) {
                max = a[i];
            }
        }

        int[] c = new int[max+1];
        for(int i = 0;i < n; i++) {
            c[a[i]]++;
        }

        for(int i =1;i< c.length;i++) {
            c[i] = c[i-1] + c[i];
        }

        int[] r = new int[n];
        for(int i = n - 1; i >= 0; i--) {
            int index = c[a[i]] - 1;
            r[index] = a[i];
            c[a[i]]--;
        }

        for(int i = 0; i < n; i++) {
            a[i] = r[i];
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[] {1,5,6,2,3,4};
        CountingSort.countingSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
