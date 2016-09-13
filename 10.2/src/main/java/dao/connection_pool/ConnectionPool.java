package dao.connection_pool;

import java.sql.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Аня on 13.09.2016.
 */
public class ConnectionPool {

    private String driver;
    private String url;
    private String user;
    private String password;
    private int poolSize;

    private Connection connection;

    private BlockingQueue<Connection> connectionPool;
    private BlockingQueue<Connection> usedConnections;

    public ConnectionPool() {
        driver = ResourceManager.getValues(ResourceManager.DRIVER);
        url = ResourceManager.getValues(ResourceManager.URL);
        user = ResourceManager.getValues(ResourceManager.USER);
        password = ResourceManager.getValues(ResourceManager.PASSWORD);
        poolSize = Integer.parseInt(ResourceManager.getValues(ResourceManager.POOLSIZE));
    }

    public void initPool() {
        try {
            connectionPool = new ArrayBlockingQueue<Connection>(poolSize);
            usedConnections = new ArrayBlockingQueue<Connection>(poolSize);
            Class.forName(driver);
            for (int i = 0; i < poolSize; i++) {
                connection = DriverManager.getConnection(url, user, password);
                connectionPool.add(connection);
            }
        } catch (ClassNotFoundException|SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection getConnection() {
        Connection con = null;
        try {
            con = connectionPool.take();
            connectionPool.remove(con);
            usedConnections.add(con);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return con;
    }

    public void returnConnection(Connection con){
        usedConnections.remove(con);
        connectionPool.add(con);
    }

    public void closeConections() {
        try {
            for (Connection con : connectionPool) {
                if(!con.getAutoCommit()){
                    con.commit();
                }
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeResultSet(ResultSet rs){
        try{
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeStatement(Statement statement){
        try{
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
