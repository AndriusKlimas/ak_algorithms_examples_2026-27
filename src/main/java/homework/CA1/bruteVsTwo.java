package homework.CA1;

public class bruteVsTwo {


    //Q1
    public static boolean sameArrayContentBrute(int[] array1, int[] array2){
        //loop through array1, get an int
        //loop through first array1, count how many times the array provided by i appears
        //loop through second array, count how many times it appears
        //if same then move onto next int in the array1 until it is done
        for (int i = 0; i < array1.length; i++) {


    }

    public static boolean sameArrayContentTwo{

    }



    //Q2
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
