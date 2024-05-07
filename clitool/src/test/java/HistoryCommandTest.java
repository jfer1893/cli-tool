import org.junit.Test;
import clitool.HistoryCommand;

public class HistoryCommandTest {
    @Test
    public void testHistoryWithPages() {
        // Assuming urls.txt contains some sample data for testing
        String[] pages = {"example.com", "anotherexample.com"};
        HistoryCommand.history(pages);
        // Add assertions here based on expected output or behavior
    }
}
