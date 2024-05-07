package clitool;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
public class AvailableChecker {
    public static boolean isUrlAvailable(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();
            // HTTP status code 200 indicates success
            return responseCode == HttpURLConnection.HTTP_OK;
        } catch (IOException e) {
            return false;
        }
    }

    public static void checkAndSaveAvailability(List<String> urls, String[] args) {
        boolean output;

        // Append results to file or Output the result
        output = args.length > 1 && args[1].equals("output");

        if (args.length > 1 && args[1].equals("output")) {
            var argUrls = Arrays.copyOfRange(args, 2, args.length);
            urls.addAll(Arrays.asList(argUrls));
        }

        try (FileWriter writer = new FileWriter("urls.txt", true)) {
            for (String url : urls) {
                boolean isAvailable = isUrlAvailable(url);
                writer.write(url + " - " + isAvailable + "\n");

                if (output) {
                    System.out.println(url + " - " + isAvailable);
                }

            }
            System.out.println("Fetched URLs along with availability status saved to 'urls.txt' file.");
        } catch (IOException e) {
            System.err.println("Failed to save fetched URLs to file: " + e.getMessage());
        }
    }
}
