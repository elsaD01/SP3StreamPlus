;import java.util.Scanner;


public class TextUI {
    Scanner scanner;
    UserHandler userhandler;
    User user = new User();

    public TextUI(UserHandler userHandler) {
        this.userhandler = userHandler;
        this.scanner = new Scanner(System.in);


    }

    public String getUserInput() {
        System.out.println("hello, if you want to log in press 1,or to sign up press 2 ");
        return scanner.nextLine();


    }


    public void logIn() {
        System.out.println("Enter please log in with your username");
        String username = scanner.nextLine();

        System.out.println("enter your password ");
        String password = scanner.nextLine();
        if (userhandler.login(password, username)) {
            System.out.println("welcome to Chill  " + username);
        } else {
            int attempts = 0;
            while (attempts < 3) {
                System.out.println("Password is incorrect or username is invalid");
                System.out.println("Enter your username");
                username = scanner.nextLine();
                System.out.println("Enter your password again");
                password = scanner.nextLine();
                if (userhandler.login(username, password)) { // Updated parameter order
                    System.out.println("Welcome to Chill  " + username);
                    break; // Exit the loop after successful login
                } else {
                    attempts++;
                }
            }
            if (attempts == 3) {
                System.out.println("Maximum login attempts reached. Exiting...");
            }
        }
    }












    public void createUser() {
        System.out.println("please enter your full name");
        String fullname = scanner.nextLine();
        System.out.println("Enter your username");
        String username = scanner.nextLine();
        System.out.println("please Enter your password");
        String password = scanner.nextLine();

        if (userhandler.createUser(fullname, username, password)) {
            System.out.println("welcome  " + username);
        } else {
            System.out.println("your username or password cannot be used");
        }
    }
}