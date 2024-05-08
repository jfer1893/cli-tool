package clitool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class LiveCommand {
    public static void live(String[] args) {
        // Default interval: 5 seconds - "Simulate a config file"
        int intervalSeconds = 5;
        int maxExecutions = 5;
        AtomicInteger executionCount = new AtomicInteger(0);


        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(() -> {
            System.out.println("Queries the URLs of all configured website(s)");

            // Reuse the logic from fetch method to query URLs
            FetchCommand.fetchAndSave(args);
            int count = executionCount.incrementAndGet();
            if (count >= maxExecutions) {
                // Cancel the scheduled task
                executor.shutdown();
                System.out.println("Task canceled after " + count + " executions.");
            }
        }, 0, intervalSeconds, TimeUnit.SECONDS);
    }
}
