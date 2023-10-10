package year2019.day3;

import year2015.day_3b.Coordinate;

import java.util.List;

public class Wire {
     private List<Coordinate> wirePath;

    public Wire (List<Coordinate> wirePath){
      this.wirePath = wirePath;
    }
    public void setWire(List<Coordinate> wirePath) {
        this.wirePath = wirePath;
    }
}
