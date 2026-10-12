package solutions.week01;

import java.util.Scanner;

public class SumBetween {
    static void main() {
        Scanner input = new Scanner(System.in);

        System.out.println("Let's add all numbers within a range.");
        System.out.println("Enter your first number:");
        int num1 = input.nextInt();

        System.out.println("Enter your second number:");
        int num2 = input.nextInt();

        if(num1 > num2){
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }

        int total = 0;
        for(int i = num1; i <= num2; i++){
            total = total + i;
        }

        // Could also have done this by getting the max value with Math.max(num1, num2)
        // and getting the min value with Math.min(num1, num2)

        System.out.println("Sum of all numbers between " + num1 + " and " + num2 + " = " + total);
    }
}
