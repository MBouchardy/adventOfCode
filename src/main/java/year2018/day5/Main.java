package year2018.day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {

        // Read input
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/inputs/day_05_2018.txt"))) {

            // Creat Polymer
            Polymer polymer1 = new Polymer(reader.readLine());

            // Part1: Size of input polymer after all possible reactions
            int resultPart1 = polymer1.getPolymerSizeAfterReaction().length();
            // Part2: Size of shortest of the 26 modified polymer after all reactions
            String resultPart2 = polymer1.getShortestFullyReactedPolymerSize();

            System.out.println("le résultat 1 est: " + resultPart1);
            System.out.println("le résultat 2 est: " + resultPart2.length());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
