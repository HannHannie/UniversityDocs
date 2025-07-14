import java.io.*;
import java.util.*;

public class Bits4 {
    public static int[] reverse(int[] a){
        int[] b = new int[a.length];
        for(int i = 0; i < a.length; i++){
            b[i] = a[a.length - 1 - i];
        }
        return b;
    }
    public static int[] i_to_b(long num){
        long temp = num;
        int[] arr = new int[32];
        int x = 31;
        while (temp > 0){
            if(temp % 2 == 1){
                arr[x] = 1;
            } else {
                arr[x] = 0;
            }
            x--;
            temp /= 2;
        }
        return arr;
    }
    public static long b_to_i(int[] a){
        long cal = 0;
        int x = 0;
        for (int i = a.length - 1; i >= 0; i--){
            cal += a[i] * Math.pow(2, x);
            x++;
        }
        return cal;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numofcase = sc.nextInt();
        long[] arr = new long[numofcase];
        for(int i = 0; i < numofcase; i++){
            arr[i] = sc.nextLong();
        }
        for(int i = 0; i < numofcase; i++){
            System.out.println(b_to_i(reverse(i_to_b(arr[i]))));
        }
        sc.close();
    }
}