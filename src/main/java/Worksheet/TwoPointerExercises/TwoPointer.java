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

    public static int waterAmount(int[] data){
        int left = 0;
        int right = data.length -1;
        int base = data.length;
        int maxWater = 0;
        int water = 0;

        while(left<right){

            if(data[left] < data[right]){
                water = data[right] * base;
                left++;
                base--;
            } else {
                water = data[left] * base;
                right--;
                base--;
            }
            if(water > maxWater) {
                maxWater = water;
            }
        }
        return maxWater;
    }

}
