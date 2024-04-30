import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionExample {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No file specified");
            return;
        }

        File file = null;
        try {
            // Construct the file object
            file = new File(System.getenv("APPDATA") + File.separator + args[0]).getCanonicalFile();
            // Ensure the file path starts with the expected prefix
            if (!file.getPath().toLowerCase().startsWith("c:\\homepath")) {
                System.out.println("Invalid file location");
                return;
            }
            // Attempt to open the file input stream
            try (FileInputStream fis = new FileInputStream(file)) {
                // File opened successfully
                System.out.println("File opened successfully: " + file.getPath());
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
        } catch (IOException e) {
            System.out.println("Error processing file path");
        }
    }
}
