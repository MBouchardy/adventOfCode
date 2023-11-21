package year2021.day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {

        // read input
        List<Integer> fishList = new ArrayList<>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/inputs/day_06_2021.txt"))) {
            line = reader.readLine();
        }
        //todo utiliser les regex
        //fishList = Arrays.stream(line.split(","))
        //        .map(Integer::parseInt)
        //        .toList();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            fishList.add(Integer.parseInt(matcher.group()));
        }


        // creation of population with maturity = 6 and cycle = 80
        int reproductionMaturity = 8;
        int reproductionCycleTime = 6;
        int numberOfReproductionCycle = 256;
        PopulationOfFish populationOfFish = new PopulationOfFish(fishList, reproductionMaturity, reproductionCycleTime);
        //List<Integer> finalFishPopulation = populationOfFish.getPopulationAfterNumberOfCycle(numberOfReproductionCycle);
        // int result = finalFishPopulation.size();
        // System.out.println("il y a " + result + " poissons");

        long result2 = populationOfFish.getBigPopulationAfterNumberOfCycle(numberOfReproductionCycle);
        System.out.println("il y a " + result2 + " poissons");
    }
}
