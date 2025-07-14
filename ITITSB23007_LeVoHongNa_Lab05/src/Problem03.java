public class Problem03 {
    int sum(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        else {
            return n + sum(n - 1);
        }
    }
}
