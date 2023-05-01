public abstract class Media {
    public final String name;
    public final String year;
    public final double rating;

    public String getName(){
        return this.name;
    }

    public Media(String name, String year, double rating) {
        this.name = name;
        this.year = year;
        this.rating = rating;


    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {

        return "Media{" +
                ", name='" + name + '\'' +
                ", year='" + year + '\'' +
                ", rating=" + rating +
                '}';
    }

}



