import java.util.*;

/**
 * Created by Аня on 29.08.2016.
 */
public class PropGetter {

    private static String str;
    private static ResourceBundle bundle;
    private static Map<Object, Object> props = new LinkedHashMap<>();

    public static Map getProp(String fileName) {
        bundle = ResourceBundle.getBundle(fileName);
        Set<String> keys = new HashSet<>(bundle.keySet());
        for (String key : keys) {
            props.put(key, bundle.getObject(key));
        }
        return props;
    }
}

