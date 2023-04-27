import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {

    ArrayList<Media> movies = new ArrayList<>();

    ArrayList<Media> series = new ArrayList<>();

    CollectionLab collection = new CollectionLab();


    public ArrayList<Media> readMovieData(){
        try{
            Scanner scan = new Scanner(new File("data/MovieData.csv"));
            while (scan.hasNextLine()){
                String line = scan.nextLine();
                String[] lineData = line.split(";");

                String movieName = lineData[0].trim();
                String movieYear = lineData[1].trim();

                ArrayList<String> MovieCategory = new ArrayList<>();
                String[] categoryArray = lineData[2].split(",");
                for(int i = 0; i < categoryArray.length - 1; i++){
                    MovieCategory.add(categoryArray[i]);
                }
                String number = lineData[3].trim();
                number = number.replace(',','.');
                double movieRating = Double.parseDouble(number);

                Movies movie = new Movies(movieName, movieYear, movieRating);
                movies.add(movie);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e + "Option do not exist.Try again");
        }
        return movies;
    }


}
