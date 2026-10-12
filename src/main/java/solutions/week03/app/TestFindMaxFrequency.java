package solutions.week03.app;

import solutions.week03.utils.ArrayUtils;

import java.util.Random;

public class TestFindMaxFrequency {
    static void main(String[] args) {
        Random rg = new Random();
        int[] nums = new int[20];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = rg.nextInt(100);
        }

        System.out.println("---------------------------");
        ArrayUtils.displayArrayHorizontal(nums);
        System.out.println("---------------------------");

        int mostFreq = ArrayUtils.maxFrequency(nums);
        System.out.println("Most frequent (non-sorted): " + mostFreq);

        mostFreq = ArrayUtils.sortedMaxFrequency(nums);
        System.out.println("Most frequent (sorted): " + mostFreq);
    }
}
