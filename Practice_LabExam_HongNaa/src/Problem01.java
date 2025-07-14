import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Problem01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfInt = sc.nextInt();
        int[] arr = new int[numOfInt - 1];

        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        int sum = 0;
        for (int i = 1; i <= numOfInt; i++){
            sum += i;
        }
        for(int i = 0; i < arr.length; i++){
            sum -= arr[i];
        }
        System.out.println(sum);
        sc.close();
    }
}