import java.io.File;
import java.util.Scanner;


public class IO extends User {

    User user = new User();
    Scanner scan = new Scanner(System.in);


    public String getUserInput() {
        System.out.println("hello, if you want to sign up  press 1,or to log in press 2 ");
        return scan.nextLine();


    }

    public void signup() {
        System.out.println(" please enter yout full name" + getFullName());
        String fullname = scan.nextLine();
        System.out.println("Enter please create a username");
        String username =  scan.nextLine();
        System.out.println("enter your password ");
        String password = scan.nextLine();



    }
}