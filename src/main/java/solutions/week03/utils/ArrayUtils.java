package solutions.week03.utils;

import java.util.Arrays;

public class ArrayUtils {
    public static void displayArray(int [] data){
        for (int i = 0; i < data.length; i++) {
            System.out.println(i + ") " + data[i]);
        }
    }

    public static void displayArray(String [] data){
        for (int i = 0; i < data.length; i++) {
            System.out.println(i + ") " + data[i]);
        }
    }

    public static int indexOf(int [] data, int target){
        int [] nums = Arrays.copyOf(data, data.length);

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target){
                return i;
            }else if(nums[i] > target){
                return -1;
            }
        }
        return -1;
    }
}
