public class Main {
    public static void main(String[] args) {


        UserHandler userHandler = new UserHandler("data/UserLogin.csv");
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
        FileIO fileIO = new FileIO();
        CollectionLab.movies = fileIO.readMovieData();
        TextUI text = new TextUI(userHandler);
        text.pickMedia(CollectionLab.movies);


    }
}


