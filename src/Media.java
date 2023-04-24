public abstract class Media {
    public int releaseYear;
    public String rating;
    public String genre;
    public int age;

    public Media(int releaseYear, String rating, String genre, int age) {
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.genre = genre;
        this.age = age;
    }

}
