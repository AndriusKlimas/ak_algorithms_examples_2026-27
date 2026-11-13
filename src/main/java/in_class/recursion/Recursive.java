package in_class.recursion;

public class Recursive {

    public static int fibonacci(int index){

        if(index<=0){
            throw new IllegalArgumentException("Index must be higher than zero");
        }


        if (index == 1 || index ==2){
            return 1;
        }

        return fibonacci(index - 1) + fibonacci(index - 2);
    }

    public static int recursiveSum(int[] data, int index){
        int size = data.length;
        if (index == size-1) {
            return data[index];
        }
        return data[index]+ recursiveSum(data, index + 1);


    }

}
