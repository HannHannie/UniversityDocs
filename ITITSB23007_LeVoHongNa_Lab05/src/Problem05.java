public class Problem05 {
    int findsum(int[] a, int n){
        if (a == null || n <= 0){
            return 0;
        }
        else if (n == 1){
            return a[n - 1];
        }
        else{
            return a[n - 1] + findsum(a, n - 1);
        }
    }
}