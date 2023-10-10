package year2022.day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/inputs/day_04_2022b.txt"))) {
            String line;
            List<AssignmentPair> assignmentPairList = new ArrayList<>();
            int count = 0;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");


                // Check input ok
                if (parts.length == 2) {
                    // creat Elfs
                    Elf elf1 = Elf.creatElf(parts[0]);
                    Elf elf2 = Elf.creatElf(parts[1]);
                    // Creat AssignmentPair
                    //AssignmentPair assignmentPair = AssignmentPair.creatAssignmentPair(elf1, elf2);
                    AssignmentPair assignmentPair = new AssignmentPair(elf1, elf2);
                    //fill assignmentPairList
                    assignmentPairList.add(assignmentPair);
                }
            }

            // count number of fullyContain pair
            for (AssignmentPair assignmentPair : assignmentPairList) {
                if (AssignmentPair.hasFullyContainAssignment(assignmentPair)) {
                    count++;
                }
            }

            System.out.println("il y a " + count + " paires ");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}