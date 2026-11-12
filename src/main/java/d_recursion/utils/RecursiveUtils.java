package d_recursion.utils;

public class RecursiveUtils {
    public static int factorial(int num){
        if(num <= 1){
            return 1;
        }
        int factorial =  factorial(num-1);
        return num * factorial;
    }

    public static int sum(int [] data){
        return sum(data, 0);
    }

    public static int sum(int [] data, int startPos){
        if(startPos == data.length-1){
            return data[startPos];
        }

        return data[startPos] + sum(data, startPos+1);
    }

    public static int binarySearch(String [] data, String target) {
        if (data == null) {
            throw new IllegalArgumentException("Cannot search a null array");
        }

        int start = 0;
        int end = data.length - 1;

        return binarySearch(data, target, start, end);
    }

    private static int binarySearch(String [] data, String target, int start, int end){
        if (start <= end){
            int mid = start + (end - start) / 2;
            if(data[mid].compareTo(target) == 0){
                return mid;
            }else if(data[mid].compareTo(target) > 0){
                end = mid - 1;
                return binarySearch(data, target, start, end);
            }else{
                start = mid + 1;
                return binarySearch(data, target, start, end);
            }
        }
        return -1;
    }
}
