package dao.connection_pool;

import java.util.ResourceBundle;

/**
 * Created by Аня on 12.09.2016.
 */
public class ResourceManager {

    public static final String DRIVER = "driver";
    public static final String URL = "url";
    public static final String USER = "user";
    public static final String PASSWORD = "password";
    public static final String POOLSIZE = "poolsize";

    private static ResourceBundle bundle = ResourceBundle.getBundle("connection");

    private ResourceManager() {}

    public static String getValues(String key) {
        return bundle.getString(key);
    }
}
