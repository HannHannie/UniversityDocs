class ArraySelectionSort{
    private long[] a;
    private int numEle;
    private int numSwaps;
    private int numComparisons;
    //constructor
    public ArraySelectionSort(int size){
        a = new long[size];
        numEle = 0;
        numSwaps = 0;
        numComparisons = 0;
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
    public void swap(int i, int j){
        long temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        numSwaps++;
    }
    public void selectionSort(){
        for(int i = 0; i < numEle -1; i++){
            int minIndex = i;
            for(int j = i+1; j < numEle ; j++){
                numComparisons ++;
                if(a[j] < a[minIndex]){
                    minIndex=j;
                }
            }
            swap(minIndex, i);
        }
    }

    public int getNumSwaps(){
        return numSwaps;
    }

    public int getNumComparisons(){
        return numComparisons;
    }
}

class SelectionSortApp{
    public static void main(String[] args) {
        int size = 100;
        ArraySelectionSort arr = new ArraySelectionSort(size);

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
        arr.selectionSort();
        arr.display();

        System.out.println("The number of swaps: " + arr.getNumSwaps());
        System.out.println("The number of comparisons: " + arr.getNumComparisons());
    }
}
