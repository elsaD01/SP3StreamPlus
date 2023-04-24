import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserHandler {


    ArrayList<User> users = new ArrayList<>();
    File file;


    public UserHandler(String filename) {
        file = new File(filename);

    }

    public boolean login(String username, String password) {
        for (User user : users) {
            if (user.getFullName().equals(username) && user.getPassword().equals(password))//should username = name
                return true;

        }
        return false;


    }

    public boolean createUser(String fullName, String username, String password) {
        boolean usernameTaken = false;
        for (User users :
                users) {
            if (users.getFullName().equals(username))
                return false;

        }
        users.add(new User(fullName, password, username));
        return true;
    }

    boolean isPasswordValid(String password) {


        if (password == null || password.length() <= 5 || password.length() > 14  ) {

            System.out.println("the password  is not valid try again ");
            return false;

        } else {

            int n =Integer.parseInt(password);
            if(password.equals(n) || password.length() <= 5 || password.length() > 14  );
            return true;
        } else {
        if (password.matches(".*\\d.*")) {
            // Password contains at least one digit
            return true;
        } else {
            System.out.println("The password must contain at least one digit. Please try again.");
            return false;
        }
    }
}




    public void loadusers() {
        try {
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()) {
                String input = scan.nextLine();
                String[] values = input.split(",");
                users.add(new User(values[0], values[1], values[2]));
            }
        } catch (IOException e) {
            System.out.println(" the system is not working currently");
        }

    }
    public void saveUsers(){

        try{
            FileWriter writer = new FileWriter (file);
            for (User users : users){
                writer.write(users.getFullName() +"" +users.getUsername() +""+ users.getPassword());
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("system is not workin currently ");

        }


    }
}



