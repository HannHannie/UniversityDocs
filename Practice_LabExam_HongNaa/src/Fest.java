import java.util.Scanner;

public class Fest {
    static long[] stack = new long[1000000];
    static int topIndex = -1;

    public static void swapTopWithSecond() {
        long temp = stack[topIndex];
        stack[topIndex] = stack[topIndex - 1];
        stack[topIndex - 1] = temp;
    }

    public static void push(long playerId) {
        stack[++topIndex] = playerId;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int moves = scanner.nextInt();
            long initialPlayerId = scanner.nextLong();
            topIndex = -1;
            push(initialPlayerId);

            for (int i = 1; i <= moves; i++) {
                String command = scanner.next();
                if (command.charAt(0) == 'P') {
                    long newPlayerId = scanner.nextLong();
                    push(newPlayerId);
                } else {
                    swapTopWithSecond();
                }
            }
            System.out.println("Player " + stack[topIndex]);
        }
        scanner.close();
    }
}
