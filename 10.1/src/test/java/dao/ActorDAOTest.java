package dao;

import model.actor.Actor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Аня on 10.09.2016.
 */
public class ActorDAOTest {

    Connection connection;
    ActorDAO actorDAO;
    Actor newActor;

    @Before
    public void setConnection() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        connection = SQLConnection.getInstance().getConnection();
        actorDAO = new ActorDAO(connection);
    }

    @Before
    public void createActor() {
        newActor = new Actor("Stepan", "Neronov",20, "opera","Alexandrinskiy");
    }

    @After
    public void close() throws SQLException {
        connection.close();
    }

    @Test
    public void updateTest(){
        actorDAO.updateTheatre("Kushnarev","Michailovsky");
        assertEquals(1, actorDAO.select("Michailovsky").size());
    }

    @Test
    public void selectTest() {
        assertEquals(1, actorDAO.select("Mariinsky").size());
    }

    @Test
    public void insertTest(){
        //actorDAO.insert(newActor);
        assertEquals(3,actorDAO.select("Alexandrinskiy").size());
    }

    @Test
    public void deleteTest(){
        actorDAO.deleteTable("genre");
    }
}
