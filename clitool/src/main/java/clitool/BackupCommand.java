package clitool;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BackupCommand {
    public static void backup(String backupFile) {
        try {
            Path sourcePath = Path.of("urls.txt");
            Path targetPath = Path.of(backupFile);
            Files.copy(sourcePath, targetPath);
            System.out.println("Backup created successfully at: " + backupFile);
        } catch (IOException e) {
            System.err.println("Failed to create backup: " + e.getMessage());
        }
    }
}
