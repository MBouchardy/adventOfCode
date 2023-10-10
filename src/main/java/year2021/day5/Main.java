package year2021.day5;

import year2015.day_3b.Coordinate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Vent> vents = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/inputs/day_05_2021.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                //Parse input
                String[] coordinates = line.split(" -> ");
                String[] startCoordinate = coordinates[0].split(",");
                String[] endCoordinate = coordinates[1].split(",");
                // Get VentCoordinate
                int xStart = Integer.parseInt(startCoordinate[0]);
                int yStart = Integer.parseInt(startCoordinate[1]);
                int xEnd = Integer.parseInt(endCoordinate[0]);
                int yEnd = Integer.parseInt(endCoordinate[1]);

                // Only take horizontal or vertical line
                if (xStart == xEnd || yStart == yEnd) {
                    Coordinate startCoordinateVent = new Coordinate(xStart, yStart);
                    Coordinate endCoordinateVent = new Coordinate(xEnd, yEnd);
                    Vent currentVent = new Vent(startCoordinateVent, endCoordinateVent);

                    vents.add(currentVent);

                }
            }
            // get vent crossing coordinate frequency
            Map<Coordinate, Integer> crossVentsCoordinateFrequencyMap = Vent.getCrossVentsCoordinatesFrequencyMap(vents);
                // regarder avec merge
            // count number of crossing point with 2 or mor vents.
            int count = 0;
            for (Map.Entry<Coordinate, Integer> entry : crossVentsCoordinateFrequencyMap.entrySet()) {
                int frequency = entry.getValue();
                if (frequency > 1) {
                    count++;
                }
            }
            System.out.println(" le résultat est: " + count);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}