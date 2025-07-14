import java.util.*;

public class Scramble {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String[] dictionary = new String[n];
        for (int i = 0; i < n; i++) {
            dictionary[i] = sc.nextLine().trim();
        }

        char[][] board = new char[4][4];
        for (int i = 0; i < 4; i++) {
            String line = sc.nextLine().trim();
            while (line.length() != 4) {
                line = sc.nextLine().trim();
            }
            board[i] = line.toCharArray();
        }

        for (int i = 0; i < 4; i++) sc.nextLine();
        for (int i = 0; i < 4; i++) sc.nextLine();

        int startScore = sc.nextInt();
        int scorePerWord = sc.nextInt();

        int score = startScore;
        Set<String> found = new HashSet<>();

        for (char[] row : board) {
            String rowStr = new String(row);
            for (String word : dictionary) {
                if ((rowStr.contains(word) || rowStr.contains(new StringBuilder(word).reverse().toString())) && !found.contains(word)) {
                    score += scorePerWord;
                    found.add(word);
                }
            }
        }

        for (int col = 0; col < 4; col++) {
            StringBuilder colStr = new StringBuilder();
            for (int row = 0; row < 4; row++) {
                colStr.append(board[row][col]);
            }

            String colStrVal = colStr.toString();
            for (String word : dictionary) {
                if ((colStrVal.contains(word) || colStrVal.contains(new StringBuilder(word).reverse().toString())) && !found.contains(word)) {
                    score += scorePerWord;
                    found.add(word);
                }
            }
        }

        System.out.println(score);
    }
}
