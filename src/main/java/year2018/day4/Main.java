package year2018.day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/inputs/day_04_2018b.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                lines.add(line);
            }

            // Order input by date
            lines.sort(Comparator.comparing(Main::extractDateTime));

            for (String orderedLine : lines) {
                System.out.println(orderedLine);
            }

            // Parse input
                // Get date
                // If guard line => Get guard ID
                    // guard ID = ID
                    // SleppPattern char[60]
                    // Start at time from Guard line
                    // If line Sleep file from Guard min to sleep min-1 with A (awake)
                    // If line Wake up fil from Sleep min to Wake up min -1 with S (sleep)
                    // If guard line
                        // create previous guard (date ID SleepPattern)
                        // gaurd ID = ID


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String extractDateTime(String line) {
        int startIndex = line.indexOf('[');
        int endIndex = line.indexOf(']');
        return line.substring(startIndex + 1, endIndex);
    }
}
