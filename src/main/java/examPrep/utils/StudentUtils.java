package examPrep.utils;

import examPrep.entities.Student;

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
}
