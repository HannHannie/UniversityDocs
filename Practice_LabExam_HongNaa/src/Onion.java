import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Onion {
    public static void isOnion(String a){
        char[] c = a.toCharArray();
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < c.length; i++){
            if(c[i] == '('){
                st.push(c[i]);
            } else if (Character.isLetter(c[i]) || c[i] == ' '){
                continue;
            } else if (c[i] == ')'){
                if (st.isEmpty()){
                    System.out.println("#False");
                    return;
                } else {
                    st.pop();
                }
            }
        }
        if (st.isEmpty()){
            System.out.println("#True");
        } else {
            System.out.println("#False");
        }
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            if(s.isEmpty()){
                continue;
            }
            isOnion(s);
        }
        sc.close();
    }
}