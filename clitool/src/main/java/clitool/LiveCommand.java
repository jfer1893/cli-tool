package clitool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LiveCommand {
    public static void live(String[] args) {
        // Default interval: 5 seconds - "Simulate a config file"
        int intervalSeconds = 5;
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(() -> {
            // Reuse the logic from fetch method to query URLs
            FetchCommand.fetchAndSave(args);
        }, 0, intervalSeconds, TimeUnit.SECONDS);
    }
}
