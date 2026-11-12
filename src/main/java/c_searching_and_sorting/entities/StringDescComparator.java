package c_searching_and_sorting.entities;

import java.util.Comparator;

public class StringDescComparator implements Comparator<String> {
    public int compare(String s1, String s2){
        return s1.compareTo(s2) * -1;
    }
}
