package Problem01;

import java.util.Scanner;

public class Problem_iii {
    public static int minGap(int[] arr, int n) {
        if ( arr.length < 2 ) {
            return 0;
        } else {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n - 1; i++) {
                int minInner = arr[i + 1] - arr[i];
                min = Math.min(min, minInner);
            }
            return min;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input: ");
        String input = sc.nextLine();
        String[] arr = input.split("\\s+");
        int[] numArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            numArr[i] = Integer.parseInt(arr[i]);
        }
        int n = numArr.length;
        int result = minGap(numArr, n);
        System.out.println("Output: \n" + result);
        sc.close();
    }
}
