//selection sort là tìm số lớn nhất hoặc nhỏ nhất rồi sắp xếp lại lần lượt cho vòng for
//Task: tìm số nhỏ nhất :))) từ trái qua phải
import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
    public static void swap(int[] arr, int a, int b){
        int stored= arr[a];
        arr[a] = arr[b];
        arr[b]= stored;
    }
    public static void selectionSort(int[] A){
        int n = A.length;
        for(int i = 0; i < n - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j < n; j++){
                if(A[j] < A[minIndex]){
                    minIndex = j;
                }
            }
            //Swap
            swap(A, minIndex, i);
        }
    }



    //Ngược lại, theo thứ tự từ bé tới lớn nhưng sort từ phải sang trái
    public static void inversedSelectionSortt(int[] A){
        int n= A.length;
        for(int i = n - 1; i > 0; i--){
            int maxIndex= i;
            for(int j = i - 1; j >= 0; j--){
                if(A[j]>A[maxIndex]){
                    maxIndex=j;
                }
                //Swap
                int stored= A[maxIndex];
                A[maxIndex]= A[i];
                A[i]= stored;
            }
        }
    }



    //main function
    public static void main(String[] args) {

        //có thể là mảng có sẵn:
        // int[] A={5, 7, 9, 1, 4, 2};

        //Scanner
        Scanner sc= new Scanner(System.in);
        System.out.println("Input 10 number from the keyboard:");
        int[] array= new int[10]; //tạo array
        //input each
        for(int i = 0; i < 10; i++){
            array[i]= sc.nextInt();
        }
        System.out.println("10 numbers are: " + Arrays.toString(array));
        selectionSort(array); //sắp xếp lại array
        // inversedSelectionSortt(array);

        // selectionSort(A);

        System.out.println("The result after sort:" + Arrays.toString(array)); //in array đã sắp xếp ra
        sc.close();
    }
}
