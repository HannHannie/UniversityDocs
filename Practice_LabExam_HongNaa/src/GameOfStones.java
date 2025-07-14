import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class GameOfStones {

    /*
     * Complete the 'gameOfStones' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER n as parameter.
     */

    public static String gameOfStones(int n) {
        // Write your code here
        if (n == 1) return "Second";
        boolean[] moves = new boolean[n + 1];

        moves[0] = false;
        for(int i = 1; i <= n; i++){
            boolean canWin = false;

            if (i >= 2 && !moves[i - 2]) canWin = true;
            if (i >= 3 && !moves[i - 3]) canWin = true;
            if (i >= 5 && !moves[i - 5]) canWin = true;

            moves[i] = canWin;
        }
        return moves[n] ? "First" : "Second";
    //===============================================
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                String result = GameOfStones.gameOfStones(n);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
