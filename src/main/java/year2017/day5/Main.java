package year2017.day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> instructions = new ArrayList<>();
        List<Integer> instructionsPart2 = new ArrayList<>();
        // Read input
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/inputs/day_05_2017.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                int instruction = Integer.parseInt(line);
                instructions.add(instruction);
                instructionsPart2.add(instruction);
            }

            // Read input[i] = n    countStep += 1
            // If i+1 <= input.size
            int countStep = 0;
            for (int i = 0; i < instructions.size(); ) {
                int instruction = instructions.get(i);
                countStep += 1;
                if (instruction == 0) {
                    instructions.set(i, instructions.get(i) + 1);
                } else {
                    instructions.set(i, instructions.get(i) + 1);
                    i += instructions.get(i) - 1;
                    if ( i > instructions.size()-1) {
                        System.out.println("Part 1: il faut " + countStep + " étapes");

                    }
                }
            }
            int countStepPart2 = 0;
            for (int i = 0; i < instructionsPart2.size(); ) {
                int instructionPart2 = instructionsPart2.get(i);
                countStepPart2 += 1;
                if (instructionPart2 == 0) {
                    instructionsPart2.set(i, instructionsPart2.get(i) + 1);
                } else {
                    if (instructionsPart2.get(i)<3){
                        instructionsPart2.set(i, instructionsPart2.get(i) +1);
                        i += instructionsPart2.get(i) - 1;
                    }
                    else {
                        instructionsPart2.set(i, instructionsPart2.get(i) -1);
                        i += instructionsPart2.get(i) + 1;
                    }

                    }
                if (i > instructionsPart2.size() - 1) {
                    System.out.println("Part 2: il faut " + countStepPart2 + " étapes");
                }
            }
                // read input[i+n]  countStep += 1
            // input[i] +=1
            // else print countStep

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
