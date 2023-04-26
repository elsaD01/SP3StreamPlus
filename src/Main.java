public class Main {
    public static void main(String[] args) {

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

        //Here we call the method to read the movie data so the user can pick the specific media they want.
        TextUI textui = new TextUI();
        Collection.movies = textui.readMovieData();
        TextUI text = new TextUI();
        text.pickMedia(Collection.movies);
    }

}


