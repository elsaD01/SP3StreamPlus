public abstract class Media {
    public final int id;
    public final String name;
    public final String categoryArray;
    public final int year;
    public final double rating;

    public String getName(){
        return this.name;
    }

    public Media(int id,String name, int year,String categoryArray, double rating) {
        this.name = name;
        this.year = year;
        this.categoryArray = categoryArray;
        this.rating = rating;
        this.id=id;


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



