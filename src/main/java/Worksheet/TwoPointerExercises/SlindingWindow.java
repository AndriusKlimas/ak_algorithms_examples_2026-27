package Worksheet.TwoPointerExercises;

public class SlindingWindow {

    //example Only
    public static int slidingWindowMaxSubArraySum(int[] data, int k){

        // calculating the sum of the first window
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += data[i];
        }

        int maxSum = windowSum;

        //sliding the window
        for (int right = k; right < data.length; right++) {
            windowSum -=data[right -k];
            windowSum += data[right];

            if(windowSum>maxSum)
                maxSum = windowSum;
        }
        return maxSum;
    }

    // only returns the first value, does not go through them all
    public static int[] DynamicSlidingWindowSubArray(int[] data, int target){
        int start = 0;
        int windowSum  = 0;
        for(int end = 0; end < data.length; end++) {
            windowSum += data[end];
            while (windowSum > target) {
                windowSum -= data[start];
                start++;
            }
            if(windowSum == target){
                return new int[]{start, end};
            }
        }
        return new int[]{-1, -1};
    }

    //loops though all of the possibilites and returns what was specified, e.g. least amount of numbers
    public static int[] DynamicSlidingWindowSubArraySpecific(int[] data, int target) {
}
