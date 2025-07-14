import java.io.*;
import java.util.*;

public class KhoaPug {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();
        long[] nums = new long[N];
        for (int i = 0; i < N; i++){
            nums[i] = sc.nextLong();
        }
        long[] check = new long[Q];
        for (int i = 0; i < Q; i++){
            check[i] = sc.nextLong();
        }

        for (int i = 0; i < Q; i++){
            boolean isNum = false;
            for (int j = 0; j < N; j++){
                if (check[i] == nums[j]){
                    isNum = true;
                }
            }
            if (isNum)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        sc.close();
    }
}