import java.io.*;
import java.util.*;

public class ACM {

    //hong biết lèmmm
    public static void main(String[] args) {
        HashMap<Integer, HashMap<String, String>> input = new HashMap<>();
        HashMap<String, String> detail = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        while (sc.nextInt() != -1){
            int a = sc.nextInt();
            String b = sc.nextLine();
            String c = sc.nextLine();
            detail.put(b, c);
            input.put(a, detail);
        }
    }
}