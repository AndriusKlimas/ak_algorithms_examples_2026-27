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
            windowSum += data[right] - data[right -k];

            if(windowSum>maxSum)
                maxSum = windowSum;
        }
        return maxSum;
    }
}
