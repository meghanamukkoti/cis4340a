import java.io.File;

public class FileDeleter {

    public void deleteFile() {
        File someFile = new File("someFileName.txt");
        if (!someFile.delete()) {
            System.err.println("Failed to delete the file.");
        }
    }
}
