package year2020.day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/inputs/day_03_2020.txt"))) {
            String line;
            StringBuilder inputLines = new StringBuilder();

            while ((line = br.readLine()) != null) {
                inputLines.append(line);
                inputLines.append(System.lineSeparator());
            }
            String[] lines = inputLines.toString().split("\n");
            // Creat map with input
            char[][] areaMap = creatAreaMap(lines);
            // Follow the toboggan slope
            List<Character> path = rideToboggan(areaMap);
            // Count number of tree met
            int numberOfTree = countTree(path);

            System.out.println("il y a " + numberOfTree + " arbres");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static char[][] creatAreaMap(String[] lines) {
        //init size
        int numRows = lines.length;
        int numbColumns = lines[0].length();

        // fill area map
        char[][] areaMap = new char[numRows][numbColumns];
        for (int i = 0; i < numRows; i++) {
            String line = lines[i];
            for (int j = 0; j < numbColumns; j++) {
                areaMap[i][j] = line.charAt(j);
            }
        }
        return areaMap;
    }

    public static List<Character> rideToboggan(char[][] areaMap) {
        int x = 0;
        int y = 0;
        int maxColumnsLength = areaMap[0].length;
        List<Character> path = new ArrayList<>();
        for (; x < (areaMap.length); x++) {
            //Add toboggan path, starting point doesn't count
            if (x > 0) {
                path.add(areaMap[x][y]);
            }
            // border map management
            switch (y) {
                case 29 -> y = 1;
                case 30 -> y = 2;
                case 31 -> y = 3;
                default -> y += 3;
            }
        }
        return path;
    }

    public static int countTree(List<Character> path) {
        int numberOfTree = 0;
        for (Character character : path) {
            if (character == '#') {
                numberOfTree += 1;
            }
        }
        return numberOfTree;
    }

}
