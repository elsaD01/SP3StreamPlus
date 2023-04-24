public class Movies extends Media{

    public String name;
    public String movieSeries;
    public String rating;
    public String genre;
    public int age;



    public Movies(String name, int releaseYear, String rating, String genre, int age) {
        super(name, releaseYear, rating, genre, age);
        this.name = name;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.genre = genre;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }







}
