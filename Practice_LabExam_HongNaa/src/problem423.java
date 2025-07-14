import java.util.HashSet;
import java.util.Scanner;

public class problem423 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numofnum = sc.nextInt();
        HashSet<Integer> list = new HashSet<>();
        for (int i = 0; i < numofnum; i++){
            list.add(sc.nextInt());
        }
        System.out.println(list.size());
    }
}
