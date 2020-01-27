package sorts;

import java.util.Arrays;

public class RadixSort {
    public static void radixSort(int[] a) {
        int n = a.length;
        if(n < 2) return;
        int max = a[0];
        for(int i = 0; i < n; i++) {
            if(a[i] > max) {
                max = a[i];
            }
        }

        //从个位开始，按照每一位对数组进行计数排序
        for(int exp = 1; max / exp > 0 ; exp = exp * 10) {
            countingSort(a, exp);
        }
    }

    public static void countingSort(int[] a, int exp) {
        if(a.length < 2) return;

        //计算每个元素的个数
        int[] c = new int[10];
        for(int i = 0;i < a.length;i++) {
            c[(a[i]/exp)%10]++;
        }

        //累加
        for(int i = 1;i < 10; i++) {
            c[i] += c[i-1];
        }

        int[] r= new int[a.length];
        for(int i = a.length -1;i>=0;i--) {
            int index = c[(a[i]/exp)%10] - 1;
            r[index] = a[i];
            c[(a[i]/exp)%10]--;
        }

        for(int i = 0; i < a.length; i++) {
            a[i] = r[i];
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[] {11,5,6,2,3,4};
        RadixSort.radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
