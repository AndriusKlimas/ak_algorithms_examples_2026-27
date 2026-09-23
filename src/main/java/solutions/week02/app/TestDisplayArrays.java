package solutions.week02.app;

import solutions.week02.utils.ArrayUtils;

public class TestDisplayArrays {
    static void main(String[] args) {
        int[] nums = new int[10];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = i * 10;
        }

        ArrayUtils.displayArray(nums);
    }
}
