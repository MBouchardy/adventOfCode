package year2018.day3;

import year2015.day_3b.Coordinate;
import year2016.day3.Triangle;

import java.util.Arrays;

public class Rectangle {
    private int idElf;
    private Coordinate bottomLeftCoordinate;
    //
    private int length;
    private int width;

    private Coordinate topRightCoordinate;


    public Rectangle(int idElf, Coordinate bottomLeftCoordinate, int length, int width) {
        this.idElf = idElf;
        this.bottomLeftCoordinate = bottomLeftCoordinate;
        this.length = length;
        this.width = width;

    }

    public Coordinate getBottomLeftCoordinate() {
        return bottomLeftCoordinate;
    }

    public Coordinate getTopRightCoordinate() {
        int topRightX = (bottomLeftCoordinate.getX() + length);
        int topRightY = (bottomLeftCoordinate.getY() + width);
        return new Coordinate(topRightX, topRightY);
    }

}
