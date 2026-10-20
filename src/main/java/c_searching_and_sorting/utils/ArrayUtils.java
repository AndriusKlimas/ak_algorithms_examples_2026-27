package c_searching_and_sorting.utils;

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

            int comparison = target.compareTo(data[mid]);
            if(comparison == 0){
                return mid;
            }else if(comparison < 0){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

        return -1;
    }
}
