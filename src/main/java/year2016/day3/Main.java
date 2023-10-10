package year2016.day3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/inputs/day_03_2016.txt"))) {
            String line;
            int triangleCount = 0;
            // Parse input line:
            while ((line = br.readLine()) != null) {

                //construct triangles list:
                String[] lengths = (line.trim().split("\\s+"));

                int side1 = Integer.parseInt(lengths[0]);
                int side2 = Integer.parseInt(lengths[1]);
                int side3 = Integer.parseInt(lengths[2]);
                Triangle triangle = new Triangle(side1, side2, side3);

                // Control triangle possible:
                if (triangle.isTriangle()) {
                    triangleCount += 1;
                }
            }
            //Display result:
            System.out.println(" il y a " + triangleCount + " triangles possibles");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}