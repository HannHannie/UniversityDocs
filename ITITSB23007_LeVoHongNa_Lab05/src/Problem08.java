public class Problem08 {
    String generate(int[] a, int n){
        if (a == null || n == 0){
            return "";
        }
        else if (n == 1){
            return String.valueOf(a[0]);
        }
        else {
            return generate(a, n - 1) + " " + String.valueOf(a[n - 1]);
        }
    }
}
