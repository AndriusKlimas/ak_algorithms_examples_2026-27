package solutions.week02.utils;

public class ArrayUtils {
    /**
     * Displays the contents of a supplied int array on the console.
     * Data is displayed vertically with index included.
     * @param nums the array to be displayed
     */
    public static void displayArray(int [] nums){
        for (int i = 0; i < nums.length; i++) {
            System.out.println(i + ": " + nums[i]);
        }
    }

    /**
     * Displays the contents of a supplied String array on the console.
     * Data is displayed vertically with index included.
     * @param nums the array to be displayed
     */
    public static void displayArray(String [] nums){
        for (int i = 0; i < nums.length; i++) {
            System.out.println(i + ": " + nums[i]);
        }
    }
}
