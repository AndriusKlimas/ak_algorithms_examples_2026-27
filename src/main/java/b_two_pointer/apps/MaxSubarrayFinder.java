package b_two_pointer.apps;

import b_two_pointer.utils.ArrayUtils;

import java.util.Arrays;

public class MaxSubarrayFinder {
    static void main(String[] args) {
        int[] data = {1, 4, 2, 10, 25, 6, 1, 7, 18};

        int k = 4;
        int maxSum = ArrayUtils.slidingWindowMaxSubarraySum(data, k);
        System.out.println("The max sum for any subsection of length " + k + " in the array " + Arrays.toString(data) + " = " + maxSum);

        int[] data2 = {90, 1, 45, 67, 88};

        k = 1;
        maxSum = ArrayUtils.slidingWindowMaxSubarraySum(data2, k);
        System.out.println("The max sum for any subsection of length " + k + " in the array " + Arrays.toString(data2) + " = " + maxSum);

        int[] data3 = {100, 100, 200, 300};

        k = 2;
        maxSum = ArrayUtils.slidingWindowMaxSubarraySum(data3, k);
        System.out.println("The max sum for any subsection of length " + k + " in the array " + Arrays.toString(data3) + " = " + maxSum);


        int[] data4 = {1, 3, 4, 6, 8};

        k = 3;
        maxSum = ArrayUtils.slidingWindowMaxSubarraySum(data4, k);
        System.out.println("The max sum for any subsection of length " + k + " in the array " + Arrays.toString(data4) + " = " + maxSum);
    }
}
