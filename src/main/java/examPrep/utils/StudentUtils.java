package examPrep.utils;

import examPrep.entities.Student;
import in_class.week1.CalcMax;

import java.util.Arrays;
import java.util.Comparator;


public class StudentUtils {

    private static void ArrayValidation(Student[] array){
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
    }

    private static void studentValidation(Student[] array){
        for (Student student : array) {
            if (student == null) {
                throw new IllegalArgumentException("Student cannot be null");
            }
        }
    }

    public static int mostFrequentYear_BruteForce(Student[] students){
        ArrayValidation(students);
        studentValidation(students);

        // Implementation for brute force approach
        int answer = 1;
        int highestNumber = 0;

        for (int i = 1; i <= 5; i++) {
            int number = 0;

            for (Student student : students){
                if (student.getYear() == i) {
                    number++;
                }
            }

            if (number > highestNumber){
                highestNumber = number;
                answer = i;
            }

        }
        return answer;
//        for (int year = 1; year <= 5; year++) {
//            int number = 0;
//
//            for (Student student : students) {
//                if (student.getYear() == year) {
//                    number++;
//                }
//            }
//
//            if (number > highestNumber) {
//                highestNumber = number;
//                answer = year;
//            }
//        }
//
//        return answer;
    }


    public static int mostFrequentYear_TwoPointer(Student[] students){
        ArrayValidation(students);
        studentValidation(students);

        Student[] newArray = Arrays.copyOf(students, students.length);
        Arrays.sort(newArray, Comparator.comparingInt(Student::getYear));

        int answer = newArray[0].getYear();
        int biggestCount = 0;
        int position = 0;

        while(position < newArray.length){
            int year = newArray[position].getYear();
            int nextPosition = position;
            int count = 0;

            while(nextPosition < newArray.length && newArray[nextPosition].getYear() == year){
                count++;
                nextPosition++;
            }

            if(count > biggestCount){
                biggestCount = count;
                answer = year;
            }

            position = nextPosition;
        }


        return answer;

    }

    public static Student searchByStudentNumber_BruteForce(Student[] students, String studentNum){
        ArrayValidation(students);
        if (studentNum == null || studentNum.isEmpty()) {
            throw new IllegalArgumentException("Student number cannot be null or empty");
        }
        studentValidation(students);

        for (Student student : students) {
            if (student != null && student.getStudentNum().equals(studentNum)) {
                return student;
            }
        }
        return null;
    }

    public static Student searchByStudentNumber_TwoPointer(Student[] students, String studentNum){
        Student[] sortedStudents = students.clone();

        Arrays.sort(
                sortedStudents,
                Comparator.comparing(Student::getStudentNum)
        );

        int left = 0;
        int right = sortedStudents.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            int comparison = sortedStudents[middle]
                    .getStudentNum()
                    .compareTo(studentNum);

            if (comparison == 0) {
                return sortedStudents[middle];
            } else if (comparison < 0) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return null;
    }

    public static int countStudentsBruteForce(Student[] students, int year){
        int count = 0;
        for (Student student : students) {
            if (student != null && student.getYear() == year) {
                count++;
            }
        }
        if (count>0){
            return count;
        }
        else{
            return 0;
        }
    }

    public static int countStudentsTwoPointer(Student[] students, int year){
        Student[] newArray = Arrays.copyOf(students, students.length);

        Arrays.sort(
                newArray,
                Comparator.comparingInt(Student::getYear)
        );

        int end = 0;

        // Find the first student with the requested year
        while (end < newArray.length &&
                newArray[end].getYear() < year) {
            end++;
        }

        int count = 0;

        // Count students with that year
        while (end < newArray.length &&
                newArray[end].getYear() == year) {
            count++;
            end++;
        }

        return count;
    }


    private static void StringValidation(String toCheck){
        if (toCheck == null || toCheck.isBlank()) {
            throw new IllegalArgumentException(
                    "Course name cannot be null or blank"
            );
        }
    }

    public static int countByCourseBruteForce(
            Student[] students, String courseName){
        StringValidation(courseName);
        //initalise varaibles
        int count = 0;

        for (Student student : students) {
            if (student != null &&
                    student.getCourse().equals(courseName)) {
                count++;
            }
        }

        return count;
    }

    public static int countByCourseTwoPointer(Student[] students, String courseName){
        // need to add validation for checking if course name != null or white space

        StringValidation(courseName);

        //copy the array
        //sort teh array
        Student[] newArray = Arrays.copyOf(students, students.length);
        Arrays.sort(newArray,Comparator.comparing(Student::getCourse));

        //find the start position, so go through the entier list until you find it

        int end = 0;

        while (end < newArray.length &&
                !newArray[end].getCourse().equals(courseName)) {
            end++;
        }

        //once found run through it and start counting until it is no longer equil
        int count = 0;

        while (end < newArray.length &&
                newArray[end].getCourse().equals(courseName)) {
            count++;
            end++;
        }

        //once found run through it and start counting until it is no longer equil

        return count;
    }

    public static Student searchByNameBruteForce(
            Student[] students, String name){
        Student found;
        for (Student student : students){
            if (student !=null && student.getName().equals(name)){
                found = student;
                return found;
            }


        }
        return null;
    }

    public static Student searchByNameTwoPointer(
            Student[] students, String name){

        Student[] newArray = Arrays.copyOf(students, students.length);
        Arrays.sort(newArray,Comparator.comparing(Student::getName));


        int left = 0;
        int right = newArray.length - 1;

        while (left <= right) {
            if (name.equals(newArray[left].getName())) {
                return newArray[left];
            }

            if (name.equals(newArray[right].getName())) {
                return newArray[right];
            }

            left++;
            right--;
        }

        return null;
    }

    //Test prep
    //Converging pointer
    //easy
    public static Student findStudent(Student[] students, String studentNumber){
        Student[] newArray = Arrays.copyOf(students, students.length);
        Arrays.sort(newArray,Comparator.comparing(Student::getStudentNum));

        int left = 0;
        int right = newArray.length-1;

        while(left<=right){
            if (studentNumber.equals(newArray[left].getStudentNum())){
                return newArray[left];
            }
            if (studentNumber.equals(newArray[right].getStudentNum())){
                return newArray[right];
            }
            left++;
            right--;
        }
        return null;
    }

    //Inter
    public static boolean hasYearPairWithTotal(
            Student[] students, int target){
        Student[] newArray = Arrays.copyOf(students, students.length);
        Arrays.sort(newArray, Comparator.comparing(Student::getYear));
        int left = 0;
        int right = newArray.length-1;

        while (left<right){
            int sum = newArray[left].getYear() + newArray[right].getYear();
            if (sum == target){
                return true;
            }else{
                if (target<sum){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return false;

    }


    //Continious window
    //easy

    public static int highestYearTotal(Student[] students) {
        // calculating the sum of the first window
        int windowSize = 3;
        int windowSum = 0;

        for (int i = 0; i < windowSize; i++) {
            windowSum += students[i].getYear();
        }

        int maxSum = windowSum;

        for (int right = windowSize; right < students.length; right++) {
            windowSum -= students[right-windowSize].getYear();
            windowSum += students[right].getYear();

            if (windowSum> maxSum){
                maxSum = windowSum;
            }
        }
        return maxSum;



        //sliding the window

//        int windowSum = 0;
//        for (int i = 0; i < k; i++) {
//            windowSum += data[i];
//        }
//
//
//
//        int maxSum = windowSum;
//
//        //sliding the window
//        for (int right = k; right < data.length; right++) {
//            windowSum -= data[right - k];
//            windowSum += data[right];
//
//            if (windowSum > maxSum)
//                maxSum = windowSum;
//        }
//        return maxSum;
    }


    public static int highestCourseCount(
            Student[] students, String courseName){
        int windowSize = 3;

        if (students.length < windowSize) {
            return 0;
        }

        int count = 0;

        // Count the first window
        for (int i = 0; i < windowSize; i++) {
            if (courseName.equals(students[i].getCourse())) {
                count++;
            }
        }

        int maxCount = count;

        // Move the window across the array
        for (int right = windowSize; right < students.length; right++) {
            int leaving = right - windowSize;

            if (courseName.equals(students[leaving].getCourse())) {
                count--;
            }

            if (courseName.equals(students[right].getCourse())) {
                count++;
            }

            if (count > maxCount) {
                maxCount = count;
            }
        }

        return maxCount;
    }

    //dynamic window
    //easy??????????? i dont think so
    public static int shortestCourseWindow(
            Student[] students, String courseName){

        int start = 0;
        int matches = 0;
        int shortest = Integer.MAX_VALUE;

        for (int end = 0; end < students.length; end++) {

            if (courseName.equals(students[end].getCourse())) {
                matches++;
            }

            // Shrink from the left once the window has two matches
            while (matches >= 2) {
                int windowSize = end - start + 1;

                if (windowSize < shortest) {
                    shortest = windowSize;
                }

                if (courseName.equals(students[start].getCourse())) {
                    matches--;
                }

                start++;
            }
        }

        if (shortest == Integer.MAX_VALUE) {
            return 0;
        }

        return shortest;
    }

    //this is something else
    public static int longestTwoCourseWindow(Student[] students){
        int start = 0;
        int longest = 0;

        for (int end = 0; end < students.length; end++) {

            int differentCourses;

            do {
                String[] foundCourses = new String[end - start + 1];
                int numberFound = 0;

                for (int i = start; i <= end; i++) {
                    String currentCourse = students[i].getCourse();
                    boolean alreadyFound = false;

                    for (int j = 0; j < numberFound; j++) {
                        if (foundCourses[j].equals(currentCourse)) {
                            alreadyFound = true;
                            break;
                        }
                    }

                    if (!alreadyFound) {
                        foundCourses[numberFound] = currentCourse;
                        numberFound++;
                    }
                }

                differentCourses = numberFound;

                if (differentCourses > 2) {
                    start++;
                }

            } while (differentCourses > 2);

            int windowSize = end - start + 1;

            if (windowSize > longest) {
                longest = windowSize;
            }
        }

        return longest;
    }


    //recap
    //two pointer

    public static int countYearsBetween(
            Student[] students, int minimumYear, int maximumYear){
        Student[] newArray = Arrays.copyOf(students, students.length);
        Arrays.sort(newArray, Comparator.comparing(Student::getYear));

        int start = 0;
        int result = 0;



        while (start< newArray.length && newArray[start].getYear() != minimumYear){
            start++;
        }


        int end = start;

        while(end< newArray.length && newArray[end].getYear() != maximumYear){
            end++;
        }

        if (result<(start - end) +1){
            result = (start - end) +1;
        }

        return result;

    }

    //recap
    //converging pointer
    public static boolean hasYearTotal(
            Student[] students, int target){
        Student[] newArrray = Arrays.copyOf(students,students.length);
        Arrays.sort(newArrray, Comparator.comparing(Student::getYear));

        int left = 0;
        int right = newArrray.length -1;
        int total = 0;

        while (left<right){
            //need to add them
            //check the result
            // if to high lower right
            // if to low increase left

            total = newArrray[left].getYear() + newArrray[right].getYear();
            if (target>total){
                left++;
            } else if (target<total) {
                right--;
            } else if (total==target) {
                return true;

            }
        }
     return false;
    }


    //recap fixed window
    public static int highestThreeYearTotal(Student[] students){
        int windowSize = 3;
        int windowSum = 0;

        for (int i = 0; i < windowSize; i++) {
            windowSum += students[i].getYear();
        }

        int currentMax = windowSum;

        for (int i = windowSize; i < students.length; i++) {
            int leaving = i - windowSize;

            windowSum -= students[leaving].getYear();
            windowSum += students[i].getYear();

            if (windowSum>currentMax){
                currentMax = windowSum;
            }

        }
        return currentMax;
    }

    //recap
    //dynamic window
    public static int shortestThreeCourseWindow(
            Student[] students, String courseName){
        //set up the variables
        //start end
        //while end > data length
        // keep moving
        //keep a count of if the persons course is the same as needed
        // once count is 3
        //stop end
        // while count >= 3
        // start ++
        //need to check if current window size is less than smallest
        // if it is store the new size

        int start = 0;
        int count = 0;
        int shortest = Integer.MAX_VALUE;

        for (int end = 0; end < students.length; end++) {

            if (courseName.equals(students[end].getCourse())) {
                count++;
            }

            while (count >= 3) {
                int windowSize = end - start + 1;

                if (windowSize < shortest) {
                    shortest = windowSize;
                }

                if (courseName.equals(students[start].getCourse())) {
                    count--;
                }

                start++;
            }
        }

        if (shortest == Integer.MAX_VALUE) {
            return 0;
        }

        return shortest;
    }

    //recap/learning
    // read write
    public static int moveFirstYearStudents(Student[] students){
        int write = 0;

        for (int read = 0; read < students.length; read++) {
            if (students[read].getYear() == 1) {
                students[write] = students[read];
                write++;
            }
        }

        // Clear the remaining positions
        for (int i = write; i < students.length; i++) {
            students[i] = null;
        }

        return write;

    }

    //read write
    public static int keepStudentsInCourse(
            Student[] students, String courseName){
        int write = 0;

        for (int read = 0; read < students.length; read++) {
            if (students[read].getCourse().equals(courseName)){
                students[write] = students[read];
                write++;
            }

        }
        for (int i = write; i < students.length; i++) {
            students[i] = null;
        }
        return write;
    }


    //learning bubblesort
    //sorts low to high
    public static void bubbleSortByYear(Student[] students){

        boolean swapped;
        for (int i = 0; i < students.length; i++) {
            swapped = false;
            for (int j = 0; j < students.length -1 -i; j++) {
                if (students[j].getYear() > students[j+1].getYear()){
                    swap(students,j,j+1);
                    swapped = true;
                }

            }
            if (!swapped){
                break;
            }

        }
    }

    private static void swap(Student [] data, int indexA, int indexB){
        Student temp = data[indexA];
        data[indexA] = data[indexB];
        data[indexB] = temp;


    }

    //sorting in alphabetical order
    public static void bubbleSortByName(Student[] students){
        boolean swapped;
        for (int i = 0; i < students.length; i++) {
            swapped = false;
            for (int j = 0; j < students.length -1 -i; j++) {
                if (students[j].getName().compareTo(students[j+1].getName())>0){
                    swap(students,j,j+1);
                    swapped = true;
                }
            }
            if (!swapped){
                break;
            }
        }
    }

}


