import java.util.Arrays;
public class Delete{
    public static int[] delete(int A[], int x){
        int index=-1;
        for(int i=0; i< A.length; i++){
            //tìm vị trí của index nơi mà A[i] bằng số x (x được cho sẵn)
            if (A[i]==x){
                index=i;
                break;
            }
        }
        // nếu không gán được giá trị khác cho index thì nó vẫn ở -1, thì trả về chuỗi A ban đầu
        if (index==-1){
            return A;
        }

        //tạo array mới (ít hơn array cũ 1 phần tử)
        int[] newArray= new int[A.length-1];
        for(int i=0, j=0; i<A.length; i++){
            if(i!= index){
                newArray[j]= A[i];
                j++;
                //or newArray[j++]= A[i];
            }
        }
        return newArray; //vì nó là "int[]" nên kết quả phải return về dạng int[] luôn :))
    }

    public static void main(String[] args){
        int[] A={1,2,3,4,5,6,7};
        int x=5;
        int[] result= delete(A, x);
        System.out.println(Arrays.toString(result));
    }
}