package in_class.week2;

public class ArrayUtils {

    /*
    Takes in an array of Int and returns the order they are stored in

    Parses int[] array - holds the array of int to be printed out
     */
    public static void displayArrayNums(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Current number is " + array[i] + ". Position is " + i);
        }
    }

    /*
    Takes in an array of strings and returns the order they are stored in

    Parses String[] array - holds the array of strings to be printed out
     */
    public static void displayArrayString(String[] array){
        for(int i=0;i<array.length;i++){
            System.out.println("Current wordis "+array[i]+". Position is "+i);
        }
    }

    /*
    Takes in array of Int, prints out the average of all the number

    Parses int[] array - an array of all in that needs to be averaged
     */

    public static void averageArrayInt(int[] array){
        int current = 0;
        int count = 0;
        System.out.println("Test1");
        for (int i=0;i<array.length;i++){
            current = array[i] + current;
            count++;
            System.out.println(count);
        }
        if (count>0){
            int average = current/count;
            System.out.println("Average is "+ average);
            }
    }
}
