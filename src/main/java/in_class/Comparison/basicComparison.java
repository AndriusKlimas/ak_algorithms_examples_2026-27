package in_class.Comparison;

import java.util.Objects;

public class basicComparison {
    public class studentComaprison implements Comparable<studentComaprison>{
        String idNum;
        String name;
        String email;
        int year;

        @Override
        public String toString() {
            return "studentComaprison{" +
                    "idNum='" + idNum + '\'' +
                    ", name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", year=" + year +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            studentComaprison that = (studentComaprison) o;
            return year == that.year && Objects.equals(idNum, that.idNum) && Objects.equals(name, that.name) && Objects.equals(email, that.email);
        }

        @Override
        public int hashCode() {
            return Objects.hash(idNum, name, email, year);
        }

        @Override
        public int compareTo(studentComaprison other) {
            int idCompare = idNum.compareTo(other.idNum);
            return idCompare;
        }
    }
}
