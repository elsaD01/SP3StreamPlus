public abstract class Media {
    public String name;
    public int releaseYear;
    public double rating;
    public String genre;
    public int age;

    public Media(String name, int releaseYear, double rating, String genre, int age) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.genre = genre;
        this.age = age;
    }

    public  abstract int releaseDate();
    public  abstract double rating();
    public abstract String genre();
    public abstract int age ();

    }

