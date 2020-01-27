package sorts;


public class KthSmallest {
    public int kthSmallest(int[] arr, int k) {
        if (arr == null || arr.length < k) {
            return -1;
        }
        int q = partition(arr, 0, arr.length - 1);

        while (k != q+1) {
            if(k < q+1) {
                q = partition(arr, 0, q - 1);
            } else {
                q = partition(arr, q + 1, arr.length - 1);
            }
        }
        return arr[q]; //这里是q

    }

    public int partition(int[] arr, int p, int r) {
        int pivot = arr[r];
        int i =p;
        for(int j = p; j < r; j++) {
            if(arr[j] <= pivot) { //note 快速排序里面可以是<，但是 这里一定要是 <= ，不然会出现死循环，比如查找数组 [1,1,2] 的第二小的元素
                //swap arr[i] and a[j]
                swap(arr, i, j);
                i++;
            }
        }
        //swap arr[i] and arr[r]
        swap(arr, i, r);
        return i;
    }

    public void swap(int[] arr, int i, int j) {
        if(i == j) return;
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
//        int arr[] = new int[] {1,5,6,2,3,4};
        int arr[] = new int[] {1,1,2};
        KthSmallest kthSmallest = new KthSmallest();
        int result = kthSmallest.kthSmallest(arr, 2);
        System.out.println(result);
    }
}