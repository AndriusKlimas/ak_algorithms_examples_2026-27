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

    /**
     * Safely take in a valid integer from the user between the specified upper and lower limits (inclusive).
     * This will repeatedly prompt the user using the supplied prompt,
     * and will detect and recover where non-integer values are entered.
     * Only values between the specified upper and lower limits will be accepted.
     * @param prompt The text to be displayed to the user
     * @param min The lowest value that can be accepted
     * @param max The highest value that can be accepted
     * @return The first valid integer entered by the user
     */
    public static int getValidInteger(String prompt, int min, int max){
        Scanner input = new Scanner(System.in);
        int value = 0;

        boolean validInt = false;
        while(!validInt) {
            System.out.println(prompt);
            if(input.hasNextInt()){
                value = input.nextInt();
                if(value >= min && value <= max) {
                    validInt = true;
                }else{
                    System.out.println("Value must be between " + min + " and " + max);
                }
            }else{
                System.out.println("Please enter an integer.");
                input.nextLine();
            }
        }

        return value;
    }

    /**
     * Identify the maximum value of 3 supplied parameters.
     * @param num1 The first number to be checked
     * @param num2 The second number to be checked
     * @param num3 The third number to be checked
     * @return The highest value supplied as a parameter
     */
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

        int num1 = getValidInteger("Please enter the first number: ", 15, 45);
        int num2 = getValidInteger("Please enter the second number: ", 15, 45);
        int num3 = getValidInteger("Please enter the final number: ", 10, 10);

        int max = findMax(num1, num2, num3);

        System.out.println("The highest number entered was: " + max);
    }
}
