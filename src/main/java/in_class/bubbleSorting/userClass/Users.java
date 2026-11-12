package in_class.bubbleSorting.userClass;

import c_searching_and_sorting.entities.Book;

public class Users implements Comparable<Users> {
    private final String username;
    private final String password;
    private final String email;

    public Users(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @Override
    public int compareTo(Users other) {
        return this.username.compareTo(other.username);
    }

    @Override
    public String toString() {
        return "Users{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;
        return username.equals(users.username) && password.equals(users.password) && email.equals(users.email);
    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }

    public  String get_username() {
        return username;
    }

    public String get_password() {
        return password;
    }

    public String get_email() {
        return email;
    }
}
