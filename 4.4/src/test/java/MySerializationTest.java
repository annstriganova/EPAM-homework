import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Аня on 16.09.2016.
 */
public class MySerializationTest {

    private Movie movie, movie2;
    private ArrayList<Movie> moviess = new ArrayList<>();

    @Before
    public void setUp() {
        String[] actors1 = {"Natalie Portman", "Mila Counis"};
        String[] actors = {"Natalie Portman", "Heiden Christensen"};
        movie = new Movie("Black swan", actors1);
        movie2 = new Movie("Star Wars",actors);
        /**
         * Anna, I understand, it would be better to write special method makeMoviesList(), but I'm to lazy:)
         */
        moviess.add(movie);
        moviess.add(movie2);
    }

    @Test
    public void writeFileTest() {
        MySerialization.writeMovies(moviess, "serialized.txt");
    }

    @Test
    public void readFile() {
        ArrayList<Movie> list = MySerialization.readFile("serialized.txt");
        assertEquals(2, list.size());
    }

    @Test
    public void editMovie(){
        ArrayList<Movie> list = MySerialization.readFile("serialized.txt");
        MySerialization.editMovie(list,"Black swan", "Super Massive Black Hole");
        MySerialization.writeMovies(list, "serialized.txt");
        assertEquals("Super Massive Black Hole",MySerialization.readFile("serialized.txt").get(0).getName());
    }
}
