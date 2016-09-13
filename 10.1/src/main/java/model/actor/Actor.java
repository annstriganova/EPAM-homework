package model.actor;

/**
 * Created by Аня on 09.09.2016.
 */
public class Actor {

    private long id;
    private String name;
    private String lastname;
    private int age;
    private String genre;
    private String theatreName;
    private int adressStreet;
    private int adressHouse;
    private String gender;
    private int startDate;

    public Actor(long id, String name, String lastname, String theatreName) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.theatreName = theatreName;
    }

    public Actor(long id, String name, String lastname, int age,
                 String genre, String theatreName, int adressStreet,
                 int adressHouse, String gender, int startDate) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.genre = genre;
        this.theatreName = theatreName;
        this.adressStreet = adressStreet;
        this.adressHouse = adressHouse;
        this.gender = gender;
        this.startDate = startDate;
    }

    public Actor(String name, String lastname, int age,
                 String genre, String theatreName) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.genre = genre;
        this.theatreName = theatreName;
    }


    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public int getAdressStreet() {
        return adressStreet;
    }

    public void setAdressStreet(int adressStreet) {
        this.adressStreet = adressStreet;
    }

    public int getAdressHouse() {
        return adressHouse;
    }

    public void setAdressHouse(int adressHouse) {
        this.adressHouse = adressHouse;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }
}
