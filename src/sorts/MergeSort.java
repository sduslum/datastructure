package sorts;

import java.util.Arrays;

public class MergeSort {
    private void sort(int[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    private void mergeSort(int[] arr, int l, int r) {
        if(l >= r) return;
        int middle = (l+r)/2;
        mergeSort(arr, l, middle);
        mergeSort(arr, middle + 1, r);

        merge(arr,l, middle, r);
    }

    //把arr[left...middle] 和 arr[middle+1...right]有序的合并为arr[left...right]
    private void merge(int[] arr, int left, int middle, int right) {
        int[] tmp = new int[right - left + 1];
        int index = 0;
        int i = left;
        int j = middle + 1;
        while (i <= middle && j <= right) {
            if(arr[i] <= arr[j]) {
                tmp[index++] = arr[i++];
            } else {
                tmp[index++] = arr[j++];
            }
        }
        while (i <= middle) {
            tmp[index++] = arr[i++];
        }
        while (j <= right) {
            tmp[index++] = arr[j++];
        }
        for(int l = 0; l <= right - left; l++) {
            arr[l+left] = tmp[l];
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[] {1,5,6,2,3,4};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
