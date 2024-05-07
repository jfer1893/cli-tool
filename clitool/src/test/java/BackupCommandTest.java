import clitool.BackupCommand;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BackupCommandTest {
    @Test
    public void testBackup() throws IOException {
        // Create temporary test file
        Path tempFile = Files.createTempFile("test_backup", ".txt");

        // Call backup method
        BackupCommand.backup(tempFile.toString());

        // Verify if the backup file exists
        assertTrue(Files.exists(tempFile));

        // Delete temporary test file
        Files.deleteIfExists(tempFile);
    }
}
