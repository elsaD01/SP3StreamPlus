public class Main {
    public static void main(String[] args){
UserHandler  userHandler = new UserHandler("users.txt");
TextUI textUI = new TextUI(userHandler);
userHandler.loadusers();
String userinput = textUI.getUserInput();
switch(userinput){
    case "1":
        textUI.logIn();
        break;
    case "2":
        textUI.createUser();
        break;
    default:
        System.out.println("Goodbye");
}
userHandler.saveUsers();

    }

}