public class Main {
    public static void main(String[] args){
        IO scan = new IO();

        UserHandler userhandler = new UserHandler("users.txt");
        scan.signup();

        userhandler.isPasswordValid("");
    }

}