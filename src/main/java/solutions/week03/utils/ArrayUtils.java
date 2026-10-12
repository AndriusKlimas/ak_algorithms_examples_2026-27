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

    public static void displayArrayHorizontal(int [] data){
        for (int i = 0; i < data.length-1; i++) {
            System.out.print(data[i] + ", ");
        }
        System.out.println(data[data.length-1]);
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

    public static int count(int [] data, int target){
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            if(data[i] == target){
                count++;
            }
        }

        return count;
    }

    public static int maxFrequency(int [] data){
        int maxCount = 1;
        int mostFreq = data[0];

        for (int value : data) {
            int count = count(data, value);

            if(count > maxCount){
                maxCount = count;
                mostFreq = value;
            }
        }

        return mostFreq;
    }

    public static int sortedMaxFrequency(int [] data){
        if(data == null || data.length == 0){
            throw new IllegalArgumentException("Cannot find the max value in an empty/null array");
        }

        // Precondition the data to ensure it's sorted
        // Create a temp copy to do this so we don't cause a change to original data
        // This ensures that the algorithm remains a "pure" function
        int [] temp = Arrays.copyOf(data, data.length);
        Arrays.sort(temp);

        int maxCount = 1;
        int mostFreq = temp[0];

        int count = 0;
        int runStart = 0;
        int runEnd = 0;

        for(int i = 0; i < temp.length-1; i++){
            runEnd++;

            if(temp[runStart] != temp[runEnd]){
                count = runEnd - runStart;

                if(count > maxCount){
                    maxCount = count;
                    mostFreq = temp[runStart];
                }

                runStart = runEnd;
            }
        }

        count = temp.length - runStart;
        if(count > maxCount){
            maxCount = count;
            mostFreq = temp[runStart];
        }
        return mostFreq;
    }
}
