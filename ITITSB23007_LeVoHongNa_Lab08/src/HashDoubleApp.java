/*HashDoubleApp
• Display the key sequence for the initial filling of the table
• Display the hash value, the step, and the probe sequence for insert and find.
• Display the probe length for each find and insert
• Display the average probe length for the initial filling of the table
• Investigate how the load factor affects the average probe length
• Demonstrate the importance of using a prime number for the table size*/

import java.util.*;
class HashDouble {
    private int[] hashArr;
    private int arrSize;
    private int secondHash;

    //constructor
    public HashDouble(int arrSize){
        this.arrSize = arrSize;
        hashArr = new int[arrSize];
        secondHash = getPrimeLessThan(arrSize);
        for (int i = 0; i < arrSize; i++)
            hashArr[i] = -1; //mark empty
    }

    //find the greatest prime that is smaller than array size
    private int getPrimeLessThan(int n){
        for (int i = n - 1; i >= 2; i--)
            if(isPrime(i)) return i;
        return 2;
    }

    private boolean isPrime(int n){
        for (int i = 2; i <= Math.sqrt(n); i++){
            if (n % i == 0) return false;
        }
        return true;
    }

    private int hashFunc1(int key){
        return key % arrSize;
    }

    private int hashFunc2(int key){
        return secondHash - (key % secondHash);
    }

    public int insert(int key){
        int index = hashFunc1(key);
        int stepSize = hashFunc2(key);
        int probeCount = 1; //have done the first fill

        while(hashArr[index] != -1){
            //index = (hash1 + j * hash2) % arrSize
            index = (index + stepSize) % arrSize; //avoid out of bound
            probeCount++;
        }
        hashArr[index] = key;
        return probeCount; //return to probeCount to cal avg probe length later
    }

    public int find(int key){
        int index =  hashFunc1(key);
        int stepSize = hashFunc2(key);
        int probeCount = 1;

        while(hashArr[index] != -1){
            if (hashArr[index] == key)
                return probeCount;
            index = (index + stepSize) % arrSize;
            probeCount++;
        }
        return -probeCount;
    }

    //getter & setter
    public int[] getHashArr() {
        return hashArr;
    }

    public void setHashArr(int[] hashArr) {
        this.hashArr = hashArr;
    }

    public int getSecondHash() {
        return secondHash;
    }

    public void setSecondHash(int secondHash) {
        this.secondHash = secondHash;
    }

    public int getArrSize() {
        return arrSize;
    }

    public void setArrSize(int arrSize) {
        this.arrSize = arrSize;
    }
}

public class HashDoubleApp {
    public static void main(String[] args) {
        //To show the importance of using a prime number for the table size
        int[] tableSizes = {10, 11};
        double[] loadFactor = {0.5, 0.7, 0.3};

        for (int size : tableSizes){
            System.out.println("Table size is: " + size);
            System.out.println();
            for (double factor : loadFactor){
                System.out.println("The load factor is: " + factor);
                HashDouble hd = new HashDouble(size);

                //Random the key sequence
                Set<Integer> keySequence = new HashSet<>();
                Random rd = new Random();
                int numOfEle = (int)(factor * size);
                while(keySequence.size() < numOfEle){
                    keySequence.add(rd.nextInt(100));
                }
                System.out.println("Key sequence is: " + keySequence);

                //Insert
                int insertProbe = 0;
                for (int key : keySequence){
                    int probe = hd.insert(key);
                    insertProbe += probe;
                }
                double InsertAvg = (double)insertProbe / numOfEle;
                System.out.println("Average insert probes = " + InsertAvg);

                //Find
                int findProbe = 0;
                for (int key : keySequence){
                    int probe = hd.find(key);
                    findProbe += probe;
                }
                double FindAvg = (double)findProbe / numOfEle;
                System.out.println("Average find probes = " + FindAvg);
                System.out.println();
            }
        }
    }
}
