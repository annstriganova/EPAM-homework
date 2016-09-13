package dao;

import dao.connection_pool.ConnectionPool;
import model.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.assertEquals;

/**
 * Created by Аня on 13.09.2016.
 */
public class BookDAOTest {

    Connection connection;
    private Book book, anotherBook;
    private BookDAO bookDAO;
    private ConnectionPool connectionPool;

    @Before
    public void setUp() {
        book = new Book("Gone with the wind", "M. Mitchel");
        anotherBook = new Book(2, "War", "Tolstoy");
        connectionPool = new ConnectionPool();
        connectionPool.initPool();
        connection = connectionPool.getConnection();
        bookDAO = new BookDAO(connection);
    }

    @After
    public void close() {
        connectionPool.returnConnection(connection);
        connectionPool.closeConections();
    }

    @Test
    public void addTest() {
        bookDAO.add(book);
        assertEquals(1, bookDAO.get().size());
    }

    @Test
    public void updateNameTest() {
        bookDAO.add(anotherBook);
        bookDAO.updateName(anotherBook, "War and peace");
        assertEquals("War and peace", bookDAO.getName(anotherBook));
    }

    @Test
    public void updateAuthorTest() {
        bookDAO.updateAuthor(anotherBook, "L.Tolstoy");
        assertEquals("L.Tolstoy", bookDAO.getAuthor(anotherBook));
    }

    @Test
    public void deleteBookTest(){
        bookDAO.deleteBook(book);
        assertEquals(null, bookDAO.getName(book));
        assertEquals(null, bookDAO.getAuthor(book));
    }
}
