package clitool;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HistoryCommand {
    public static void history(String... pages) {
        // Read the contents of the 'urls.txt' file and write history in a table-like format
        System.out.println("History of gathered data:");
        System.out.println("Website\t\t\t\t\tURL\t\t\t\t\tAvailability");
        try (BufferedReader reader = new BufferedReader(new FileReader("urls.txt"))) {
            String line;
            Set<String> pageSet = new HashSet<>(Arrays.asList(pages));
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" - ");
                if (parts.length == 2) {
                    String url = parts[0];
                    String website = url.split("/")[2]; // Extract website from URL
                    if (pageSet.isEmpty() || pageSet.contains(website)) {
                        System.out.printf("%-30s %-30s %-10s%n", "", url, parts[1]);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to read history from 'urls.txt': " + e.getMessage());
        }
    }
}
