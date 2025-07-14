package Problem02;
import java.util.Arrays;

class OrderedArray {
    private int[] arr;
    private int nElems;
    private int comparisons;

    public OrderedArray(int size) {
        arr = new int[size];
        nElems = 0;
    }

    public void insert(int value) {
        arr[nElems++] = value;
        Arrays.sort(arr, 0, nElems); // Keep array sorted
    }

    public boolean find(int searchKey) {
        comparisons = 0;
        int left = 0, right = nElems - 1;

        while (left <= right) {
            comparisons++;
            int mid = left + (right - left) / 2;

            if (arr[mid] == searchKey) {
                return true;
            } else if (arr[mid] < searchKey) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public int getComparisons() {
        return comparisons;
    }
}
