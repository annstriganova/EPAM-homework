package dao;

import model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Аня on 12.09.2016.
 */
public class BookDAO {

    private Connection connection;
    private String query;

    public BookDAO(Connection connection) {
        this.connection = connection;
    }

    public void add(Book book) {
        query = "INSERT INTO Library.books (name, author) VALUES(?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Book> get() {
        List<Book> books = new ArrayList<Book>();
        query = "SELECT * FROM Library.books";
        try(Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                books.add(new Book(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return books;
    }

    public String getName(Book book){
        query = "SELECT*FROM Library.books WHERE book_id="+book.getId();
        String name = null;
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            name = resultSet.getString(2);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
       return name;
    }

    public String getAuthor(Book book){
        query = "SELECT * FROM Library.books WHERE book_id="+book.getId();
        String author = null;
        try(Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            author = resultSet.getString(3);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return author;
    }

    public void updateName(Book book, String newName){
        query = "UPDATE Library.books SET name="+"'"+newName+"'"+"WHERE book_id="+book.getId();
        try(Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateAuthor(Book book, String newAuthor){
        query = "UPDATE Library.books SET author="+"'"+newAuthor+"'"+"WHERE book_id="+book.getId();
        try(Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteBook(Book book){
        query = "DELETE FROM Library.books WHERE name="+"'"+book.getName()+"'";
        try(Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
