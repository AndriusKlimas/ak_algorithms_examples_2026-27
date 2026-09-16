package solutions.week01;

import java.util.Scanner;

public class CalcMax {
    public static int getValidInteger(String prompt){
        Scanner input = new Scanner(System.in);
        int value = 0;

        boolean validInt = false;
        while(!validInt) {
            System.out.println(prompt);
            if(input.hasNextInt()){
                value = input.nextInt();
                validInt = true;
            }else{
                System.out.println("Please enter an integer.");
                input.nextLine();
            }
        }

        return value;
    }
}
