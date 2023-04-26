import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserHandler {




    ArrayList<User> users = new ArrayList<>();
    File file;


    public UserHandler(String filename) {
        file = new File(filename);

    }

    public boolean login(String username, String password) {
        for (User user : users) {

            if (user.getUsername().equals(username) && user.getPassword().equals(password)){//should username = name
                return true;
            }
        }
        return false;


    }

    public boolean createUser(String fullName, String username, String password) {
        boolean usernameTaken = false;
        if(!isPasswordValid(password)){
            return false;
        }
        for (User users :
                users) {
            if (users.getUsername().equals(username))
                return false;

        }
        users.add(new User(fullName, password, username));
        return true;
    }

    public boolean isPasswordValid(String password) {
        if(password == null || password.length() <= 5 || password.length() >20){
            System.out.println("the password is not meeting conditons ");
            return false;
        }
        else{

            return true ;
        }
    }


/*
        String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?!.*\\s).{5,20}$";
        Pattern pattern1 = Pattern.compile(pattern);
        Matcher matcher = pattern1.matcher(password);
        if(password.equals(pattern)) {
            return matcher.matches();
        }else{
            return false;
        }

    }
*/

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
                writer.write(users.getFullName() +"," +users.getUsername() +","+ users.getPassword()+
                        "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("system is not working currently ");

        }


    }


    }



