import java.util.Arrays;
public class deleteDuplication {
    public static int[] deleteDup(int A[], int n, int X){
        //idea: count số duplications sau đó tạo newArray với length= n-count
        int count=0;
        for (int i=0; i< n; i++){
            if(A[i]==X){
                count++;
            }
        }
        //tạo new array
        int[] newArray= new int[A.length-count];
        for (int i=0, j=0; i<A.length; i++){
            if(A[i]!=X){
                newArray[j++]= A[i];
                //gán giá trị vào new Array ở vị trí j trước rồi mới tăng j lên 1 đơn vị
            }
        }
        return newArray; // nhớ phải trả giá trị về newArray nheeeee
    }

    public static void main(String[] args){
        int[] A= {1, 2, 3, 4, 5, 2, 4, 6, 8};
        int X= 2;
        int n= A.length;
        // int[] result= deleteDup(A, n, X);
        System.out.println("The result after deleting the duplication: "+ Arrays.toString(deleteDup(A, n, X)));
    }
}
