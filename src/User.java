import java.util.ArrayList;
import java.util.Scanner;

public class User {

    private String fullName;
    private String password;
    private String username;


    public User(String fullName, String username, String password) {

        this.fullName = fullName;
        this.password = password;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {

        return password;


    }

    public String getFullName() {
        return fullName;
    }


}



