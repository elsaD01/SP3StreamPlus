import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collection;


public class TextUI {

    Scanner scanner;
    UserHandler userhandler;

    public TextUI(UserHandler userHandler) {
        this.userhandler = userHandler;
        this.scanner = new Scanner(System.in);


    }
    public String getUserInput() {
        System.out.println("Welcome to Chills Stream ");
        System.out.println("Press 1 to login or press 2 to sign up ");
        return scanner.nextLine();


    }

    public void logIn() {
        System.out.println("Enter your username ");
        String username = scanner.nextLine();

        System.out.println("Enter your password ");
        String password = scanner.nextLine();
        if (userhandler.login(password, username)) {
            System.out.println("Welcome to Chills " + username);
            System.out.println("\n\n");


        } else {
            int attempts = 0;
            while (attempts < 3) {
                System.out.println("Password is incorrect or username is invalid");
                System.out.println("Enter your username");
                username = scanner.nextLine();
                System.out.println("Enter your password again");
                password = scanner.nextLine();
                if (userhandler.login(username, password)) {
                    System.out.println("Welcome to Chill  " + username);
                    break;
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
        System.out.println("Please create your username: ");
        String username = scanner.nextLine();
        System.out.println("Please create your password: ");
        String password = scanner.nextLine();

        if (userhandler.createUser(fullname, username, password)) {
            System.out.println("Welcome to Chills  " + username);
            System.out.println("\n\n");

        } else {
            System.out.println("Username or password cannot be used, please login or sign up ");
        }
    }

    public void pickMedia(ArrayList<Media> medias){

        TextUI textUI = new TextUI(userhandler);
        System.out.println("Menu: Choose type of media: ");

        Scanner scan = new Scanner(System.in);
        System.out.println("1-Movies");
        System.out.println("2-Series");
        System.out.println("3-Search");
        System.out.println("4-Watched");
        System.out.println("5-Saved");
        System.out.println("6-Search after rating");
        int input = scan.nextInt();

        if(input == 1){
            System.out.println("You choose movies, here's some options");
            for(int i = 0; i < medias.size(); i++){

                String movieS = i+ " - " + medias.get(i).getName();
                System.out.println(movieS);
            }
            chooseMovie();
            youHaveChosenMovie();

        }

        else if (input == 2) {
            System.out.println("You choose series, here's some options");
        }
        else if (input == 3){
            ArrayList<Media> searchResults = search();
            for(Media m : searchResults){
                System.out.println(m);
            }


           // har fået en liste over de film som macther søgning på dele af navnet og derefter skal du skrive det korrekte navn
           Scanner src = new Scanner(System.in);
            System.out.println("Please enter the movies full name to start the movie");
            String nameOfMovie = src.nextLine();
            System.out.println(checkMoviesSearch(nameOfMovie, searchResults));
        }

        else if (input == 4) {
            System.out.println("You choose your watched list: ");
        }

        else if (input == 5) {
            System.out.println("You choose your saved list: ");
        }
        else if (input == 6) {
            System.out.println("You choose movie rating ");
            System.out.println("here are the movies that have rating higher than 8.5");

            for(Media m: CollectionLab.movies) {

                if(m.getRating() >= 8.5) {
                    System.out.println(m.getName() + " - " + m.getRating());
                }

            }


        }
    }

    public void chooseMovie(){
        try {
            Scanner cs = new Scanner(System.in);
            System.out.println("\n\n");
            System.out.println("Please press the number of the movie you want to watch");
            int movieNumberToWatch = cs.nextInt();
            System.out.println("you have chosen " + choseResults(movieNumberToWatch));
        }
        catch(Exception e){
            System.out.println("you cannot write letters, write only number, you can try again now   ");
            Scanner cs = new Scanner(System.in);
            System.out.println("\n\n");
            System.out.println("Please press the number of the movie you want to watch");
            int movieNumberToWatch = cs.nextInt();
            System.out.println("you have chosen " + choseResults(movieNumberToWatch));
        }
    }

    public String choseResults(int movieNumberToWatch){
        ArrayList<Media> wannaWatch = CollectionLab.movies;
        return  wannaWatch.get(movieNumberToWatch).getName();
    }

    public void youHaveChosenMovie(){
        System.out.println("\n");
        System.out.println("You now have following choices: ");
        System.out.println("Press 1 if you want to watch the movie ");
        System.out.println("Press 2 if you want to save movies to your list");
        Scanner scan1 = new Scanner(System.in);
        int input = scan1.nextInt();
        movieOption(input);
    }

    public void movieOption(int input){
        Scanner scan2 = new Scanner(System.in);
        if (input == 1) {
            System.out.println("The movie is now playing ");

        } else if (input == 2) {
            System.out.println("Enter the name of the movie you want to save: ");
            String movieName = scan2.nextLine();
            try {
                FileWriter csvWriter = new FileWriter("data/SavedMoviesList.csv", true);
                csvWriter.append(movieName);
                csvWriter.append("\n");
                csvWriter.flush();
                csvWriter.close();
                System.out.println("The movie has been added to your list.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("Option does not exist, please choose the available options ");
        }
    }

    public ArrayList<Media> search(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter part of the moviename");

        String searchString = sc.nextLine();
        return fetchSearchResults(searchString);
    }

    public ArrayList<Media> fetchSearchResults(String searchString){
        ArrayList<Media> searchResults = new ArrayList<>();
        for (Media m : CollectionLab.movies){
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
    public ArrayList<Media> searchMovieAfterRating() {
        ArrayList<Media> searchRating = new ArrayList<>();
        for (Media rating : CollectionLab.movies){
            if (rating.getRating() < 8.5) {
                searchRating.add(rating);
            }
        }
        return searchRating;
    }


}