package Worksheet.TwoPointerExercises;

import org.w3c.dom.css.Counter;

import java.util.HashMap;
import java.util.Map;

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

    //loops though all of the possibilites and returns what was specified, e.g. the least amount of numbers
    public static int DynamicSlidingWindowSubArraySpecific(int[] data, int target) {
        int start = 0;
        int[] position = new int[]{0,0};
        int longest = -1;
        int windowSum=0;
        for (int end = 0; end < data.length; end++) {
            windowSum += data[end];
            while (windowSum > target) {
                windowSum -= data[start];
                start++;
            }
            if(windowSum==target) {
                // Update the longest subarray if the current one is longer
                if (end - start + 1 > longest) {
                    longest = end - start + 1;
                    position = new int[]{start,end};
                }
            }
        }
        return longest;
    }
//    public static String DynamicSlidingWindowStringSpecific(String data){
//        int start = 0;
//        int longestStart = 0;
//        int longestLength = 0;
//        Map<Character, Integer> lastSeen = new HashMap<>();
//
//        for (int end = 0; end < data.length(); end++) {
//            char currentChar = data.charAt(end);
//
//            if (lastSeen.containsKey(currentChar)
//                    && lastSeen.get(currentChar) >= start) {
//                start = lastSeen.get(currentChar) + 1;
//            }
//
//            lastSeen.put(currentChar, end);
//
//            int currentLength = end - start + 1;
//            if (currentLength > longestLength) {
//                longestStart = start;
//                longestLength = currentLength;
//            }
//        }
//
//        return data.substring(longestStart, longestStart + longestLength);
//    }

}
