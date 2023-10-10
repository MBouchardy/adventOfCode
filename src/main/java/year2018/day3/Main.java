package year2018.day3;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/inputs/day_03_2018.txt"))) {
            String line;
            List<Integer>[][] pieceOfFabric = new ArrayList[1000][1000];
            for (int i = 0; i < pieceOfFabric.length; i++) {
                for (int j = 0; j < pieceOfFabric[i].length; j++) {
                    pieceOfFabric[i][j] = new ArrayList<>();
                }
            }
            int CountTwoOrMoreReclaim = 0;

            // Parse input:
            while ((line = br.readLine()) != null) {

                //Format line:
                String lineClean = line.replaceAll("[^0-9]+", " ");
                String[] lineCut = (lineClean.trim().split("\\s+"));

                int idElf = Integer.parseInt(lineCut[0]);
                int x = Integer.parseInt(lineCut[1]);
                int y = Integer.parseInt(lineCut[2]);
                //Coordinate TopLeftCoordinate = new Coordinate(x, y);
                int length = Integer.parseInt(lineCut[3]);
                int width = Integer.parseInt(lineCut[4]);

                // Fill pieceOfFabric:
                for (int i = x; i < (x + length); i++) {
                    for (int j = y; j < (y + width); j++) {
                        pieceOfFabric[i][j].add(idElf);

                    }
                }
            }
            for (int i = 0; i < 1000; i++) {
                for (int j = 0; j < 1000; j++) {

                    if (pieceOfFabric[i][j].size() > 1) {
                        CountTwoOrMoreReclaim += 1;
                    }
                }
            }
            //Display result:
            System.out.println(" il y a " + CountTwoOrMoreReclaim + " carrés utilisés par deux elfes ou plus");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


