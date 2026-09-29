package in_class.ArrayUtilis;

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

    /* Finds hte biggst number in array

    Parses int[] array - an array of numbers to find max
     */
    public static void findMaxInt(int[] array){
        int current = array[0];
    //take first value, then compare to others, if it chnages then continue until the end
        for(int i=0;i<array.length;i++){
            if(array[i]>current){
                current = array[i];
                System.out.println("New biggest "+ current);
            }
        }
        System.out.println("Biggest number is "+current);
    }

        /* finds the work with the last letter in alphabet, swap > to < for vise versa


        Parses String[] array - holds the array of strings
         */
    public static void findMaxString(String[] array){
        String current = array[0];
        for(int i=0;i<array.length;i++){
            String newerOne = array[i];
            System.out.println(newerOne);

            if (newerOne.compareTo(current) > 0){
                current = newerOne;
            }
        }
        System.out.println(current);
    }

    /* Find the lowest int in an array

    Parses int[] array - an array of numbers to find min
     */
    public static void findMinInt(int[] array){
        int current = array[0];
        for(int i=0;i<array.length;i++){
            if(array[i]<current){
                current = array[i];
                System.out.println("New Lowest = "+ current);
            }
        }
        System.out.println("Lowest number is = "+current);
    }

    /* finds the work with the last letter in alphabet, swap > to < for vise versa


        Parses String[] array - holds the array of strings
         */
    public static void findMinString(String[] array){
        String current = array[0];
        for(int i=0;i<array.length;i++){
            String newerOne = array[i];
            System.out.println(newerOne);

            if (newerOne.compareTo(current) < 0){
                current = newerOne;
            }
        }
        System.out.println(current);
    }

}
