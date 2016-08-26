import java.io.*;

/**
 * Created by Аня on 26.08.2016.
 */
public class FileInspector {

    public static void createFile(String directory, String fileName) {

        File newFile = new File(directory, fileName);

        try {
            if (newFile.exists()) {
                System.out.println("Файл существует");
                System.exit(0);
            }
            boolean created = newFile.createNewFile();
            if (created) {
                System.out.println("Файл создан");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void deleteFile(String directory, String fileName) {
        File file = new File(directory, fileName);
        if (file.exists()) {
            boolean deleted = file.delete();
            if (deleted) {
                System.out.println("Файл удалён");
            }
        }else{
            System.out.println("Нет такого файла");
        }
    }

    public static void getFilesFromDirectory(String directory) {
        File dir = new File(directory);

        if (dir.isDirectory()) {
            for (File item : dir.listFiles()) {
                if (item.isDirectory()) {
                    System.out.println(item.getName() + "  \tкаталог");
                } else {
                    System.out.println(item.getName() + "\tфайл");
                }
            }
        }
    }


    public static void writeToFile(String filename, String data) {
        File tempFile = new File(filename);
        if (tempFile.exists()) {
            try (BufferedWriter outFile = new BufferedWriter(new FileWriter(tempFile, true))) {
                outFile.write(data + " ");
                System.out.println("Данные добавлены");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Нет такого файла");
            System.exit(0);
        }
    }

    public static void parseFile(String filename) {
        String readedString;
        File tempFile = new File(filename);
        if (tempFile.exists()) {
            try (BufferedReader inFile = new BufferedReader(new FileReader(tempFile))) {
                while ((readedString = inFile.readLine()) != null) {
                    System.out.println(readedString);
                }
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Нет такого файла");
            System.exit(0);
        }
    }
}
