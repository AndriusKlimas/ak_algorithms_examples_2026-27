package homework.CA1;

public class dataSpoof {
    static void main(){
//        String word = "helo";
//        String result = bruteVsTwo.ReverseVowelsTwo(word);
//        System.out.println(result);

        int[] array1 = {1,2,2};
        int[] array2 = {2,2,1};

        boolean result = bruteVsTwo.sameArrayContentBrute(array1,array2);
        if(result == true){
            System.out.println("The arrays have the same content.");
        } else {
            System.out.println("The arrays do not have the same content.");
        }
    }


}
