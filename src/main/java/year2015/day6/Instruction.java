package year2015.day6;

import year2015.day_3b.Coordinate;

public class Instruction {
    public String action;
    public Coordinate firstLight;
    public Coordinate lastLight;

    public Instruction(String action, Coordinate firstLight, Coordinate lastLight) {
        this.action = action;
        this.firstLight = firstLight;
        this.lastLight = lastLight;
    }

    public String getAction() {
        return action;
    }

    public Coordinate getFirstLight() {
        return firstLight;
    }

    public Coordinate getLastLight() {
        return lastLight;
    }

}

