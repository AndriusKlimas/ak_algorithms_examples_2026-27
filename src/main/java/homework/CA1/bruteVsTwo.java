package homework.CA1;

import java.util.Arrays;

public class bruteVsTwo {


    //Q1
    public static boolean sameArrayContentBrute(int[] array1, int[] array2){
        //loop through array1, get an int
        //loop through first array1, count how many times the array provided by i appears
        //loop through second array, count how many times it appears
        //if same then move onto next int in the array1 until it is done
        for (int i = 0; i < array1.length; i++) {

            int count1 = 0;
            int count2 = 0;


            for (int j = 0; j < array1.length; j++) {
                if (array1[j] == array1[i]){
                    count1++;
                }

            }
            for (int k = 0; k < array2.length; k++) {
                if (array2[k] == array1[i]) {
                    count2++;
                }
            }
            if (count1 != count2) {
                return false;
            }
        }
        return true;


    }

    public static boolean sameArrayContentTwo(int[] array1, int[] array2){
        //create a copy of the 2 arrays, so it does not alter the original
        //sort both of them
        //go through each one using two pointer
        //note sure if this can be done, but go through each one and compare, one pointer in one array, one pointer in the other
        // e.g. i=0, j=0, if i==j continue, if not then return false



        int[] array1Copy = Arrays.copyOf(array1, array1.length);
        int[] array2Copy = Arrays.copyOf(array2, array2.length);

        Arrays.sort(array1Copy);
        Arrays.sort(array2Copy);

        // Compare the sorted arrays using two pointer
        int i = 0;
        int j = 0;

        while(i<array1Copy.length && j<array2Copy.length){
            if(array1Copy[i] == array2Copy[j]){
                i++;
                j++;
            }

            else{
                return false;
            }

        }

        return true;
    }



    //Q2

    public static boolean palindromeBrute(String data){
        //use .charAt()
        //loop through the piece of sting, get the first letter
        //another loop to go to the last piece of string and get it
        //check if equal, if yes then continue
        // if not equal return false

        for (int i = 0; i < data.length(); i++) {
            String info1 = data.charAt(i)+"";

            for (int j = 0; j < data.length(); j++) {
                String info2 = data.charAt(data.length() - 1 - i)+"";

                if(!info1.equals(info2)){
                    return false;
                }
            }
        }

        return true;

    }

    public static boolean palindromeTwoPoint(String data) {
        //.charAt()
        int left = 0;
        int right = data.length() - 1;

        while (left < right) {
            if (data.charAt(left) == data.charAt(right)) {
                left++;
                right--;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
