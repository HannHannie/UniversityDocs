import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Problem4_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int price = sc.nextInt();
        int[] pr = new int[price];

        int custom = sc.nextInt();
        int[] ct = new int[custom];

        for (int i = 0; i < price; i++){
            pr[i] = sc.nextInt();
        }
        for (int i = 0; i < custom; i++){
            ct[i] = sc.nextInt();
        }
        for (int i = 0; i < custom; i++){
            int max = 0;
            int index = -1;
            for (int j = 0; j < price; j++){
                if(pr[j] <= ct[i] && pr[j] > max){
                    max = pr[j];
                    index = j;
                }
            }
            if (index != -1){
                pr[index] = 0;
                System.out.println(max);
            } else {
                System.out.println(-1);
            }
        }
    }
}