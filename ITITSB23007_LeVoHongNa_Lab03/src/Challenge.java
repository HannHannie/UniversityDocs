import java.util.*;

class DequeQueueOperations {
    public static void rearrangeDeque(Deque<Integer> D, Queue<Integer> Q) {
        for (int i = 0; i < 3; i++) {
            Q.add(D.removeFirst());
        }

        int four = D.removeFirst();
        int five = D.removeFirst();
        D.addFirst(four);
        D.addFirst(five);

        while (!Q.isEmpty()) {
            D.addFirst(Q.remove());
        }
    }

    public static void reverseDeque(Deque<Integer> D, Queue<Integer> Q) {
        while (!D.isEmpty()){
            Q.add(D.removeFirst());
        }
        while (!Q.isEmpty()){
            D.addFirst(Q.remove());
        }
    }

    public static void main(String[] args) {
        Deque<Integer> D = new ArrayDeque<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        Queue<Integer> Q = new LinkedList<>();

        System.out.println("Original D: " + D);
        rearrangeDeque(D, Q);
        System.out.println("After rearranging: " + D);

        reverseDeque(D, Q);
        System.out.println("After reversing: " + D);
    }
}
