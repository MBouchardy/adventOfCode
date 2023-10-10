package year2016.day6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // Read input
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/inputs/day_06_2016.txt"))) {
            String line;
            List<String> signals = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                signals.add(line);
            }
            // Get signals filter by columns
            List<List<Character>> columns = getColumns(signals);

            // Get most Frequent and less frequent char by columns
            List<Character> mostFrequentCharactersByColumns = findMostFrequentCharacterByColumns(columns);
            List<Character> lessFrequentCharactersByColumns = findLessFrequentCharacterByColumns(columns);

            // Print corrected messages
            String correctedMessage = getCorrectedMessage(mostFrequentCharactersByColumns);
            String correctedMessage2 = getCorrectedMessage(lessFrequentCharactersByColumns);
            System.out.println("Le message de la partie 1 est : " + correctedMessage
                    + " et le message de la partie 2 est: " + correctedMessage2);

        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ignored) {
        }
    }

    private static String getCorrectedMessage(List<Character> caracterList) {

        return caracterList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    private static List<Character> findMostFrequentCharacterByColumns(List<List<Character>> columns) {

        // Get most frequent character
        return columns.stream()
                .map(column -> column.stream()
                        .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                        .entrySet()
                        .stream()
                        .max(Map.Entry.comparingByValue())
                        .map(Map.Entry::getKey)
                        .orElse(null))
                .toList();
    }

    private static List<Character> findLessFrequentCharacterByColumns(List<List<Character>> columns) {
        // Get most frequent character
        return columns.stream()
                .map(column -> column.stream()
                        .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                        .entrySet()
                        .stream()
                        .min(Map.Entry.comparingByValue())
                        .map(Map.Entry::getKey)
                        .orElse(null))
                .toList();
    }

    private static List<List<Character>> getColumns(List<String> signals) {
        // Convert signal list in columns.
        return IntStream.range(0, signals.get(0).length())
                .mapToObj(i -> signals.stream()
                        .map(s -> s.charAt(i))
                        .collect(Collectors.toList()))
                .toList();
    }
}

