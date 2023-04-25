public class Movies extends Media{

    public String name;
    public String movieSeries;
    public double rating;
    public String genre;
    public int age;


    public Movies(String name, int releaseYear, double rating, String genre, int age) {
        super(name, releaseYear, rating, genre, age);
        this.name = name;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.genre = genre;
        this.age = age;
    }


    @Override
    public int releaseDate() {
        return releaseYear;
    }

    @Override
    public double rating() {
        return rating;
    }

    @Override
    public String genre() {
        return genre;
    }

    @Override
    public int age() {
        return age;
    }







    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
