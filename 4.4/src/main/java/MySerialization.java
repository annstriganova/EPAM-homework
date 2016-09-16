import java.io.*;
import java.util.ArrayList;

public class MySerialization implements java.io.Serializable {

    public static ArrayList<Movie> readFile(String fileName) {

        ArrayList<Movie> movies = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            movies = (ArrayList<Movie>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IO");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }
        return movies;
    }

    public static void writeMovies(ArrayList<Movie> movies, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(movies);
        } catch (IOException e) {
            System.out.println("There is a problem in writeFile()");
        }
    }

    public static void editMovie(ArrayList<Movie> movies, String editedMovie, String newName) {
        for (Movie movie : movies) {
            if (movie.getName().equals(editedMovie)) {
                movie.setName(newName);
            }
        }
    }
}