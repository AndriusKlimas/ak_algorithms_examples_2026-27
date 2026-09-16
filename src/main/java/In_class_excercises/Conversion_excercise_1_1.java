package In_class_excercises;

import java.util.Scanner;

public class Conversion_excercise_1_1 {
    static void main(){
        Scanner input = new Scanner(System.in);

        int bingo = -1;
        int amount = 0;
        int avg = 0;
        int sum = 0;
        int guess = 0;

        while(guess!=bingo){
            System.out.println("Plesae enter a number");
            guess = input.nextInt();


            if(guess == bingo){
                System.out.println("The sum is "+ sum);
                avg = sum/amount;
                System.out.println("Please see the average "+ avg);
            }else{
                System.out.println("Nope");
                sum = guess + sum;
                amount += 1;
            }
        }
    }
}
