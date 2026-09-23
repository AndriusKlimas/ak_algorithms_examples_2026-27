package in_class.week02_arrays;

public class SampleArrayWork {
    static void main(String[] args) {
        int [] nums = new int[10];

        System.out.println("Nums array size: " + nums.length);

        System.out.println("Display all values in the nums array:");
        for (int i = 0; i < nums.length; i++) {
            System.out.println(i + ") " + nums[i]);
        }


        String [] names = {"Henry", "Elizabeth", "Anne", "Mary"};
        System.out.println("Display all values in the names array");
        for(String name: names){
            System.out.println(name);
        }
    }
}
