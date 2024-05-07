package clitool;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class RestoreCommand {
    public static void restore(String file) {
        // Validate restore file
        File restoreFile = new File(file);
        if (!restoreFile.exists() || !restoreFile.isFile()) {
            System.out.println("Invalid restore file: File does not exist invalid extension.");
            return;
        }

        // Read file
        List<String> restoredUrls = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Validate line format here if needed
                restoredUrls.add(line);
            }
        } catch (IOException e) {
            System.err.println("Failed to read data from " + file + ": " + e.getMessage());
            return;
        }

        // Read - urls.txt
        List<String> existingUrls = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("urls.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                existingUrls.add(line);
            }
        } catch (IOException e) {
            System.err.println("Failed to read existing data store: " + e.getMessage());
            return;
        }

        // Merge
        existingUrls.addAll(restoredUrls);

        try {
            Path targetPath = Path.of("urls.txt");
            Files.write(targetPath, existingUrls);
            System.out.println("Data merged from " + file + " into data store.");
        } catch (IOException e) {
            System.err.println("Failed to merge data from " + file + " into data store: " + e.getMessage());
        }
    }
}
