package year2021.day5;

import year2015.day_3b.Coordinate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vent {

    public Coordinate startPoint;
    public Coordinate endPoint;

    public Vent(Coordinate startCoordinateVent, Coordinate endCoordinateVent) {
        this.startPoint = startCoordinateVent;
        this.endPoint = endCoordinateVent;
    }

    public Coordinate getStartPoint() {
        return startPoint;
    }

    public Coordinate getEndPoint() {
        return endPoint;
    }

    public static List<Coordinate> getVentLine(Vent vent) {
        Coordinate startPoint = vent.getStartPoint();
        Coordinate endPoint = vent.getEndPoint();
        List<Coordinate> ventLine = new ArrayList<>();
        int xStart = startPoint.getX();
        int yStart = startPoint.getY();
        int xEnd = endPoint.getX();
        int yEnd = endPoint.getY();

        int deltaX = xEnd - xStart;
        int deltaY = yEnd - yStart;

        // Get all coordinates of the vent line
        if (deltaX > 0) {
            for (int i = 0; i < deltaX + 1; i++) {
                int currentX = startPoint.getX() + i;
                ventLine.add(new Coordinate(currentX, startPoint.getY()));
            }
        } else if (deltaX < 0) {
            for (int i = 0; i < Math.abs(deltaX) + 1; i++) {
                int currentX = endPoint.getX() + i;
                ventLine.add(new Coordinate(currentX, endPoint.getY()));
            }
        }
        if (deltaY > 0) {
            for (int i = 0; i < deltaY + 1; i++) {
                int currentY = startPoint.getY() + i;
                ventLine.add(new Coordinate(startPoint.getX(), currentY));
            }
        } else if (deltaY < 0) {
            for (int i = 0; i < Math.abs(deltaY) + 1; i++) {
                int currentY = endPoint.getY() + i;
                ventLine.add(new Coordinate(endPoint.getX(), currentY));
            }
        }
        return ventLine;
    }

    public static Map<Coordinate, Integer> getCrossVentsCoordinatesFrequencyMap(List<Vent> vents) {
        Map<Coordinate, Integer> crossVentsCoordinateFrequencyMap = new HashMap<>();

        //Get ventLine coordinate
        for (Vent vent : vents) {
            List<Coordinate> ventLine = getVentLine(vent);
            // count frequency by coordinate
            for (Coordinate coordinate : ventLine) {
                crossVentsCoordinateFrequencyMap.put(coordinate, crossVentsCoordinateFrequencyMap.getOrDefault(coordinate, 0) + 1);
            }
        }
        return crossVentsCoordinateFrequencyMap;
    }
}
