package b_two_pointer.utils;

public class ArrayUtils {
    // Note: This assumes that the data is sorted before carrying out the action
    // To make it work on any data set (sorted and unsorted), two extra steps are needed:
    // a) Duplicate the dataset, to ensure the action is "pure" (does not have side effects)
    // b) Sort the duplicate and carry out action on that version

    // The result of the pre-conditioned version of the action is not guaranteed
    // to be the same as a brute force approach on unsorted data
    public static int maxFrequency(int[] data) {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("Cannot find the max value in an empty/null array");
        }

        int maxCount = 1;
        int mostFreq = data[0];

        int count = 0;
        int runStart = 0;
        int runEnd = 0;

        for (int i = 0; i < data.length - 1; i++) {
            runEnd++;

            if (data[runStart] != data[runEnd]) {
                count = runEnd - runStart;

                if (count > maxCount) {
                    maxCount = count;
                    mostFreq = data[runStart];
                }

                runStart = runEnd;
            }
        }

        count = data.length - runStart;
        if (count > maxCount) {
            maxCount = count;
            mostFreq = data[runStart];
        }
        return mostFreq;
    }

    // Example of closing window pattern
    public static int[] twoSum(int[] data, int target) {
        if (data == null || data.length < 2) {
            throw new IllegalArgumentException("Cannot find a pair of values summing to "
                    + target + " in a null array or an array with less than 2 elements");
        }

        int left = 0;
        int right = data.length - 1;

        while (left < right) {
            int sum = data[left] + data[right];
            // If current pair adds up to target, return these positions
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                // Sum is too small, we need a bigger left value
                left++;
            } else {
                // Sum is too big, we need a smaller right value
                right--;
            }
        }

        // No pair could be found that add up to the target - return invalid indices
        return new int[]{-1, -1};
    }

    // find the subarray of length k with the highest sum
    public static int maxSubarraySum(int[] data, int k) {
        int maxSum = 0;

        for (int i = 0; i <= data.length - k; i++) {
            int currSum = 0;

            // calculate sum of current subarray
            for (int j = 0; j < k; j++) {
                currSum += data[i + j];
            }

            // update maximum sum if the current one is bigger
            if(currSum > maxSum){
                maxSum = currSum;
            }
        }

        return maxSum;
    }

    public static int slidingWindowMaxSubarraySum(int[] data, int k) {
        if (data.length < k) {
            throw new IllegalArgumentException("Insufficient data in array for required "
                    + " subarray size of " + k + " (array size is smaller than " + k + ")");
        }

        // Calculate the sum of the first window
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += data[i];
        }

        int maxSum = windowSum;

        // slide the window, updating
        for (int right = k; right < data.length; right++) {
            windowSum += data[right] - data[right - k];

            // Update maxSum where the current window is the max
            if(windowSum > maxSum){
                maxSum = windowSum;
            }
        }

        return maxSum;
    }

    public static int deduplicate(int [] data){
        int currentLength = data.length;
        int i = 0;

        // Loop through the real data of the array (ignore the "trailing" data)
        while (i < currentLength - 1) {
            // If a duplicate is found next to the current element
            if (data[i] == data[i + 1]) {
                // Shift everything after the duplicate one spot to the left
                System.arraycopy(data, i + 1, data, i, currentLength - (i + 1));
                // Reduce the tracking length since we deleted an element
                currentLength--;
                // We now have a new, unchecked value in the current position
                // Therefore we CANNOT increase i as we need to check the new value
            } else {
                // Current element is unique, move forward
                i++;
            }
        }

        // Now we have deduplicated the data, we need to clean up the "trailing"/"ghost" data
        // Loop from end of real data to end of actual array
        for (int j = currentLength; j < data.length; j++) {
            // Wipe current slot by filling it with 0
            data[j] = 0;
        }

        // Return size of real data remaining within the array
        return currentLength;
    }

    public static int efficientDeduplicate(int[] data) {
        int write = 1;

        for (int read = 1; read < data.length; read++) {
            if (data[read] != data[write - 1]) {
                data[write] = data[read];
                write++;
            }
        }

        for (int i = write; i < data.length; i++) {
            data[i] = 0;
        }

        return write;
    }

}
