package year2017.day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/inputs/day_04_2017b.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] words = (line.split("\\s+"));


                // Check password
                for (int i = 0; i < words.length; i++) {
                    System.out.println(words[i]);
                }
            }

        //} catch (IOException e) {
        //    throw new RuntimeException(e);
       // }
        //public static boolean checkPassword (String[]words)
       // {
       // Return
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}