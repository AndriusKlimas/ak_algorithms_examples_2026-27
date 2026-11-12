package in_class.bubbleSorting;

import in_class.bubbleSorting.userClass.Users;

public class bubbleSorting {

    //Q1 E1
    public static void bubbleSortString(String[] data){
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(data, j, j + 1);
                }

            }

        }
    }

    public static void swap(String[] data, int i, int j) {
        String temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    //Q1 E2
    public static void bubbleSortingStringObject(Users[] data){
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(data, j, j + 1);
                }
            }
        }
    }

    public static void swap(Users[] data, int i, int j) {
        Users temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    //Q2 E3
    public static void bubblesortStringImproved(String[] data) {
        boolean swapped;
        for (int i = 0; i < data.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(data, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    //Q2 E4
    public static void bubbleSortingStringObjectImproved(Users[] data){
        boolean swapped;
        for (int i = 0; i < data.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(data, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}
