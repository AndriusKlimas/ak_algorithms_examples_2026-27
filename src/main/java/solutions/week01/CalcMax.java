package solutions.week01;

public class CalcMax {
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
        int num1 = InputUtilities.getValidInteger("Please enter the first number: ", 15, 45);
        int num2 = InputUtilities.getValidInteger("Please enter the second number: ", 15, 45);
        int num3 = InputUtilities.getValidInteger("Please enter the final number: ", 10, 10);

        int max = findMax(num1, num2, num3);

        System.out.println("The highest number entered was: " + max);
    }
}
