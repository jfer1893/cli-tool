package clitool;

import java.util.ArrayList;
import java.util.List;

public class FetchCommand {
    public static List<String> fetchFromConfig() {
        // Here you would implement logic to fetch URLs from configured websites
        // For demonstration purposes, let's return a sample list of URLs

        List<String> urlSample = new ArrayList<>(List.of(
                "https://www.google.pt/",
                "https://www.mercedes-benz.io/",
                "http://thissitedoesnotexits.xpto"
        ));

        return urlSample;
    }

    public static void fetchAndSave(String[] args) {
        List<String> urls = fetchFromConfig();
        AvailableChecker.checkAndSaveAvailability(urls, args);
    }
}
