package solutions.week07_brute_force_sorting.utils;

import solutions.week07_brute_force_sorting.entities.User;

import java.util.Comparator;

public class ArrayUtils {
    public static void bubblesort(String [] data){
        nullValidateArray(data);

        int passCount = 0;
        int comparisonCount = 0;
        int swapCount = 0;

        for (int i = 0; i < data.length - 1; i++) {
            passCount++;
            for (int j = 0; j < data.length - 1 - i; j++) {
                comparisonCount++;
                if(data[j].compareTo(data[j+1]) > 0){
                    swapCount++;
                    swap(data, j, j+1);
                }
            }
        }
        System.out.println("Statistics:");
        System.out.println("Pass count: " + passCount);
        System.out.println("Comparison count: " + comparisonCount);
        System.out.println("Swap count: " + swapCount);
    }

    private static void swap(String[] data, int indexA, int indexB) {
        String temp = data[indexA];
        data[indexA] = data[indexB];
        data[indexB] = temp;
    }

    public static void bubblesort(User [] data){
        nullValidateArray(data);

        int passCount = 0;
        int comparisonCount = 0;
        int swapCount = 0;

        for (int i = 0; i < data.length - 1; i++) {
            passCount++;
            for (int j = 0; j < data.length - 1 - i; j++) {
                comparisonCount++;
                if(data[j].compareTo(data[j+1]) > 0){
                    swapCount++;
                    swap(data, j, j+1);
                }
            }
        }
        System.out.println("Statistics:");
        System.out.println("Pass count: " + passCount);
        System.out.println("Comparison count: " + comparisonCount);
        System.out.println("Swap count: " + swapCount);
    }

    private static void swap(User[] data, int indexA, int indexB) {
        User temp = data[indexA];
        data[indexA] = data[indexB];
        data[indexB] = temp;
    }

    public static void optimisedBubblesort(String [] data){
        nullValidateArray(data);

        boolean swapped;

        int passCount = 0;
        int comparisonCount = 0;
        int swapCount = 0;

        for (int i = 0; i < data.length - 1; i++) {
            swapped = false;
            passCount++;
            for (int j = 0; j < data.length - 1 - i; j++) {
                comparisonCount++;
                if(data[j].compareTo(data[j+1]) > 0){
                    swapCount++;
                    swap(data, j, j+1);
                    swapped = true;
                }
            }

            if(!swapped){
                break;
            }
        }
        System.out.println("Statistics:");
        System.out.println("Pass count: " + passCount);
        System.out.println("Comparison count: " + comparisonCount);
        System.out.println("Swap count: " + swapCount);
    }

    private static void nullValidateArray(String[] data) {
        if(data == null){
            throw new IllegalArgumentException("Cannot sort null array");
        }
    }

    public static void optimisedBubblesort(User [] data, Comparator<User> userComparator){
        nullValidateArray(data);

        boolean swapped;

        int passCount = 0;
        int comparisonCount = 0;
        int swapCount = 0;

        for (int i = 0; i < data.length - 1; i++) {
            swapped = false;
            passCount++;
            for (int j = 0; j < data.length - 1 - i; j++) {
                comparisonCount++;
                if(userComparator.compare(data[j], data[j+1]) > 0){
                    swapCount++;
                    swap(data, j, j+1);
                    swapped = true;
                }
            }

            if(!swapped){
                break;
            }
        }
        System.out.println("Statistics:");
        System.out.println("Pass count: " + passCount);
        System.out.println("Comparison count: " + comparisonCount);
        System.out.println("Swap count: " + swapCount);
    }

    private static void nullValidateArray(User[] data) {
        if(data == null){
            throw new IllegalArgumentException("Cannot sort null array");
        }
    }
}
