public class Series extends Media{

    public String name;
    public int episode;
    public int season;
    public String genre;
    public int releaseYear;
    public double rating;
    public int age;
    public Series(String name, int releaseYear, double rating, String genre, int age) {
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


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
