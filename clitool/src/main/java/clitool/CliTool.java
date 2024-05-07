package clitool;
import java.util.Arrays;
public class CliTool {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a command.");
            return;
        }

        String command = args[0];
        switch (command) {
            case "fetch":
                FetchCommand.fetchAndSave(args);
                break;
            case "live":
                LiveCommand.live(args);
                break;
            case "history":
                if (args.length > 1) {
                    HistoryCommand.history(Arrays.copyOfRange(args, 1, args.length));
                } else {
                    HistoryCommand.history();
                }
                break;
            case "backup":
                if (args.length > 1) {
                    BackupCommand.backup(args[1]);
                } else {
                    System.out.println("Please provide a file path for backup.");
                }
                break;
            case "restore":
                if (args.length > 1) {
                    RestoreCommand.restore(args[1]);
                } else {
                    System.out.println("Please provide a file path for restore.");
                }
                break;
            default:
                System.out.println("Unknown command. Available commands: fetch, live, history, backup, restore");
        }
    }
}