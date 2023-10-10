package year2017.day3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Get input
        double input = 289326;
        //Find Spiral rank
        double rank = findRank(input);
        //Side length
        double side = Math.ceil(3 + (2 * rank));
        //Find distance from closet middle
        double distanceFromMiddle = findDistanceClosetCorner(rank, side, input);
        //Find number of step
        int numberOfStep = (int)(rank + 1 + distanceFromMiddle);

        System.out.println("le nombre de pas est " + numberOfStep);
    }


    private static double findRank(double input) {
        double rank = ((Math.sqrt(input) - 3) / 2);
        return Math.ceil(rank);
    }

    private static double findDistanceClosetCorner(double rank, double side, double input) {

        //Value max of corner
        double corner4 = maxCorner((int)rank);
        double corner3 = corner4 - (side - 1);
        double corner2 = corner3 - (side - 1);
        double corner1 = corner2 - (side - 1);

        //Value of middle
        double middle4 = corner4 - (Math.floor(side / 2));
        double middle3 = middle4 - (side - 1);
        double middle2 = middle3 - (side - 1);
        double middle1 = middle2 - (side - 1);

        // distance from closet middle
        double distance1 = Math.abs(middle1 - input);
        double distance2 = Math.abs(middle2 - input);
        double distance3 = Math.abs(middle3 - input);
        double distance4 = Math.abs(middle4 - input);
        double[] orderDistance;
        orderDistance = new double[]{distance1, distance2, distance3, distance4};
        Arrays.sort(orderDistance);
        return orderDistance[0];
    }


    private static double maxCorner(double rank) {
        return Math.pow((3 + 2 * rank), 2);
    }

}


