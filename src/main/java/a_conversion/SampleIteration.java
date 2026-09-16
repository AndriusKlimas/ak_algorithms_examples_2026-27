package a_conversion;

import java.util.Scanner;

public class SampleIteration {
    static void main(){
        Scanner input = new Scanner(System.in);
        int target = 25;
        int guess = -1;
        while(guess != target){
            System.out.println("Guess the number! (Between 1 and 30)");
            guess = input.nextInt();

            if(guess == target){
                System.out.println("Well done, you got it right!");
            }else{
                System.out.println("Try again");
            }
        }
        System.out.println("You're free! Hope you had fun");
    }
}
