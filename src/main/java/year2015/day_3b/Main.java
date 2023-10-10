package year2015.day_3b;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Coordinate> coordinates;

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/inputs/day_03_2015.txt"))) {
            String line;


            while ((line = br.readLine()) != null) {
                //Exo 1:
                coordinates = getAddressList(line);
                // Print out number of address visited at least once
                System.out.println("il y a " + coordinates.size() + " adresses différentes");

                //Exo 2:
                // separation santa and robot-santa moves:
//                ArrayList<Coordinate> santaCoordinates = new ArrayList<>();
//                ArrayList<Coordinate> robotSantaCoordinates = new ArrayList<>();
//                List<Character> moves = new ArrayList<>();
//                List<Character> santaMoves = new ArrayList<>();
//                List<Character> robotSantaMoves = new ArrayList<>();
//                for (char ch: line.toCharArray()) {
//                    moves.add(ch);
//                }
//                for (int i = 0; i < moves.size(); i += 2) {
//                     santaMoves.add(moves.get(i));
//                }
//                String santaMoveString = santaMoves.toString();
//                santaMoveString = santaMoveString.replaceAll(", ", "");
//                santaCoordinates = getAddressList(santaMoveString);
//
//                for (int i = 1; i < line.length(); i += 2) {
//                    robotSantaMoves.add(moves.get(i));
//                }
//                String robotSantaMoveString = robotSantaMoves.toString();
//                robotSantaMoveString = robotSantaMoveString.replaceAll(", ", "");
//                robotSantaCoordinates = getAddressList(robotSantaMoveString);
            }
            // Check unique address between santa and robot santa

        }
    }

    public static List<Coordinate> getAddressList(String moves) {
        List<Coordinate> coordinates = new ArrayList<>();
        Coordinate currentCoordinate = new Coordinate(0, 0);
        coordinates.add(currentCoordinate);
        for (int i = 0; i < moves.length(); i++) {
            char direction = moves.charAt(i);
            switch (direction) {
                case '<':
                    currentCoordinate = new Coordinate(currentCoordinate.getX() - 1, currentCoordinate.getY());
                    break;
                case '>':
                    currentCoordinate = new Coordinate(currentCoordinate.getX() + 1, currentCoordinate.getY());
                    break;
                case '^':
                    currentCoordinate = new Coordinate(currentCoordinate.getX(), currentCoordinate.getY() + 1);
                    break;
                case 'v':
                    currentCoordinate = new Coordinate(currentCoordinate.getX(), currentCoordinate.getY() - 1);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid direction: " + direction);

            }
            boolean coordinateExist = coordinates.contains(currentCoordinate);


            if (!coordinateExist) {
                coordinates.add(currentCoordinate);
            }
        }
        return coordinates;

    }
}



