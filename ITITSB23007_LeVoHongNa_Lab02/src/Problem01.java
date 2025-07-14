class ArrayBubbleSort {
    private long[] a;
    private int numEle;
    private int numSwaps;
    private int numComparisons;
    //constructor
    public ArrayBubbleSort(int size) {
        //initial value
        a = new long[size];
        numEle = 0;
        numSwaps = 0;
        numComparisons = 0;
    }

    public void insert(long value) {
        a[numEle] = value;
        numEle++;
    }

    public void display() {
        for (int i = 0; i < numEle; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public void swap(int i, int j) {
        long temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        numSwaps++;
    }

    public void bubbleSort() {
        for(int j= numEle -1; j>0; j--){
            for(int i=0; i< numEle - 1; i++){
                numComparisons++;
                if(a[i] >= a[i+1]){
                    swap(i, i+1);

                }
            }
        }
    }

    public int getNumSwaps(){
        return numSwaps;
    }

    public int getNumComparisons(){
        return numComparisons;
    }
}




class BubbleSortApp {
    public static void main(String[] args) {
        int size = 100;
        ArrayBubbleSort arr = new ArrayBubbleSort(size);

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
        arr.bubbleSort();
        arr.display();

        System.out.println("The number of swaps: " + arr.getNumSwaps());
        System.out.println("The number of comparisons: " + arr.getNumComparisons());

    }
}