import java.io.BufferedReader;
import java.io.InputStreamReader;

// Utility class for command execution
class CommandExecutor {
    public static void execute(String command) throws Exception {
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
        process.waitFor();
    }
}
