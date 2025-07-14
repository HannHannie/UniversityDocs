import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class String89 {
    public static int ans(String a){
        //hem hiểu đề trời ơiiiiii
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        String[] arr = new String[input];
        for(int i = 0; i < input; i++){
            arr[i] = sc.nextLine();
        }
        for(int i = 0; i < input; i++){
            System.out.println(ans(arr[i]));
        }
        sc.close();
    }
}