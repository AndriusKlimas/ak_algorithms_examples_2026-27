package c_searching_and_sorting.utils;

import java.util.Comparator;

public class ArrayUtils {
    public static int binarySearch(int [] data, int target){
        if(data == null){
            throw new IllegalArgumentException("Cannot search a null array");
        }

        int start = 0;
        int end = data.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(data[mid] == target){
                return mid;
            }else if(data[mid] > target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

        return -1;
    }

    public static int linearSearch(int [] data, int target){
        for (int i = 0; i < data.length; i++) {
            if(target == data[i]){
                return i;
            }
        }

        return -1;
    }

    public static int binarySearch(String [] data, String target){
        if(data == null){
            throw new IllegalArgumentException("Cannot search a null array");
        }

        if(target == null){
            throw new IllegalArgumentException("Cannot use this algorithm to search for null");
        }

        int start = 0;
        int end = data.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            int comparison = data[mid].compareTo(target);
            if(comparison == 0){
                return mid;
            }else if(comparison > 0){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

        return -1;
    }

    public static void bubblesort(int [] data){
        nullValidateArray(data);

        for (int i = 0; i < data.length-1; i++) {
            for (int j = 0; j < data.length-1-i; j++) {
                if(data[j] > data[j+1]){
                    swap(data, j, j+1);
                }
            }
        }
    }

    private static void nullValidateArray(int[] data) {
        if(data == null){
            throw new IllegalArgumentException("Cannot sort a null array");
        }
    }

    private static void swap(int [] data, int indexA, int indexB){
        int temp = data[indexA];
        data[indexA] = data[indexB];
        data[indexB] = temp;
    }

    public static void optimisedBubblesort(int [] data){
        nullValidateArray(data);

        boolean swapped;
        for (int i = 0; i < data.length-1; i++) {
            swapped = false;
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    swap(data, j, j + 1);
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }

    public static void selectionSort(int [] data){
        nullValidateArray(data);

        for (int i = 0; i < data.length - 1; i++) {
            int minPos = i;
            int min = data[minPos];

            for (int j = i+1; j < data.length; j++) {
                if(data[j] < min){
                    min = data[j];
                    minPos = j;
                }
            }
            if(minPos != i) {
                swap(data, i, minPos);
            }
        }
    }

    public static void bubblesort(String [] data, Comparator<String> stringComparator){
        if(data == null){
            throw new IllegalArgumentException("Cannot sort null array");
        }

        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {
                if(stringComparator.compare(data[j], data[j+1]) > 0){
                    swap(data, j, j+1);
                }
            }
        }
    }

    private static void swap(String[] data, int indexA, int indexB) {
        String temp = data[indexA];
        data[indexA] = data[indexB];
        data[indexB] = temp;
    }
}
