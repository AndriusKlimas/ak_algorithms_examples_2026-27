package In_class_excercises;

import java.util.Scanner;

public class CalcMax {
    public static int getValidInteger(String prompt){
        System.out.println(prompt);
        Scanner input = new Scanner(System.in);
        int num =0;

        while(!input.hasNextInt()){
            System.out.println("Error.. Error");
            input.next();
            System.out.println("Please enter the number again");

        }

        num = input.nextInt();
        System.out.println("You have entered "+ num);
        return num;
    }
}
