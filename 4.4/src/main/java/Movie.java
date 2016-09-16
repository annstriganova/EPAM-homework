import java.util.Arrays;

/**
 * Created by Аня on 16.09.2016.
 */
public class Movie implements java.io.Serializable{
    private String name;
    private String[] actors;

    public Movie(String name, String[] actors) {
        this.name = name;
        this.actors = actors;
    }

    public String getName() {
        return name;
    }

    public String[] getActors() {
        return actors;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActors(String[] actors) {
        this.actors = actors;
    }

    public Movie() {}

    /* @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", actors=" + Arrays.toString(actors) +
                '}';
    }

    public void getInfo(){
        System.out.println(this.toString());
    }*/
}
