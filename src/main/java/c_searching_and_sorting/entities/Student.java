package c_searching_and_sorting.entities;

import java.util.Objects;

public class Student implements Comparable<Student>{
    private String idNum;
    private String name;
    private String email;
    private int year;

    public Student(String idNum, String name, String email, int year) {
        this.idNum = idNum;
        this.name = name;
        this.email = email;
        this.year = year;
    }

    public String getIdNum() {
        return idNum;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;
        return year == student.year && Objects.equals(idNum, student.idNum) && Objects.equals(name, student.name) && Objects.equals(email, student.email);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(idNum);
        result = 31 * result + Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(email);
        result = 31 * result + year;
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "idNum='" + idNum + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", year=" + year +
                '}';
    }

    public int compareTo(Student other){
        return this.idNum.compareTo(other.idNum);
    }
}
