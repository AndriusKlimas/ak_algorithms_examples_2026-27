package a_conversion;

import java.util.ArrayList;

public class SampleDocs {
    /**
     * Searches (case-insensitive) for a specified String in the supplied list
     * @param names the list of Strings to be searched
     * @param target the String to be searched for
     * @return true if a match is found, false otherwise (case-insensitive)
     */
    public static boolean search(ArrayList<String> names, String target){
        for (int i = 0; i < names.size(); i++) {
            if(names.get(i).equalsIgnoreCase(target)){
                return true;
            }
        }

        return false;
    }

    /**
     * Calculate the average of a list of doubles
     * @param values The list of doubles to be used
     * @return the average of all values within the list
     */
    public static double calcAverage(ArrayList<Double> values){
        int total = 0;
        for (int i = 0; i < values.size(); i++) {
            total+=values.get(i);
        }

        return total / (double) values.size();
    }
}
