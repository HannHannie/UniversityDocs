import java.util.*;
public class MineSweeper{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        for(int i = 0; i < testcase; i++){
            int row = sc.nextInt();
            sc.nextLine();
            int col = row;
            Character[][] s1 = new Character[row][col];
            for (int a = 0; a < row; a++) {
                String s = sc.nextLine();
                char[] xs = s.toCharArray();
                for (int b = 0; b < col; b++) {
                    s1[a][b] = xs[b];
                }
            }

            Character[][] s2 = new Character[row][col];
            for (int a = 0; a < row; a++) {
                String s = sc.nextLine();
                char[] xs = s.toCharArray();
                for (int b = 0; b < col; b++) {
                    s2[a][b] = xs[b];
                }
            }

            Character[][] s3 = new Character[row][col];
            for (int a = 0; a < row; a++) {
                for (int b = 0; b < col; b++) {
                    if (s2[a][b] == 'x' || s2[a][b] == 'X'){
                        int count = 0;
                        for (int dx = -1; dx <= 1; dx++) {
                            for (int dy = -1; dy <= 1; dy++) {
                                if (dx == 0 && dy == 0) continue;
                                int ni = a + dx;
                                int nj = b + dy;
                                if (ni >= 0 && ni < row && nj >= 0 && nj < col) {
                                    if (s1[ni][nj] == '*') count++;
                                }
                            }
                        }
                        s3[a][b] = (char)(count + '0');
                    } else {
                        s3[a][b] = '.';
                    }
                }
            }

            for (int a = 0; a < row; a++) {
                for (int b = 0; b < col; b++) {
                    System.out.print(s3[a][b]);
                }
                System.out.println();
            }
            System.out.println();
        }
        sc.close();
    }
}