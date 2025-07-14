import java.io.*;
import java.util.*;

public class SoccerBets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++){
            Set<String> team = new HashSet<>();
            Set<String> eleminate = new HashSet<>();
            for (int j = 0; j < 16; j++){
                String t1 = sc.next();
                String t2 = sc.next();
                int g1 = sc.nextInt();
                int g2 = sc.nextInt();

                team.add(t1);
                team.add(t2);

                if (g1 > g2){
                    team.remove(t2);
                    eleminate.add(t2);
                }
                else if (g2 > g1){
                    team.remove(t1);
                    eleminate.add(t1);
                }

                if (eleminate.contains(t1)){
                    team.remove(t1);
                }
                if (eleminate.contains(t2)){
                    team.remove(t2);
                }
            }
            for (String winner : team){
                System.out.println(winner);
            }
        }
        sc.close();
    }
}