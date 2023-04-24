import java.util.ArrayList;

public class User {

        private String fullName;
        private String password;
        ArrayList<User> users = new ArrayList<>();


        public User(String fullName, String password) {

            this.fullName = fullName;
            this.password = password;
        }

        public String getPassword() {

            return getPassword();


        }

        public String getFullName() {
            return fullName;
        }

        public boolean login(String username, String password) {
            for (User user : users) {
                if (user.getFullName().equals(username) && user.getPassword().equals(password))
                    return true;

            }
            return false;


        }
        public boolean createUser(String fullName,String username ,String password ) {
            boolean  usernameTaken = false;
            for (User users:
                    users) {
                if(users.getFullName().equals(username))
                    return false;

            }
            users.add(new User(fullName, password));
            return true;
        }




    }



