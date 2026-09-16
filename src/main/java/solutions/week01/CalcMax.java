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
}
