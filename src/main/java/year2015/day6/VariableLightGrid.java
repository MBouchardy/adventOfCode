package year2015.day6;

import year2015.day_3b.Coordinate;

import java.util.HashMap;
import java.util.Map;

public class VariableLightGrid {
    public Map<Coordinate, Integer> variableLightGrid;

    public VariableLightGrid() {
        variableLightGrid = new HashMap<>();
    }

    public Map<Coordinate, Integer> getVariableLightGrid() {
        return variableLightGrid;
    }


    public int getBrightness(Coordinate coordinate) {
        return variableLightGrid.getOrDefault(coordinate, 0);
    }

    public VariableLightGrid applyInstructionPart2(Instruction instruction, VariableLightGrid variableLightGrid) {

        String action = instruction.getAction();
        Coordinate firstLight = instruction.getFirstLight();
        Coordinate lastLight = instruction.getLastLight();

        //apply instruction for all lights between start and end
        for (int x = firstLight.getX(); x <= lastLight.getX(); x++) {
            for (int y = firstLight.getY(); y <= lastLight.getY(); y++) {
                Coordinate currentCoordinate = new Coordinate(x, y);

                switch (action) {
                    case "turn on" ->
                            variableLightGrid.getVariableLightGrid().merge(currentCoordinate, 1, Integer::sum);
                    case "turn off" -> {
                        if (getBrightness(currentCoordinate) > 0) {
                            variableLightGrid.getVariableLightGrid().merge(currentCoordinate, -1, Integer::sum);
                        }
                    }
                    case "toggle" -> variableLightGrid.getVariableLightGrid().merge(currentCoordinate, 2, Integer::sum);
                    default -> throw new IllegalArgumentException("Action non permise : " + action);
                }

            }
        }
        return variableLightGrid;
    }

    public int countLightBrightness() {
        int count = 0;

        //count all light of the grid
        for (int x = 0; x <= 999; x++) {
            for (int y = 0; y <= 999; y++) {
                Coordinate currenCoordinate = new Coordinate(x, y);
                int brightness = getBrightness(currenCoordinate);
                count += brightness;
            }

        }
        return count;
    }
}




