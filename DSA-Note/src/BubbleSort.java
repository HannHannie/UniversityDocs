//task: input 10 numbers from the key board and sort them from the smallest to the largest
import java.util.Scanner;
import java.util.Arrays;
public class BubbleSort{
    //swap method
    public static void swap (int[] A){

        // giảm dần kích thước của array sau 1 vòng vì số lớn nhất trong vòng đó đã được bubble up
        for(int j=A.length-1; j>0; j--){
            //length này -1 và j>0 vì index có chứa cả vị trí số 0
            for(int i=0; i< j; i++){
                if(A[i]>=A[i+1]){
                    int stored= A[i];
                    A[i]= A[i+1];
                    A[i+1]= stored;
                    // swap the value at these 2 indexes 
                }
            }
        }
    }

    //main function
    public static void main(String[] args) {
        //Scanner
        Scanner sc= new Scanner(System.in);
        System.out.println("Input 10 number from the keyboard:");
        int[] array= new int[10]; //tạo array
        //input each
        for(int i=0; i<10; i++){
            array[i]= sc.nextInt();
        }
        System.out.println("10 numbers are: " + Arrays.toString(array));
        swap(array); //sắp xếp lại array
        System.out.println("The result after sort:" + Arrays.toString(array)); //in array đã sắp xếp ra
        sc.close();
    }
}