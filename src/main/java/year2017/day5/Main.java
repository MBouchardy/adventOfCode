package year2017.day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> instructions = new ArrayList<>();

        // Read input
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/inputs/day_05_2017.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                int instruction = Integer.parseInt(line);
                instructions.add(instruction);
            }
            List<Integer> instructionsPart2 = new ArrayList<>(instructions);
            // Read input[i] = n    countStep += 1
            // If i+1 <= input.size
            int countStep = 0;
            int i = 0;
            while (i < instructions.size()) {
                int instruction = instructions.get(i);
                countStep++;
                instructions.set(i, instructions.get(i) + 1);
                if (instruction != 0) {
                    i += instructions.get(i) - 1;
                    // If exit from left
                    if (i < 0) {
                        break;
                    }

                }
            }
            System.out.println("Part 1: il faut " + countStep + " étapes");

            int countStepPart2 = 0;
            int y = 0;
            while (y < instructionsPart2.size()) {
                int instructionPart2 = instructionsPart2.get(y);
                countStepPart2++;
                if (instructionsPart2.get(y) < 3 || instructionPart2 == 0) {
                    instructionsPart2.set(y, instructionsPart2.get(y) + 1);
                    y += instructionsPart2.get(y) - 1;
                } else {
                    instructionsPart2.set(y, instructionsPart2.get(y) - 1);
                    y += instructionsPart2.get(y) + 1;
                }
                // Test if exit from left
                if (y < 0) {
                    break;
                }
            }
            System.out.println("Part 2: il faut " + countStepPart2 + " étapes");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
