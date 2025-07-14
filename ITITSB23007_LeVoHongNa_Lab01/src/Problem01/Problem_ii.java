package Problem01;

import java.util.*;
public class Problem_ii {
    public static void MiddleNumber(double[] A){
        int n= A.length;
        for(int i=0; i< n-1; i++){
            int minIndex= i;
            for(int j=i+1; j<n; j++) {
                if (A[j] < A[minIndex]) {
                    minIndex = j;
                }
            }
                //Swap
                double stored= A[minIndex];
                A[minIndex]= A[i];
                A[i]= stored;
        }

        if (A.length == 0){
            throw new IllegalArgumentException("Input is empty");
        }
        else {
            if (A.length%2 == 0){
                //even
                int a = A.length/2;
                int b = A.length/2 - 1;
                System.out.println((A[a] + A[b])/2);
            }
            else {
                //odd
                int index = A.length/2;
                System.out.println(A[index]);
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number: ");
        String input = sc.nextLine();
        String[] Arr = input.split("\\s+"); //tách String thành Array bởi 1 hoặc nhiều space
        double[] arr = new double[Arr.length];

        for (int i = 0; i < Arr.length; i++) {
            arr[i] = Double.parseDouble(Arr[i]);
        }

        System.out.println("Output:");
        MiddleNumber(arr);
        sc.close();
    }
}
