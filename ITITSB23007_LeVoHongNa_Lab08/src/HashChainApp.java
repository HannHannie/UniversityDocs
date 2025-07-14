import java.util.LinkedList;
import java.util.Scanner;

class HashChain {
    private LinkedList<Integer>[] hashArray;
    private int size;

    //constructor
    public HashChain(int size){
        this.size = size;
        hashArray = new LinkedList[size];
        for (int i = 0; i < size; i++){
            //create LinkedList for each index
            hashArray[i] = new LinkedList<>();
        }
    }

    public int hashFunc(int key){
        return key % size;
    }

    public int insert(int key){
        int index = hashFunc(key);
        hashArray[index].add(key);
        return hashArray[index].size();
    }

    public int find(int key){
        int index = hashFunc(key);
        int probeLength = 0;
        for (int item : hashArray[index]){
            probeLength++;
            if (item == key) return probeLength;
        }
        return probeLength;
    }

    public void display(){
        for (int i = 0; i < size; i++){
            System.out.print(i + ": ");
            for (int item: hashArray[i]){
                System.out.print(item + " -> ");
            }
            System.out.println();
        }
    }

    //getter & setter
    public LinkedList<Integer>[] getHashArray() {
        return hashArray;
    }

    public void setHashArray(LinkedList<Integer>[] hashArray) {
        this.hashArray = hashArray;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

public class HashChainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input array size: ");
        int arrSize = sc.nextInt();

        System.out.println("Input the number of key: ");
        int numOfKeys = sc.nextInt();
        int[] keySequence = new int[numOfKeys];
        for (int i = 0; i < numOfKeys; i++)
            keySequence[i] = sc.nextInt();

        HashChain hc = new HashChain(arrSize);

        System.out.println("Inserting keys: ");
        int probeLength = 0;
        for (int key : keySequence){
            int EachProbeLength = hc.insert(key);
            probeLength += EachProbeLength;
            System.out.println("Insert " + key + ", probe length = " + EachProbeLength);
        }

        System.out.println("\nThe hash table is: ");
        hc.display();

        System.out.println("\nFinding key: ");
        for (int key : keySequence){
            int EachProbeLength = hc.find(key);
            System.out.println("Found " + key + " at the cell index " + hc.hashFunc(key) +
                                ", and probe length = " + EachProbeLength);
        }
        double avgFillingProbe = (double) probeLength / keySequence.length;
        System.out.println("\nThe average probe length is: " + avgFillingProbe);
        sc.close();
    }
}
