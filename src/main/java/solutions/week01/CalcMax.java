package solutions.week01;

import java.util.Scanner;

public class CalcMax {
    /**
     * Safely take in an integer from the user.
     * This will repeatedly prompt the user using the supplied prompt,
     * and will detect and recover where non-integer values are entered
     * @param prompt The text to be displayed to the user
     * @return The first valid (numeric) integer value entered by the user
     */
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

    public static int findMax(int num1, int num2, int num3){
        int max = num1;

        if(num2 > max){
            max = num2;
        }

        if(num3 > max){
            max = num3;
        }

        // Alternative approach:
        // return Math.max(num1, Math.max(num2, num3));

        return max;
    }

    static void main() {
        Scanner input = new Scanner(System.in);

        int num1 = getValidInteger("Please enter the first number: ");
        int num2 = getValidInteger("Please enter the second number: ");
        int num3 = getValidInteger("Please enter the final number: ");

        int max = findMax(num1, num2, num3);

        System.out.println("The highest number entered was: " + max);
    }
}
