package year2016.day3;

import java.util.Arrays;


public class Triangle {
    private int side1;
    private int side2;
    private int side3;

    public Triangle(int side1, int side2, int side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;

    }
    public int getSide1() {
        return side1;
    }
    public int getSide2() {
        return side2;
    }
    public int getSide3() {
        return side3;
    }

    public boolean isTriangle() {
    int[] orderSides = new int[] {getSide1(), getSide2(),getSide3()};
        Arrays.sort(orderSides);
    return (orderSides[0] + orderSides[1]) > orderSides[2];
    }
}
