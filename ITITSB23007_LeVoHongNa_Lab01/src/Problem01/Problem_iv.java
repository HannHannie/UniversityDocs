package Problem01;

import java.util.*;
public class Problem_iv {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the number of cars: ");
        int cars = sc.nextInt();
        double sum = 0;
        for (int i = 0; i < cars; i++) {
            System.out.println("Enter the number of miles of car number " + (i+1) + ": ");
            double miles = sc.nextInt();

            System.out.println("Enter the gallons of fuel used of car number " + (i+1) + ": ");
            double gallons = sc.nextDouble();

            double mpg = miles / gallons;
            sum += mpg;

            System.out.println("Miles per gallon: " + mpg);
        }
        double average = sum / cars;
        System.out.println("Overall statistic: " + average);
        sc.close();
    }
}
