//how it work: compare với số trước nó cho tới khi nó hết nhỏ nhất thì chèn vị trí của nó vào vị trí trước đó
import java.util.Arrays;
public class InsertionSort {
    public static void insertion(int[] A){
        int n= A.length;
        for(int i = 1; i < n; i++){
            int temp = A[i];
            int j = i;

            while(j > 0 && A[j - 1] >= temp){
                A[j]= A[j - 1];
                --j;
            }
            A[j]= temp;
        }
    }

    public static void main(String[] args) {
        int[] array= {9, 5, 7, 3, 1};
        insertion(array);
        System.out.println("The result after sort:" + Arrays.toString(array));
    }
}
