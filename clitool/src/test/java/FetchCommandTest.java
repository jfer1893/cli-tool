import clitool.FetchCommand;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;
public class FetchCommandTest {
    @Test
    public void testFetchUrlsFromConfig() {
        // Test fetchUrlsFromConfig method
        List<String> urls = FetchCommand.fetchFromConfig();
        assertNotNull(urls);
        assertTrue(urls.size() > 0);
    }
}
