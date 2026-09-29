package in_class.week2;

import in_class.ArrayUtilis.ArrayUtils;

public class arraySpoof {
    static void main() {
        int[] arraysInt = {32, 31, 321, 212, 3321, 3214};
        String [] arrayString = {"Dippsy","Po","Laalaa","Zeebra","TinkyWinky","Alehandro"};
        int[] arrayAvr = {10,10,10,10,10};
        int[] arrayToFind = {32,123,213,432,32,10,1,23,32};

//        ArrayUtils.displayArrayNums(arraysInt);
//        ArrayUtils.displayArrayString(arrayString);
//        ArrayUtils.averageArrayInt(arrayAvr);
//        ArrayUtils.findMaxInt(arraysInt);
//        ArrayUtils.findMaxString(arrayString);

        int info = ArrayUtils.findSpecificAmountInt(arrayToFind,32);
        System.out.println("This is how many times occures "+info);

    }
}
