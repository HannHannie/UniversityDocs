public class ShellSort {
    public static void shellsort(int[] arr) {
        int gap;
        int n= arr.length;
        for (gap = n / 2; gap > 0; gap = gap / 2) { //initially gap = n/2, decreasing by gap /2
            for (int j = gap; j < n; j++) {
                for (int k = j - gap; k >= 0; k -= gap) {
                    if (arr[k + gap] >= arr[k])
                        break;
                    else {
                        int temp;
                        temp = arr[k + gap];
                        arr[k + gap] = arr[k];
                        arr[k] = temp;
                    }
                }
            }
        }
    }
}
