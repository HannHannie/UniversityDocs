import java.util.*;

public class EqualStacks {
    public static int equalStackHeight(int[] h1, int[] h2, int[] h3) {
        Stack<Integer> stack1 = createHeightStack(h1);
        Stack<Integer> stack2 = createHeightStack(h2);
        Stack<Integer> stack3 = createHeightStack(h3);

        while (!stack1.isEmpty() && !stack2.isEmpty() && !stack3.isEmpty()) {
            int height1 = stack1.peek();
            int height2 = stack2.peek();
            int height3 = stack3.peek();

            if (height1 == height2 && height2 == height3) {
                return height1;
            }

            if (height1 >= height2 && height1 >= height3) {
                stack1.pop();
            } else if (height2 >= height1 && height2 >= height3) {
                stack2.pop();
            } else {
                stack3.pop();
            }
        }

        return 0;
    }

    private static Stack<Integer> createHeightStack(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            sum += heights[i];
            stack.push(sum);
        }
        return stack;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();

        int[] h1 = new int[n1];
        int[] h2 = new int[n2];
        int[] h3 = new int[n3];

        for (int i = 0; i < n1; i++) h1[i] = scanner.nextInt();
        for (int i = 0; i < n2; i++) h2[i] = scanner.nextInt();
        for (int i = 0; i < n3; i++) h3[i] = scanner.nextInt();

        System.out.println(equalStackHeight(h1, h2, h3));

        scanner.close();
    }
}