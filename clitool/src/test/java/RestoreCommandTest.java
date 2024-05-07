import clitool.RestoreCommand;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RestoreCommandTest {
    @Test
    public void testRestore() throws IOException {
        // Create temporary test file
        Path tempFile = Files.createTempFile("test_restore", ".txt");
        List<String> testData = List.of("https://example.com/page1", "https://example.com/page2");

        // Write test data to temporary file
        Files.write(tempFile, testData);

        // Call restore method
        RestoreCommand.restore(tempFile.toString());

        // Read the contents of the restored data store file (urls.txt)
        List<String> restoredData = Files.readAllLines(Path.of("urls.txt"));

        // Verify if the restored data matches the test data
        assertEquals(restoredData, testData);

        // Delete temporary test file
        Files.deleteIfExists(tempFile);
    }

    @Test
    public void testRestoreWithInvalidFilePath() {
            ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStreamCaptor));

            // Call restore method with an invalid file path
            RestoreCommand.restore("nonexistent_folder/restore.txt");

            // Verify if the restore operation failed (check console output)
            String consoleOutput = outputStreamCaptor.toString().trim();
            assert(consoleOutput.contains("Invalid restore file: File does not exist invalid extension."));

    }
}
