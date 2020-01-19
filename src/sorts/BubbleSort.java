package sorts;

import java.util.Arrays;

public class BubbleSort {

    private void bubbleSort(int[] a) {
        int n = a.length;
        for(int i = 0; i < n; i++) {
            boolean flag = false;
            for(int j = 0; j < n-1-i; j++) {
                if(a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag) {
               break;
            }
        }
    }

    public static void main(String[] args) {
        int a[] = {3,4,1,2,6,7};
//        int a[] = {1};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }
}
