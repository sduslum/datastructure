package search;

public class BinarySearch {
    public int bsearch(int[] a, int value) {
        int n = a.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int middle = low + ((high - low) >> 1); // (low + high)/2会溢出
//            int middle = (low + high)/2; // (low + high)/2会溢出
            if(a[middle] == value) {
                return middle;
            } else if(a[middle] > value) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        return -1;
    }

    public int bsearch2(int[] a, int value) {
        return recursionBsearch(a, 0, a.length - 1, value);
    }

    public int recursionBsearch(int[] a,int low, int high, int value) {
        if(low > high) return -1;
        int middle = low + ((high - low) >> 1);
        if(a[middle] == value) {
            return middle;
        } else if(a[middle] > value) {
            return recursionBsearch(a, low, middle - 1, value);
        } else {
            return recursionBsearch(a, middle + 1, high, value);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,4,5,6,11,12,20};
        BinarySearch binarySearch = new BinarySearch();
//        int index = binarySearch.bsearch(a, 5);
        int index = binarySearch.bsearch2(a, 5);
        System.out.println(index);
    }
}
