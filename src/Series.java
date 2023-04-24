public class Series extends Media{
    public int episode;
    public int season;
    public String genre;
    public int releaseYear;
    public String rating;
    public int age;


    public Series(int releaseYear, String rating, String genre, int age) {
        super(releaseYear, rating, genre, age);
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.genre = genre;
        this.age = age;
    }

    public int getEpisode() {
        return episode;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
