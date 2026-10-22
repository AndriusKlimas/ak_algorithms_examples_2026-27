package homework.CA1;

import java.util.Arrays;

public class bruteVsTwo {


    //Q1
    public static boolean sameArrayContentBrute(int[] array1, int[] array2) {
        //loop through array1, get an int
        //loop through first array1, count how many times the array provided by i appears
        //loop through second array, count how many times it appears
        //if same then move onto next int in the array1 until it is done
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

    public static boolean sameArrayContentTwo(int[] array1, int[] array2) {
        //create a copy of the 2 arrays, so it does not alter the original
        //sort both of them
        //go through each one using two pointer
        //note sure if this can be done, but go through each one and compare, one pointer in one array, one pointer in the other
        // e.g. i=0, j=0, if i==j continue, if not then return false


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

    public static boolean palindromeBrute(String data) {
        //use .charAt()
        //loop through the piece of sting, get the first letter
        //another loop to go to the last piece of string and get it
        //check if equal, if yes then continue
        // if not equal return false

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
    public static int[] smallestContinueTargetBrute(int[] data, int target) {
        //for loot to get the start position
        //second for loop to go through the array
        //if it finds or exceeds the target stop the second loop
        //choose a new start position e.g. i+1
        // store the current shortest one and the positions
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
}


