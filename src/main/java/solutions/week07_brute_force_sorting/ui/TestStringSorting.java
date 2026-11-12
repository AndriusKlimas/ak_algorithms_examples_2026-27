package solutions.week07_brute_force_sorting.ui;

import solutions.week07_brute_force_sorting.utils.ArrayUtils;

import java.util.Arrays;



public class TestStringSorting {
    static void main(String[] args) {
        String [] bubblesortData = {"Eggs", "Flour", "Sugar", "Baking powder", "Baking soda", "Buttermilk", "Vanilla"};
        String [] optimisedBubblesortData = Arrays.copyOf(bubblesortData, bubblesortData.length);
        String [] benchmarkData = Arrays.copyOf(bubblesortData, bubblesortData.length);

        Arrays.sort(benchmarkData);

        System.out.println("Sorting with bubble sort:");
        ArrayUtils.bubblesort(bubblesortData);

        System.out.println("Sorting with optimised bubble sort:");
        ArrayUtils.optimisedBubblesort(optimisedBubblesortData);

        System.out.println("Built-in sorted data: " + Arrays.toString(benchmarkData));
        System.out.println("Bubble sorted data: " + Arrays.toString(bubblesortData));
        System.out.println("Optimised bubble sorted data: " + Arrays.toString(optimisedBubblesortData));

        String verdict = "";
        if(!Arrays.equals(bubblesortData, benchmarkData)){
            verdict = "not";
        }
        System.out.println("Bubble sorted array is " + verdict + " equal to built-in sorted");

        verdict = "";
        if(!Arrays.equals(optimisedBubblesortData, benchmarkData)){
            verdict = "not";
        }
        System.out.println("optimised bubble sorted array is " + verdict + " equal to built-in sorted");
    }
}
