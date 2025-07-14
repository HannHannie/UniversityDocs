import java.util.Scanner;

public class DiagonalDiff {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        //1st diag
        int f = 0;
        for (int i = 0; i < n; i++){
            f += matrix[i][i];
        }
        int s = 0;
        int k = 0;
        for (int i = n - 1; i >= 0; i--){
            s += matrix[i][k++];
        }
        System.out.println(Math.abs(f - s));
        sc.close();
    }
}
