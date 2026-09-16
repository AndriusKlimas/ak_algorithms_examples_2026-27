package solutions.week01;

import java.util.Scanner;

public class InputUtilities {
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
}
