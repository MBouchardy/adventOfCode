package year2017.day6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        // Read input
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/inputs/day_06_2017.txt"))) {
            String line;
            Set<MemoryBank> memoryBanksState = new HashSet<>();
            Set<MemoryBank> memoryBanksState2 = new HashSet<>();
            List<Integer> memoryBlocks = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                String[] blocks = (line.split("\\s+"));
                // Creat MemoryBank
                for (String block : blocks) {
                    int memoryBlock = Integer.parseInt(block);
                    memoryBlocks.add(memoryBlock);
                }
            }
            MemoryBank memoryBank = new MemoryBank(memoryBlocks);

            //Reallocate block until find existing state
            memoryBank.rearrangeBlocks();
            while (memoryBanksState.add(memoryBank)) {
                memoryBank.rearrangeBlocks();
            }
            System.out.println("il faut " + (memoryBanksState.size() + 1) + " recombinaison pour la partie 1");

            //Part 2
            memoryBanksState2.add(memoryBank);
            MemoryBank memoryBank2 = new MemoryBank(memoryBank.getMemoryBlock());
            memoryBank2.rearrangeBlocks();
            while (memoryBanksState2.add(memoryBank2)) {
                memoryBank2.rearrangeBlocks();
            }
            System.out.println("il faut " + (memoryBanksState2.size()) + " recombinaison pour la partie 2");

        } catch (IOException e) {
            throw new FileNotFoundException();
        }
    }
}
