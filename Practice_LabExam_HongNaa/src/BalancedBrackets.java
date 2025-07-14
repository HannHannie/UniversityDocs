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

class Res{

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        // Write your code here
            Stack<Character> st = new Stack<>();
            char[] c = s.toCharArray();
            for (int i = 0; i < c.length; i++){
                if(c[i] == '(' || c[i] == '{' || c[i] == '['){
                    st.push(c[i]);
                } else if (c[i] == ')' || c[i] == '}' || c[i] == ']'){
                    if(st.isEmpty()){
                        return "NO";
                    }
                    char check = st.pop();
                    if (c[i] == ')' && check != '(' ||
                        c[i] == '}' && check != '{' ||
                        c[i] == ']' && check != '[' ){
                        return "NO";
                    }
                }
            }
        return st.isEmpty() ? "YES" : "NO";
    }

}

public class BalancedBrackets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Res.isBalanced(s);

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
