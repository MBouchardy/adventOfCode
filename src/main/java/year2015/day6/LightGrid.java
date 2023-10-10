package year2015.day6;

import year2015.day_3b.Coordinate;

import java.util.HashMap;
import java.util.Map;

public class LightGrid {
    public Map<Coordinate, Boolean> lightGrid;

    public LightGrid() {
        lightGrid = new HashMap<>();
    }

    public Map<Coordinate, Boolean> getLightGrid() {
        return lightGrid;
    }

    public LightGrid applyInstruction(Instruction instruction, LightGrid lightGrid) {

        String action = instruction.getAction();
        Coordinate firstLight = instruction.getFirstLight();
        Coordinate lastLight = instruction.getLastLight();

        //apply instruction for all light between start and end
        for (int x = firstLight.getX(); x <= lastLight.getX(); x++) {
            for (int y = firstLight.getY(); y <= lastLight.getY(); y++) {
                Coordinate currenCoordinate = new Coordinate(x, y);
                // if no light, creat it
                boolean currentState = getLightGrid().getOrDefault(currenCoordinate, false);

                switch (action) {
                    case "turn on" -> lightGrid.getLightGrid().put(currenCoordinate, true);
                    case "turn off" -> lightGrid.getLightGrid().put(currenCoordinate, false);
                    case "toggle" -> lightGrid.getLightGrid().put(currenCoordinate, !currentState);
                    default -> throw new IllegalArgumentException("Action non permise : " + action);
                }

            }
        }
        return lightGrid;
    }

    public int countLigthOn(LightGrid lightGrid) {
        int count = 0;
        /*for (boolean value : lightGrid.getLightGrid().values()) {
            if (value) {
                count++;
            }

        }*/
        return (int) lightGrid.getLightGrid().values().stream().filter(value-> value).count();

    }

}
