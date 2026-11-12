package c_searching_and_sorting.apps;

import c_searching_and_sorting.utils.ArrayUtils;

import java.util.Arrays;
import java.util.Random;

public class TestSorting {
    private static final Random randomGenerator = new Random();
    static void main(String[] args) {
        int upperBound = 101;
        int [] data = generateRandomArray(upperBound);
        int [] duplicates = Arrays.copyOf(data, data.length);

        // Sort original data with bubble sort implementation
        ArrayUtils.selectionSort(data);
        // Sort duplicate data with built-in sort implementation
        Arrays.sort(duplicates);

        // Display data and compare
        System.out.println("Selection sort result: \t" + Arrays.toString(data));
        System.out.println("Built-in sort result: \t" + Arrays.toString(duplicates));

        System.out.println("Arrays are equal: " + Arrays.equals(data, duplicates));
    }

    public static int[] generateRandomArray(int maxValue){
        int [] data = new int[20];
        for (int i = 0; i < data.length; i++) {
            data[i] = randomGenerator.nextInt(maxValue);
        }

        return data;
    }

    public static String[] generateRandomStringArray(int size){
        String [] data = new String[size];

        for (int i = 0; i < data.length; i++) {
            data[i] = "Text -> " + randomGenerator.nextInt(size);
        }

        return data;
    }
}
