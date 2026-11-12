package solutions.week07_brute_force_sorting.ui;

import solutions.week07_brute_force_sorting.entities.User;
import solutions.week07_brute_force_sorting.utils.ArrayUtils;

import java.util.Arrays;
import java.util.Random;


public class TestUserSorting {
    public static Random randomGenerator = new Random();
    public static final String BUBBLE = "bubble";
    public static final String OPTIMISED_BUBBLE = "optimised bubble";

    public static User generateRandomUser(){
        String username = "User " + randomGenerator.nextInt(10001);
        String password = "abc123";
        String email = username + "@dkit.ie";

        return new User(username, password, email);
    }

    static void main(String[] args) {
        User[] userData = new User[10];
        for(int i = 0; i < userData.length; i++){
            userData[i] = generateRandomUser();
        }

        testCustomSortForUsers(Arrays.copyOf(userData, userData.length), BUBBLE);
        testCustomSortForUsers(Arrays.copyOf(userData, userData.length), OPTIMISED_BUBBLE);
    }

    public static void testCustomSortForUsers(User [] data, String sortType) {
        User[] customSorted = Arrays.copyOf(data, data.length);

        System.out.println("Original data: " + Arrays.toString(data));

        System.out.println("Sorting with " + sortType + " sort: ");
        switch(sortType){
            case BUBBLE -> {
                ArrayUtils.bubblesort(customSorted);
                Arrays.sort(data);
            }
            case OPTIMISED_BUBBLE -> {
                ArrayUtils.optimisedBubblesort(customSorted,
                    (User u1, User u2) -> u1.getUsername().compareToIgnoreCase(u2.getUsername()) * -1);
                Arrays.sort(data,
                    (User u1, User u2) -> u1.getUsername().compareToIgnoreCase(u2.getUsername()) * -1);
            }
        }

        System.out.println("Built-in sorted data: " + Arrays.toString(data));
        System.out.println(sortType + " sorted data: " + Arrays.toString(customSorted));

        String verdict = "";
        if (!Arrays.equals(customSorted, data)) {
            verdict = "not";
        }
        System.out.println(sortType + " sorted array is " + verdict + " equal to built-in sorted");
    }
}
