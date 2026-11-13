package examPrep.data;

import examPrep.entities.Student;

import java.util.Random;

public class StudentGenerator {
    private static final String [] DUMMY_FIRST_NAMES = {
            "Helen", "Norman", "Elias", "Gaiius", "Kara", "Eleanor", "Athena", "Lee", "Minnie", "Laura", "Sam", "Boomer"
    };

    private static final String [] DUMMY_LAST_NAMES = {
            "Collins", "Adama", "Thrace", "Tyrell", "Baltar", "Colonial", "Helo", "Roslyn", "Addamson", "Enidsley",
            "Monster", "Pugsleyday", "Heiheiman"
    };

    private static final String [] DUMMY_COURSE_NAMES = {
            "BSc in Computing",
            "BSc in Computing Systems and Operations",
            "BSc in Games Development",
            "BSc in Cloud Computing",
            "BSc in Electrical Engineering",
            "BSc in Hospitality Management",
            "BSc in Culinary Enterprise",
            "BSc in International Business with Digitalisation",
            "BSc in Business Students",
            "BSc in Architectural Technology"
    };
    
    private static Random randomGenerator = new Random();
    private static int studentCount = 0;

    private static String allocateNextStudentNum(){
        studentCount++;
        return "D" + studentCount;
    }

    private static String generateRandomName(){
        int firstNameIndex = randomGenerator.nextInt(DUMMY_FIRST_NAMES.length);
        String firstName = DUMMY_FIRST_NAMES[firstNameIndex];

        int lastNameIndex = randomGenerator.nextInt(DUMMY_LAST_NAMES.length);
        String lastName = DUMMY_LAST_NAMES[lastNameIndex];

        return firstName + " " + lastName;
    }

    private static String generateRandomCourse(){
        int randomIndex = randomGenerator.nextInt(DUMMY_COURSE_NAMES.length);
        return DUMMY_COURSE_NAMES[randomIndex];
    }


    public static Student generateStudent(){
        String studentNum = allocateNextStudentNum();
        String randomName = generateRandomName();
        String randomCourse = generateRandomCourse();
        int randomYear = randomGenerator.nextInt(1,5);

        return new Student(studentNum, randomName, randomCourse, randomYear);
    }

    public static void main(String[] args) {
        Student [] students = new Student[10];

        for (int i = 0; i < students.length; i++) {
            students[i] = generateStudent();
        }

        for(Student s: students){
            System.out.println(s.format());
        }
    }
}
