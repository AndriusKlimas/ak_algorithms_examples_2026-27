package c_searching_and_sorting.apps;

import c_searching_and_sorting.utils.ArrayUtils;

import java.util.Arrays;
import java.util.Random;

public class TestStringSorting {
    private static final Random randomGenerator = new Random();
    static void main(String[] args) {
        int size = 10;
        String [] data = generateRandomStringArray(size);
        String [] benchmarkData = Arrays.copyOf(data, data.length);

        System.out.println("Original data: " + Arrays.toString(data));

        // Sort original data with bubble sort implementation using lambda comparator
        ArrayUtils.bubblesort(data,
                (String s1, String s2) ->  s1.compareTo(s2) * -1
            );
        // Sort duplicate data with built-in sort implementation using lambda comparator
        Arrays.sort(benchmarkData,
                (String s1, String s2) ->  s1.compareTo(s2) * -1
            );

        // Display data and compare
        System.out.println("Bubble sort result: \t" + Arrays.toString(data));
        System.out.println("Built-in sort result: \t" + Arrays.toString(benchmarkData));

        System.out.println("Arrays are equal: " + Arrays.equals(data, benchmarkData));
    }

    public static String[] generateRandomStringArray(int size){
        String [] data = new String[size];

        for (int i = 0; i < data.length; i++) {
            data[i] = "Text -> " + randomGenerator.nextInt(size);
        }

        return data;
    }
}
