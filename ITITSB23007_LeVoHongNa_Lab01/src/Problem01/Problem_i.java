package Problem01;

import java.util.*;

public class Problem_i {
    public static void convert(char[] arr) {
        int n = arr.length;
        boolean isHexa = false;
        boolean isNegative = false;
        StringBuilder numStr = new StringBuilder();

        int startIndex = 0;

        //check negative
        if (arr[0] == '-') {
            isNegative = true;
            startIndex = 1;
        }

        for (int i = startIndex; i < n; i++) {
            char c = arr[i];

            if (c == ',' || c == ' ') {
                continue;
            } else if (Character.isDigit(c)) {
                numStr.append(c);
            } else if (c >= 'A' && c <= 'F') {
                isHexa = true;
                numStr.append(c);
            } else {
                throw new IllegalArgumentException("Input contains an invalid character: " + c);
            }
        }

        if (numStr.isEmpty()) {
            throw new IllegalArgumentException("No valid number found in input.");
        }

        int out;
        if (isHexa) {
            out = Integer.parseInt(numStr.toString(), 16);
        } else {
            out = Integer.parseInt(numStr.toString());
        }
        if (isNegative) {
            out = -out;
        }
        System.out.print(out);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input: ");
        String input = sc.nextLine();

        char[] numArr = input.toCharArray();

        System.out.println("Output: ");
        convert(numArr);

        sc.close();
    }
}