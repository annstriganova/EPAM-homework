/**
 * Created by Аня on 26.08.2016.
 */
public class User {
    public static void main(String[] args) {
        FileInspector.createFile("C:\\Users\\Аня\\IdeaProjects\\5.1", "goodFile.txt");
        FileInspector.getFilesFromDirectory("C:\\Users\\Аня\\IdeaProjects");
        FileInspector.writeToFile("goodFile.txt","Bla");
        FileInspector.parseFile("goodFile.txt");
        FileInspector.deleteFile("C:\\Users\\Аня\\IdeaProjects\\5.1", "goodFile.txt");
    }
}
