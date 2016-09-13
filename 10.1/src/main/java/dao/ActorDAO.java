package dao;

import model.actor.Actor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Аня on 09.09.2016.
 */
public class ActorDAO {

    private String query;
    private Connection connection;

    public ActorDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * Attempt to select all actors' lastnames, who work in <t>theatreName</t> theatre.
     *
     * @param theatreName - name of choosen theatre
     * @return lastNames - list of lastnames work in <t>theatreName</t> theatre.
     */
    public List<String> select(String theatreName) {
        List<String> lastNames = new ArrayList<String>();
        query = "SELECT lastname FROM actors.actor WHERE theatre_name=" + "'" + theatreName + "'";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                lastNames.add(resultSet.getString("lastname"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lastNames;
    }

    public List<Actor> selectAll() {
        query = "SELECT * FROM actors.actor";
        List<Actor> actors = new ArrayList<Actor>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                actors.add(new Actor(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getInt(4), resultSet.getString(5), resultSet.getString(6), resultSet.getInt(7),
                        resultSet.getInt(8), resultSet.getString(9), resultSet.getInt(10)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return actors;
    }

    public void updateTheatre(String updatedActorLastname, String theatreName) {
        query = "UPDATE actors.actor SET theatre_name=" + "'" + theatreName + "'" + " WHERE lastname=" + "'" + updatedActorLastname + "'";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insert(Actor actor) {
        query = "INSERT INTO actors.actor(name, lastname, age, genre, theatre_name) VALUES(?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, actor.getName());
            preparedStatement.setString(2, actor.getLastname());
            preparedStatement.setInt(3, actor.getAge());
            preparedStatement.setString(4, actor.getGenre());
            preparedStatement.setString(5, actor.getTheatreName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteTable(String tableName) {
        query = "DROP TABLE actors."+tableName;
        try (Statement statement = connection.createStatement()){
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
