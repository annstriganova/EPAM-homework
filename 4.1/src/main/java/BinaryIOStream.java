import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Аня on 25.08.2016.
 */
class BinaryIOStream {

    private static Pattern getPattern() {
        return Pattern.compile("byte|short|int|long|char|float|double|boolean|if|else|switch|" +
                "case|default|while|do|break|continue|for|try|catch|finally|throw|throws|private|protected|" +
                "public|import|package|class|interface|extends|implements|static|final|void|abstract|native|" +
                "new|return|this|super|synchronized|volatile|const|goto|instanceof|enum|assert|transient|strictfp");
    }

    /**
     * Search keywords in the specified file.
     * <p>
     * Searches keywords in the specified file, writes them and their quantity to keyWords.txt.
     *
     * @param fileName name of specified file
     * @exception  FileNotFoundException if specified file does not exist
     * @exception  IOException if something wrong with I/O
     */

    static void keywordsSearcher(String fileName) {
        try {

            BufferedInputStream inFile = new BufferedInputStream(new FileInputStream(fileName));
            int readedBytes;
            StringBuffer stringsFromPretty = new StringBuffer();

            while ((readedBytes = inFile.read()) != -1) {
                stringsFromPretty.append((char) readedBytes);
            }
            inFile.close();

            Matcher m = getPattern().matcher(stringsFromPretty);
            FileOutputStream outFile = new FileOutputStream("keyWords.txt");
            String stringFromBuffer;
            int count = 0;

            while (m.find()) {
                stringFromBuffer = stringsFromPretty.substring(m.start(), m.end()) + " ";
                outFile.write(stringFromBuffer.getBytes());
                count++;
            }

            String words = "Найдено ключевых слов: " + count;
            outFile.write(words.getBytes());
            outFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("Не нашёл файл");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
            e.printStackTrace();
        }
    }
}
