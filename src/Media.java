public abstract class Media {
    public String name;
    public int releaseYear;
    public String rating;
    public String genre;
    public int age;

    public Media(String name, int releaseYear, String rating, String genre, int age) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.genre = genre;
        this.age = age;
    }

}
