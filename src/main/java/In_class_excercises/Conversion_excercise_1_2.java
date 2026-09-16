package In_class_excercises;

import java.util.Scanner;

public class Conversion_excercise_1_2 {
    static void main(){
        System.out.println("Please enter the first number");
        Scanner input = new Scanner(System.in);
        int num1 = input.nextInt();

        int num2 = CalcMax.getValidInteger("Please enter second number");


        int min = 0;
        int man = 0;
        int sum = 0;

        min = Math.min(num1,num2);
        man = Math.max(num1,num2); // CalcMax.getMax
        sum = min;

        while(min!=man){
            min = min +1;
            sum = min +sum;


            if(min==man){
                System.out.println("The sum is "+ sum);
            }else{
                System.out.println("... ...");
            }
        }

    }
}
