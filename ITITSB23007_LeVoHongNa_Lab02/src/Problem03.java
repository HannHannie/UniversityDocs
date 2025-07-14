class ArrayInsertSort{
    private long[] a;
    private int numEle;
    private int numPasses;
    //constructor
    public ArrayInsertSort(int size){
        a = new long[size];
        numEle = 0;
        numPasses = 0;
    }
    public void insert(long value){
        a[numEle] = value;
        numEle++;
    }
    public void display(){
        for(int i = 0; i < numEle; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public void insertionSort(){
        for(int i = 1; i < numEle; i++){
            long temp = a[i];
            int j = i;

            while(j>0 && a[j-1]>= temp){
                numPasses ++;
                a[j]= a[j-1];
                --j;
            }
            a[j]= temp;
        }
    }

    public int getNumPasses(){
        return numPasses;
    }
}

class InsertionSortApp{
    public static void main(String[] args) {
        int size = 100;
        ArrayInsertSort arr = new ArrayInsertSort(size);

        arr.insert(10);
        arr.insert(2);
        arr.insert(5);
        arr.insert(1);
        arr.insert(9);
        arr.insert(8);
        arr.insert(3);
        arr.insert(4);
        arr.insert(6);
        arr.insert(7);

        arr.display();
        arr.insertionSort();
        arr.display();

        System.out.println("The number of passes: " + arr.getNumPasses());
    }
}
