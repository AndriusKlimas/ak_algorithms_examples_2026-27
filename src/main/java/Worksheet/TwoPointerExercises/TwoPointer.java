package Worksheet.TwoPointerExercises;

public class TwoPointer {

    public static int[] twosum(int[] data, int target) {

        int left = 0;
        int right = data.length -1;

        while(left<right){
            int sum = data[left] + data[right];

            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    public static String palindrome(String data) {
        //.charAt()
        int left = 0;
        int right = data.length() - 1;

        while (left < right) {
            if (data.charAt(left) == data.charAt(right)) {
                left++;
                right--;
            }
            else {
                return data;
            }
        }
        return "It is not a palindrome";
    }

}
