package _java._se._03._locale;

import java.util.*;

/**
 * Created by Аня on 18.08.2016.
 */
public class MyBundle {

    private static ResourceBundle bundle, anotherBundle;
    private static Set<String> keys;
    private static int n;
    private static Locale locale;


    public static void getLocale() {

        System.out.println("Choose the language: 1. Russian 2. English 0. Exit" + "\n");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        if (n == 1) {
            locale = new Locale("RU", "ru");
        } else {
            if (n == 2) {
                locale = new Locale("EN", "UK");
            } else {
                System.exit(0);
            }
        }
        bundle = ResourceBundle.getBundle("questions", locale);
        getMyKeys();
        setAnswers();

    }

    public static void getMyKeys() {
        keys = new HashSet<String>(Collections.list(bundle.getKeys()));
        for (String key : keys) {
            System.out.println(bundle.getString(key));
        }
    }

    public static void setAnswers() {
        anotherBundle = ResourceBundle.getBundle("answers", locale);
        Scanner scanner = new Scanner(System.in);
        while ((n = scanner.nextInt()) != '0') {
            if((n<1)||(n>3)){
                System.out.println("Incorrect number!");
                System.exit(0);
            }
            System.out.println(anotherBundle.getString(String.valueOf(n)));
        }
    }

}
