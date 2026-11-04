public class caPrepSpoof {

    static void main(){
        int[] data = {10,20,10,20,20,30,40,10,10};
        int result = CA_TestPrep.mostFrequentYear(data);
        System.out.println(result);

        int result2 = CA_TestPrep.mostFrequentYearTwoPointer(data);
        System.out.println(result2);


        int[] data2 ={10,20,30,40,50,60,70,80,90};
        int result3 = CA_TestPrep.SpecificDNumTwoPointer(data2, 30);
        System.out.println(result3);
    }
}
