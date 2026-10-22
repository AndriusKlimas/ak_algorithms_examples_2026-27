package homework.CA1;

import java.util.Arrays;

public class bruteVsTwo {


    //Q1
    /* brute force approach
     * This method checks if two arrays have the same content, regardless of order.
     * It does this by counting the occurrences of each element in both arrays.
     * The big O notation for this is n, Technically it is n^3 as it has 3 loops, 1 outer and 2 nested loops.
     * @param array1 the first array to compare
     * @param array2 the second array to compare
     * @return true if the arrays have the same content, false otherwise
     */
    public static boolean sameArrayContentBrute(int[] array1, int[] array2) {
        for (int i = 0; i < array1.length; i++) {

            int count1 = 0;
            int count2 = 0;


            for (int j = 0; j < array1.length; j++) {
                if (array1[j] == array1[i]) {
                    count1++;
                }

            }
            for (int k = 0; k < array2.length; k++) {
                if (array2[k] == array1[i]) {
                    count2++;
                }
            }
            if (count1 != count2) {
                return false;
            }
        }
        return true;


    }

    /* Two Pointer approach
    *   This method checks if two arrays have the same content, regardless of order.
    *   It does this by sorting both arrays and then comparing them using two pointers.
    *   The big O notation for this is n log n, due to the sorting step.
    * @param array1 the first array to compare
    * @param array2 the second array to compare
    * @return true if the arrays have the same content, false otherwise
     */
    public static boolean sameArrayContentTwo(int[] array1, int[] array2) {


        int[] array1Copy = Arrays.copyOf(array1, array1.length);
        int[] array2Copy = Arrays.copyOf(array2, array2.length);

        Arrays.sort(array1Copy);
        Arrays.sort(array2Copy);

        // Compare the sorted arrays using two pointer
        int i = 0;
        int j = 0;

        while (i < array1Copy.length && j < array2Copy.length) {
            if (array1Copy[i] == array2Copy[j]) {
                i++;
                j++;
            } else {
                return false;
            }

        }

        return true;
    }


    //Q2
    /*Brute force approach
     * this method checks if a string is a palindrome.
     * it does this by comparing each character with its corresponding character from the end of the string.
     * the big O notation for this is n, where n is the length of the string.
     * @param data the string to check
     * @return true if the string is a palindrome, false otherwise
     */
    public static boolean palindromeBrute(String data) {


        for (int i = 0; i < data.length(); i++) {
            String info1 = data.charAt(i) + "";

            for (int j = 0; j < data.length(); j++) {
                String info2 = data.charAt(data.length() - 1 - i) + "";

                if (!info1.equals(info2)) {
                    return false;
                }
            }
        }

        return true;

    }

    /*
     * Two Pointer approach
     * This method checks if a string is a palindrome.
     * It does this by using two pointers, one at the beginning and one at the end of the string,
     * and comparing the characters at these positions.
     * The big O notation for this is n, where n is the length of the string.
     * @param data the string to check
     * @return true if the string is a palindrome, false otherwise
     */
    public static boolean palindromeTwoPoint(String data) {
        //.charAt()
        int left = 0;
        int right = data.length() - 1;

        while (left < right) {
            if (data.charAt(left) == data.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    //Q3
    /* Brute force approach
     * This method finds the smallest contiguous subarray whose sum is greater than or equal to the target.
     * The big O notation for this is n^2, where n is the length of the array.
     * @param data the array of integers
     * @param target the target sum
     * @return an array containing the start and end indices of the smallest subarray, or [-1, -1] if no such subarray exists
     */
    public static int[] smallestContinueTargetBrute(int[] data, int target) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int count = 0;
        int smallCount = 0;
        int[] location = {0, 0};
        int[] storedLocation = {0, 0};
        for (int i = 0; i < data.length; i++) {
            sum = 0;
            start = i;
            count = 0;

            for (int j = i; j < data.length; j++) {
                sum += data[j];

                count++;

                if (sum <= target) {
                    end = j;
                    location[0] = start;
                    location[1] = end;
                    break;
                }
                if (j == data.length - 1) {
                    location[0] = -1;
                    location[1] = -1;
                }

            }
            //data may be over write with the second if statement, added extra validation
            if (smallCount > count && location[0] > 0) {
                smallCount = count;
                storedLocation = location;

            }

            i++;


        }
        if (storedLocation[0] == -1) {
            return new int[]{-1, -1};
        }
        return storedLocation;
    }

    /* Sliding Window
     * This method finds the smallest contiguous subarray whose sum is greater than or equal to the target.
     * The big O notation for this is n, where n is the length of the array.
     * @param data the array of integers
     * @param target the target sum
     * @return an array containing the start and end indices of the smallest subarray, or [-1, -1] if no such subarray exists
     */
    public static int[] smallestContinueTargetTwo(int[] data, int target) {
        int start = 0;
        int[] position = new int[]{-1, -1};
        int sortest = 99999;
        int windowSum = 0;

        for (int end = 0; end < data.length; end++) {
            windowSum += data[end];

            while (windowSum > target) {
                windowSum -= data[start];
                start++;
            }
            if (windowSum >= target) {

                if (end - start + 1 < sortest) {
                    sortest = end - start + 1;
                    position = new int[]{start, end};
                }
            }
        }
        return position;
    }


    //Q4
    /* Brute force approach
     * This method finds all the vowels in the input string and reverses their order.
     * The big O notation for this is n, where n is the length of the string. It is n^4 as it has 4 loops but none of them are nested
     * @param word the input string
     * @return the string with the vowels reversed
     */
    public static String ReverseVowelsBrute(String word) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};


        char[] unflipped = new char[word.length()];
        char[] flipped = new char[word.length()];
        char[] unflippedWord = new char[word.length()];
        char[] flippedWord = new char[word.length()];
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            unflippedWord[i] = word.charAt(i);
        }

        for (int i = 0; i < unflippedWord.length; i++) {
            if (word.charAt(i) == vowels[0] || word.charAt(i) == vowels[1] || word.charAt(i) == vowels[2] || word.charAt(i) == vowels[3] || word.charAt(i) == vowels[4] || word.charAt(i) == vowels[5] || word.charAt(i) == vowels[6] || word.charAt(i) == vowels[7] || word.charAt(i) == vowels[8] || word.charAt(i) == vowels[9]) {
                unflipped[count] = word.charAt(i);
                count++;
            }
        }

        for (int i = 0; i < count; i++) {
            flipped[i] = unflipped[count - 1 - i];
        }

        int next = 0;
        for (int i = 0; i < unflippedWord.length; i++) {
            if (word.charAt(i) == vowels[0] || word.charAt(i) == vowels[1] || word.charAt(i) == vowels[2] || word.charAt(i) == vowels[3] || word.charAt(i) == vowels[4]) {
                flippedWord[i] = flipped[next];
                next++;
            } else {
                flippedWord[i] = unflippedWord[i];
            }
        }

        return new String(flippedWord);

    }

    /*Two Pointer
     * This method finds all the vowels in the input string and reverses their order.
     * The big O notation for this is n, where n is the length of the string.
     * @param word the input string
     * @return the string with the vowels reversed
     */
    public static String ReverseVowelsTwo(String word) {

        char[] wordChar = new char[word.length()];
        String newWord = "";
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

        for (int i = 0; i < word.length(); i++) {
            wordChar[i] = word.charAt(i);
        }

        int left = 0;
        int right = wordChar.length - 1;

        while (left < right) {
            //need to check if left is on a vowel
            if(word.charAt(left) == vowels[0] || word.charAt(left) == vowels[1] || word.charAt(left) == vowels[2] || word.charAt(left) == vowels[3] || word.charAt(left) == vowels[4] || word.charAt(left) == vowels[5] || word.charAt(left) == vowels[6] || word.charAt(left) == vowels[7] || word.charAt(left) == vowels[8] || word.charAt(left) == vowels[9]) {
                //left is on a vowel, so we stop here
            } else {
                left++;
            }
            //need to check if right is on a vowel
            if(word.charAt(right) == vowels[0] || word.charAt(right) == vowels[1] || word.charAt(right) == vowels[2] || word.charAt(right) == vowels[3] || word.charAt(right) == vowels[4] || word.charAt(right) == vowels[5] || word.charAt(right) == vowels[6] || word.charAt(right) == vowels[7] || word.charAt(right) == vowels[8] || word.charAt(right) == vowels[9]) {
                //right is on a vowel, so we stop here
            } else {
                right--;
            }

            //now we swap left and right vowels
            char temp = wordChar[left];
            wordChar[left] = wordChar[right];
            wordChar[right] = temp;
            left++;
            right--;
        }
        return new String(wordChar);
    }
}


