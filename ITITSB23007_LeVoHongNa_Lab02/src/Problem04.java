import java.util.*;
public class Problem04 {
    //variables
    static int comparisons, copies, swaps;

    //bubble sort
    public static void bubbleSort(int[] arr) {
        comparisons = 0;
        copies = 0;
        swaps = 0;
        int n = arr.length;
        for(int j = n - 1; j > 0; j--){
            for(int i = 0; i < n - 1; i++){
                comparisons ++;
                if(arr[i]>=arr[i+1]){
                    int stored= arr[i];
                    arr[i]= arr[i+1];
                    arr[i+1]= stored;
                    swaps++;
                }
            }
        }
    }

    //selection sort
    public static void selectionSort(int[] arr) {
        comparisons = 0;
        copies = 0;
        swaps = 0;
        int n = arr.length;

        for(int i = 0; i < n - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j < n; j++){
                comparisons ++;
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int stored= arr[minIndex];
            arr[minIndex]= arr[i];
            arr[i]= stored;
            swaps++;
        }
    }

    //Insertion sort
    public static void insertionSort(int[] arr) {
        comparisons = 0;
        copies = 0;
        swaps = 0;
        int n = arr.length;
        for(int i = 1; i < n; i++){
            int temp = arr[i];
            copies ++;
            int j = i;

            while(j>0 && arr[j-1]>= temp){
                comparisons ++;
                arr[j]= arr[j-1];
                copies ++;
                --j;
            }
            arr[j]= temp;
        }
    }


    //random array
    public static int[] generateRandomArray(int s){
        Random rand = new Random();
        int[] arr = new int[s];
        for(int i = 0; i < s; i++){
            arr[i] = rand.nextInt();
        }
        return arr;
    }

    //switch case xem nó chạy cái sort nào
    public static void solve (String methods, int sizes){
        int[] arr = generateRandomArray(sizes);
        switch (methods) {
            case "BubbleSort":
                bubbleSort(arr);
                break;
            case "SelectionSort":
                selectionSort(arr);
                break;
            case "InsertionSort":
                insertionSort(arr);
                break;
            default:
                break;
        }
    // print out
        System.out.println(methods + ": " + "Comparisons: " + comparisons + ", Copies: " + copies + ", Swaps: " + swaps);
    }

    public static void main(String[] args) {
        int[] size = {10000, 15000, 20000, 25000, 30000};
        for (int s : size) {
            System.out.println("Size: " + s);
            solve("BubbleSort", s);
            solve("SelectionSort", s);
            solve("InsertionSort", s);
            System.out.println();
        }
    }
}