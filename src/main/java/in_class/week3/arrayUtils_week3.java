package in_class.week3;

public class arrayUtils_week3 {

    public static int count(int[] array, int toFind){
        int count = 0;
        for(int i=0;i<array.length;i++){
            if (array[i] == toFind){
                count ++;
            }
        }
        return count;
    }

    public static int mostFrequentInt(int[] array) {
        int maxCount = 0;
        int mostFrequent = array[0];

        for (int i = 0; i < array.length; i++) {
            int count = 0;

            for (int j = 0; j < array.length; j++) {
                if (array[j] == array[i]) {
                    count++;
                }
            }

            System.out.println("Count is " + count + " Current num is " + array[i]);

            if (count > maxCount) {
                maxCount = count;
                mostFrequent = array[i];
            }
        }

        return mostFrequent;
    }
}
