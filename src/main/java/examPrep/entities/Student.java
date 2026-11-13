package examPrep.entities;

public class Student {
    private String studentNum;
    private String name;
    private String course;
    private int year;

    public Student(String studentNum, String name, String course, int year) {
        nullValidate(studentNum, "Student number");
        this.studentNum = studentNum;

        nullValidate(name, "Student name");
        this.name = name;

        nullValidate(course, "Course name");
        this.course = course;

        if(year < 1){
            throw new IllegalArgumentException("Year cannot be less than 1");
        }
        this.year = year;
    }

    private static void nullValidate(String value, String valueName) {
        if (value == null) {
            throw new IllegalArgumentException(valueName + " cannot be null.");
        }
    }

    public String getStudentNum() {
        return studentNum;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;
        return studentNum.equals(student.studentNum);
    }

    @Override
    public int hashCode() {
        return studentNum.hashCode();
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentNum='" + studentNum + '\'' +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", year=" + year +
                '}';
    }

    public String format(){
        StringBuilder sb = new StringBuilder();
        sb.append(studentNum);
        sb.append(" - ");
        sb.append(name);
        sb.append("\n\t");
        sb.append(course);
        sb.append(" (Year ");
        sb.append(year);
        sb.append(")");
        return sb.toString();
    }
}
