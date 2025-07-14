import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ProCon {
    //sum of 2 highest pro, skip these case and calculate the sum of other cons
    //arrange pro the list, then minus 2 and cal the other cons
    public static void ans(int[][] a){

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();

        for(int i = 0; i < testcase; i++){
            int option = sc.nextInt();
            int[][] arr = new int[option][2];

            for (int j = 0; j < option; j++){
                for (int k = 0; k < 2; k++){
                    arr[j][k] = sc.nextInt();
                }
            }
            ans(arr);
        }
        sc.close();
    }
}