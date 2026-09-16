package solutions.week01;

import java.util.Scanner;

public class SumAverage {
    static void main(){
        Scanner input = new Scanner(System.in);
        int total = 0;
        int count = 0;

        int value = 0;
        while(value != -1){
            System.out.println("Please enter a number (-1 to terminate):");
            value = input.nextInt();
            input.hasNextInt();

            if(value != -1){
                total += value;
                count++;
            }
        }

        double average = (double) total / count;
        System.out.println("Sum: " + total + ", average: " + average);
    }
}
