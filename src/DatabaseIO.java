
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseIO implements IIO {
    //ArrayList<Media> movies = new ArrayList<>();
    // database URL
    static final String DB_URL = "jdbc:mysql://localhost/sp3plus ";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "x";
    static ArrayList<Media> movies = new ArrayList<>();

 //   private List<Media> movies = readMovieData();
    public static ArrayList<Media> readMovieData() {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            //STEP 1: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 3: Execute a query
            System.out.println("Creating statement...");
            String sql = "SELECT id, name, year, category, rating FROM sp3plus.movies";
            stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery(sql);

            //STEP 4: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name

                int id = rs.getInt("id");
                // String name = rs.getString("Name");
                String movieName = rs.getString("Name");
                //int year = rs.getInt("Year");
                int movieYear = rs.getInt("Year");
                String categoryArray = rs.getString("Category");
                double movieRating = rs.getDouble("Rating");
                //System.out.println(id + " " + movieName + " " + movieYear + " " + categoryArray + " " + movieRating);
                Movies movie = new Movies(id, movieName, movieYear,categoryArray, movieRating);
                movies.add(movie);

            }
            //STEP 5: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

        return movies;
    }

    @Override
    public void saveUserData() {

    }

    @Override
    public void savewatchedlist() {

    }
}