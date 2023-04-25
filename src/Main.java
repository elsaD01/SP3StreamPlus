public class Main {
    public static void main(String[] args) {

        //Here we call the method to read the movie data so the user can pick the specific media they want.
        FileIO fileIO = new FileIO();
        Collection.movies = fileIO.readMovieData();
        TextUI text = new TextUI();
        text.pickMedia(Collection.movies);
    }


    }
}
