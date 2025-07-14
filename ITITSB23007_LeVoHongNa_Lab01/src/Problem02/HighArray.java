package Problem02;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class HighArray {
    private int[] arr;
    private int nElems;
    private int comparisons;

    public HighArray(int maxSize) {
        arr = new int[maxSize];
        nElems = 0;
        comparisons = 0;
    }

    public void insert(int value) {
        if (nElems < arr.length) {
            arr[nElems++] = value;
        }
    }

    public boolean find(int key) {
        comparisons = 0;
        for (int i = 0; i < nElems; i++) {
            comparisons++;
            if (arr[i] == key) {
                return true;
            }
        }
        return false;
    }

    public int getMax() {
        if (nElems == 0) return -1;
        int max = arr[0];
        for (int i = 1; i < nElems; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public void noDups() {
        Arrays.sort(arr, 0, nElems);
        int uniqueCount = 1;
        for (int i = 1; i < nElems; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[uniqueCount++] = arr[i];
            }
        }
        nElems = uniqueCount;
    }

    public int getComparisons() {
        return comparisons;
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        HighArray arr = new HighArray(1000);
        for (int i = 0; i < 100; i++) {
            arr.insert(rand.nextInt(1000));
        }

        arr.display();
        System.out.println("Max value: " + arr.getMax());
        arr.noDups();
        System.out.println("Array after removing duplicates:");
        arr.display();

        int keyToFind = rand.nextInt(1000);
        System.out.println("Finding: " + keyToFind);
        arr.find(keyToFind);
        System.out.println("Comparisons made: " + arr.getComparisons());

        int totalComparisons = 0;
        for (int trial = 0; trial < 100; trial++) {
            int randomKey = rand.nextInt(1000);
            arr.find(randomKey);
            totalComparisons += arr.getComparisons();
        }
        System.out.println("Average comparisons over 100 trials: " + (double) totalComparisons / 100);

        scanner.close();
    }
}
