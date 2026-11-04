package c_searching_and_sorting.apps;

import c_searching_and_sorting.utils.ArrayUtils;

import java.util.Arrays;

public class TestSearching {
    static void main(String[] args) {
        String [] shoppingList = {"Beans", "Vanilla", "Orange juice", "Apples", "Yogurts", "Grapes"};

        String target = "Apples";
        int targetIndex = ArrayUtils.binarySearch(shoppingList, target);

        if(targetIndex == -1){
            System.out.println(target + " could not be found in the shopping list.");
        }else{
            System.out.println(target + " found at position " + targetIndex);
        }

        System.out.println("Search again after sorting the data:");
        Arrays.sort(shoppingList);
        targetIndex = ArrayUtils.binarySearch(shoppingList, target);

        if(targetIndex == -1){
            System.out.println(target + " could not be found in the shopping list.");
        }else{
            System.out.println(target + " found at position " + targetIndex);
        }
    }
}
