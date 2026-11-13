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

}
