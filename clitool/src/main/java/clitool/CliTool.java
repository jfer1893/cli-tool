package clitool;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class CliTool {

    public static void main(String[] args) throws IOException {
     String command = "";
        do {
            System.out.println("Please provide command " );

            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            String[] arguments = s.split(" ");
            command = arguments[0];
        switch (command) {
            case "fetch":
                FetchCommand.fetchAndSave(arguments);
                break;
            case "live":
                LiveCommand.live(arguments);
                break;
            case "history":
                if (arguments.length > 1) {
                    HistoryCommand.history
                            (Arrays.copyOfRange(arguments, 1, arguments.length));
                } else {
                    HistoryCommand.history();
                }
                break;
            case "backup":
                if (arguments.length > 1) {
                    BackupCommand.backup(arguments[1]);
                } else {
                    System.out.println("Please provide a file path for backup.");
                }
                break;
            case "restore":
                if (arguments.length > 1) {
                    RestoreCommand.restore(arguments[1]);
                } else {
                    System.out.println("Please provide a file path for restore.");
                }
                break;
            case "exit":
                break;
            default:
                System.out.println("Unknown command. Available commands: fetch, live, history, backup, restore");
        }
        } while (!Objects.equals(command, "exit"));
    }
}