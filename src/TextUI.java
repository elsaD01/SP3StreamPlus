import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collection;


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

    public void pickMedia(ArrayList<Media> medias){

        TextUI textUI = new TextUI();
        System.out.println("Menu: Choose type of media: ");

        Scanner scan = new Scanner(System.in);
        System.out.println("1-Movies");
        System.out.println("2-Series");
        System.out.println("3-Search");
        System.out.println("4-Watched");
        System.out.println("5-Saved");
        int input = scan.nextInt();

        if(input == 1){
            System.out.println("You choose movies, here's some options");
            for(int i = 0; i < medias.size(); i++){

                String movieS = i+ " - " + medias.get(i).getName();
                System.out.println(movieS);
            }
            textUI.chooseMovie();
            textUI.youHaveChosenMovie();

        }

        else if (input == 2) {
            System.out.println("You choose series, here's some options");
        }
        else if (input == 3){
            ArrayList<Media> searchResults = textUI.search();
            for(Media m : searchResults){
                System.out.println(m);
            }

            Scanner src = new Scanner(System.in);
            System.out.println("Please enter the movies full name");
            String nameOfMovie = src.nextLine();
            System.out.println(checkMoviesSearch(nameOfMovie, searchResults));
        }

        else if (input == 4) {
            System.out.println("You choose your watched list: ");
        }

        else if (input == 5) {
            System.out.println("You choose your saved list: ");
        }
    }

    public void chooseMovie(){
        Scanner cs = new Scanner(System.in);
        System.out.println("\n\n");
        System.out.println("Please press the number of the movie you want to watch");
        int movieNumberToWatch = cs.nextInt();
        System.out.println("you have chosen " + choseResults(movieNumberToWatch));
    }

    public String choseResults(int movieNumberToWatch){
        ArrayList<Media> wannaWatch = Collection.movies;
        return  wannaWatch.get(movieNumberToWatch).getName();
    }

    public void youHaveChosenMovie(){
        System.out.println("\n\n");
        System.out.println("You now have following choices: ");
        System.out.println("Press 1 if you want to watch the movie ");
        System.out.println("Press 2 if you want to save the movie to your list");
        Scanner scan1 = new Scanner(System.in);
        int input = scan1.nextInt();
        movieOption(input);
    }

    public void movieOption(int input){
        if (input == 1) {
            System.out.println("The movie is now playing ");
        }else if (input == 2){
            System.out.println("The movie has been added to your list");
        }else {
            System.out.println("Option does not exist, please choose the available options ");
        }
    }

    public ArrayList<Media> search(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the exact name of the movie");

        String searchString = sc.nextLine();
        return fetchSearchResults(searchString);
    }

    public ArrayList<Media> fetchSearchResults(String searchString){
        ArrayList<Media> searchResults = new ArrayList<>();
        for (Media m : Collection.movies){
            if(m.getName().toLowerCase().contains(searchString.toLowerCase()))
            {
                searchResults.add(m);
            }
        }
        return searchResults;
    }

    public static String checkMoviesSearch(String nameOfMovie, ArrayList<Media> searchResults){
        for (Media md : searchResults){
            if (nameOfMovie.equalsIgnoreCase(md.getName())){
                return "Now playing: " + nameOfMovie;
            }
        }
        return "Please enter the correct name of the movie ";
    }

    public void clearTheConsole(){
        for (int i = 0; i < 100; i++){
            System.out.println();
        }
    }
}
