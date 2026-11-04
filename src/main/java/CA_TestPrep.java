import java.util.Arrays;

public class CA_TestPrep {

    //Brute force
    //Calculate the most frequent academic year across all Students in an array

    public static int mostFrequentYear(int[] data) {
        int maxCount = 0;
        int mostFrequest = 0;
        for (int i = 0; i < data.length; i++) {
            int count = 0;
            int main = data[i];
            for (int j = 0; j < data.length; j++) {
                int check = data[j];
                if(check == main){
                    count++;
                }

            }
            if (count>maxCount) {
                maxCount = count;
                mostFrequest = data[i];
            }
            count = 0;
        }
        return mostFrequest;
    }


    public static int mostFrequentYearTwoPointer(int[] data) {
        int[] newArray = Arrays.copyOf(data, data.length);
        Arrays.sort(newArray);
        int count = 0;
        int maxCount = 0;
        int mostFrequesnt = 0;
        int start = 0;
        for (int end = 0; end < newArray.length; end++) {
            if(newArray[end] != newArray[start]) {
                if(count>maxCount){
                    maxCount = count;
                    mostFrequesnt = newArray[start];
                }

                count = 0;
                start = end;
            }
            count++;

        }
        return mostFrequesnt;
    }


    //Search an array of Students for the Student containing a specific student number

    public static int SpecificDNumTwoPointer(int[] data,int requested){

        int left = 0;
        int right = data.length - 1;

        while(left<=right){
            if(data[left] !=requested){
                left++;

            } else if (data[right] != requested) {
                right--;

            }
            else{
                if (data[left] == requested) {
                    return left;
                }
                if (data[right] == requested) {
                    return right;
                }
            }
        }
        return -1;
    }


    public static int SpecificDNumTwoPointer(String[] data, String requested) {
        int left = 0;
        int right = data.length - 1;

        while (left <= right) {
            if (!data[left].equals(requested)) {
                left++;
            } else if (!data[right].equals(requested)) {
                right--;
            } else {
                if (data[left].equals(requested)) {
                    return left;
                }
                if (data[right].equals(requested)) {
                    return right;
                }
            }
        }
        return -1;
    }

}
