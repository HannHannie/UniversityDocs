import java.io.*;
import java.util.*;

public class IPS {
    public static Stack<Integer> separate(int a){
        Stack<Integer> numList = new Stack<>();
        int temp = a;
        while (temp > 0){
            numList.add(temp % 10);
            temp /= 10;
        }
        return numList;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numofcase = sc.nextInt();
        String[] arr = new String[numofcase];

        for(int i = 0; i < numofcase; i++){
            arr[i] = sc.next();
        }

        sc.close();
    }
}