import java.io.*;
import java.util.*;

public class MrPip {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++){
            HashSet<Integer> cities = new HashSet<>();
            int road = sc.nextInt();
            for (int j = 0; j < road * 2; j++){
                int ele = sc.nextInt();
                cities.add(ele);
            }
            System.out.println(cities.size());
        }
    }
}