import java.io.*;

/**
 * Created by Аня on 25.08.2016.
 */
public class ToUTF16 {
    static void convert(String before, String after) {
        String readedString;
        try {
            BufferedReader inFile = new BufferedReader(new FileReader(before));
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(after), "UTF16"));
            while ((readedString = inFile.readLine()) != null) {
                out.write(readedString);
            }
            inFile.close();
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("Can not find file");
        } catch (UnsupportedEncodingException e) {
            System.out.println("Unsupported encoding");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
