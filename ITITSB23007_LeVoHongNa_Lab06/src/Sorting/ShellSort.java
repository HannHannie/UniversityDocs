package Sorting;

import java.util.*;
public class ShellSort{
    private long[] arr;
    private int nOfEle;
    private int cswap;
    private int comparison;
    private int copy;

    //constructor
    public ShellSort(int size){
        arr = new long[size];
        nOfEle = 0;
        cswap = 0;
        comparison = 0;
        copy = 0;
    }

    public void insert(long data){
        arr[nOfEle] = data;
        nOfEle ++;
    }

    public int size(){
        return nOfEle;
    }

    public void display(){
        System.out.print("[ ");
        for (int i = 0; i < nOfEle; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    public void swap(int a, int b){
        long temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        cswap++;
        copy += 3;
    }

    public void shellSort(){
        int in, out;
        long temp;
        int h = 1;
        while (h <= nOfEle / 3){ //tìm cái gap lớn nhất
            h = h * 3 + 1;
        }
        //main part of shell sort
        while (h > 0){
            //insertion sort
            for(out = h; out < nOfEle; out ++){
                temp = arr[out];
                copy ++;
                in = out;
                while(in > h - 1 && arr[in - h] >= temp){
                    comparison++;
                    arr[in] = arr[in - h];
                    copy ++;
                    in -= h;
                }
                arr[in] = temp;
                copy ++;
            }
            h = (h - 1) / 3;
        }
    }

    public int nOfSwap(){
        return cswap;
    }

    public int nOfComparison(){
        return comparison;
    }

    public int nOfCopies(){
        return copy;
    }
}