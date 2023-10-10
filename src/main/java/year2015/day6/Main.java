package year2015.day6;

import year2015.day_3b.Coordinate;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        // Read input
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/inputs/day_06_2015.txt"))) {
            String line;
            List<Instruction> instructions = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                //Get instruction list
                Instruction instruction = parseInstructions(line);
                instructions.add(instruction);
            }

            //Apply instructions part 1:
            LightGrid lightGrid = new LightGrid();
            for (Instruction instruction : instructions) {
                lightGrid = lightGrid.applyInstruction(instruction, lightGrid);
            }
            // Count light on
            int numberOfLightOn = lightGrid.countLigthOn(lightGrid);

            //Apply instructions part 2:
            VariableLightGrid variableLightGrid = new VariableLightGrid();
            for (Instruction instruction : instructions) {
                variableLightGrid = variableLightGrid.applyInstructionPart2(instruction, variableLightGrid);

            }
            // Count light brightness
            int brightness = variableLightGrid.countLightBrightness();

            System.out.println("le nombre d'ampoules allumées est: " + numberOfLightOn);
            System.out.println("l'intensité lumineuse de la grille est: " + brightness);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Instruction parseInstructions(String line) {
        Pattern pattern = Pattern.compile("^(toggle|turn on|turn off) (\\d+),(\\d+) through (\\d+),(\\d+)$");
        Matcher matcher = pattern.matcher(line);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Ligne non valide : " + line);
        }
        String action = matcher.group(1);
        int x1 = Integer.parseInt(matcher.group(2));
        int y1 = Integer.parseInt(matcher.group(3));
        int x2 = Integer.parseInt(matcher.group(4));
        int y2 = Integer.parseInt(matcher.group(5));

        Coordinate firstLight = new Coordinate(x1, y1);
        Coordinate lastLight = new Coordinate(x2, y2);

        return new Instruction(action, firstLight, lastLight);
    }
}




