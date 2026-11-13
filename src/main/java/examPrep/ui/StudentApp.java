package examPrep.ui;

import examPrep.data.StudentGenerator;
import examPrep.entities.Student;

public class StudentApp {
    static void main() {
        Student[] students = new Student[10];

        for (int i = 0; i < students.length; i++) {
            students[i] = StudentGenerator.generateStudent();
        }

        for(Student s: students){
            System.out.println(s.format());
        }
    }
}
