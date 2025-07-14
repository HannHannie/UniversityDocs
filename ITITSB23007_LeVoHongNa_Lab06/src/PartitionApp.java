import java.util.*;
class eleOfArray{
    private long[] arr;
    private int nOfEle;
    private int cswap = 0;
    private int comparison = 0;
    //constructor
    public eleOfArray(int size){
        arr = new long[size];
        nOfEle = 0;
        cswap = 0;
        comparison = 0;
    }

    public void insert(long data){
        arr[nOfEle] = data;
        nOfEle ++;
    }

    public int size(){
        return nOfEle;
    }

    public void display(){
        System.out.print("[ ");
        for (int i = 0; i < nOfEle; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    public void swap(int a, int b){
        long temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        cswap++;
    }

    public int partition(int left, int right, long pivot){
        //shift the smaller than pivot element to the left and the other to right
        int leftPtr = left - 1;
        int rightPtr = right + 1;
        while(true){
            //tìm index của 2 ele bị sai index and swap
            while(leftPtr < right && arr[++leftPtr] < pivot) comparison++;
            while(rightPtr > left && arr[--rightPtr] > pivot) comparison++;

            if(leftPtr >= rightPtr) break; //until they cross each other
            else swap(leftPtr, rightPtr);
        }
        return leftPtr;
    }

    public int nOfSwap(){
        return cswap;
    }

    public int nOfComparison(){
        return comparison;
    }
}

public class PartitionApp {
    public static void main(String[] args) {
        Random rd = new Random();
        Scanner sc = new Scanner(System.in);

        int size = 20;
        eleOfArray arr = new eleOfArray(size);
        for (int i = 0; i < size; i++){
            long random = rd.nextLong(100);
            arr.insert(random);
        }
        arr.display();

        System.out.println("Input pivot: ");
        long pivot = sc.nextLong();
        int value = arr.partition(0, size - 1, pivot);
        System.out.println("Partition is at index: " + value);
        arr.display();
        System.out.println("The number of swaps is: " + arr.nOfSwap());
        System.out.println("The number of comparisons is: " + arr.nOfComparison());

        sc.close();
    }
}