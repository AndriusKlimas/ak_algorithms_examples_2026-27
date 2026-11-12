package d_recursion.apps;

import d_recursion.utils.RecursiveUtils;

import java.util.Arrays;

public class TestRecursiveSearching {
    static void main(String[] args) {
        String [] shoppingList = {"Beans", "Vanilla", "Orange juice", "Apples", "Yogurts", "Grapes"};

        String target = "Apples";
        int targetIndex = RecursiveUtils.binarySearch(shoppingList, target);

        if(targetIndex == -1){
            System.out.println(target + " could not be found in the shopping list.");
        }else{
            System.out.println(target + " found at position " + targetIndex);
        }

        System.out.println("Search again after sorting the data:");
        Arrays.sort(shoppingList);
        targetIndex = RecursiveUtils.binarySearch(shoppingList, target);

        if(targetIndex == -1){
            System.out.println(target + " could not be found in the shopping list.");
        }else{
            System.out.println(target + " found at position " + targetIndex);
        }
    }
}
