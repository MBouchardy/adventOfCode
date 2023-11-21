package year2021.day6;

import java.util.ArrayList;
import java.util.List;

public class PopulationOfFish {
    private final List<Integer> initialPopulation;
    private final int reproductionMaturity;
    private final int reproductionCycleTime;

    public PopulationOfFish(List<Integer> initialPopulation, int reproductionMaturity, int reproductionCycleTime) {
        this.initialPopulation = initialPopulation;
        this.reproductionMaturity = reproductionMaturity;
        this.reproductionCycleTime = reproductionCycleTime;
    }

    public List<Integer> getPopulationAfterNumberOfCycle(int numberOfReproductionCycle) {
        List<Integer> finalPopulation = new ArrayList<>(this.initialPopulation);
        List<Integer> currentFishChange = new ArrayList<>(finalPopulation.size());
        int cycle;
        // For number of day given
        for (cycle = 0; cycle < numberOfReproductionCycle; cycle++) {
            // For each fish of the population at the start of the cycle
            for (int fishIndex = 0; fishIndex < finalPopulation.size(); fishIndex++) {
                // Get value of time before next reproduction
                int timeBeforeReproduction = finalPopulation.get(fishIndex);

                // If cycle of reproduction
                if (timeBeforeReproduction == 0) {
                    //add new fish with reproductionMaturity
                    currentFishChange.add(this.reproductionMaturity);
                    //current fish start new cycle
                    finalPopulation.set(fishIndex, this.reproductionCycleTime);
                } else {
                    // Subtract 1 cycle before reproduction
                    int newTime = timeBeforeReproduction - 1;
                    finalPopulation.set(fishIndex, newTime);
                }
            }
            // Add modification for the next cycle
            //finalPopulation.clear();
            finalPopulation.addAll(currentFishChange);
            currentFishChange.clear();
        }
        return finalPopulation;
    }

    public long getBigPopulationAfterNumberOfCycle(int numberOfReproductionCycle) {
        long numberOffishAfterCycles = 0;

        // Class fish by timeBeforeReproduction
        // Each cycle move fishes from one timeBeforeReproduction to timeBeforeReproduction -1

        long[] finalPopulationCounter = computeFishesRepartition();
        long[] currentFishChange = new long[finalPopulationCounter.length];
        int cycle;
        long newbornFish = 0;
        // For number of day given
        for (cycle = 0; cycle < numberOfReproductionCycle; cycle++) {
            // For each timeBeforeReproduction put fishCounter to timeBeforReporduction - 1
            for (int timeBeforeReproduction = 0; timeBeforeReproduction < finalPopulationCounter.length; timeBeforeReproduction++) {

                if (timeBeforeReproduction == 0) {
                    newbornFish = finalPopulationCounter[0];

                } else {
                    // Each cycle move fishes from one timeBeforeReproduction to timeBeforeReproduction -1
                    int index = timeBeforeReproduction - 1;
                    currentFishChange[index] = finalPopulationCounter[timeBeforeReproduction];
                }
            }
            for (int y = 0; y < finalPopulationCounter.length; y++) {
                finalPopulationCounter[y] = currentFishChange[y];
            }
            // For every fish in 0 create a new fish in 8 before moving to 6
            finalPopulationCounter[reproductionMaturity] = newbornFish;
            finalPopulationCounter[reproductionCycleTime] += newbornFish;

        }
        for (int timeBeforeReproduction = 0; timeBeforeReproduction < finalPopulationCounter.length; timeBeforeReproduction++) {
            numberOffishAfterCycles += finalPopulationCounter[timeBeforeReproduction];
        }
        return numberOffishAfterCycles;
    }

    public long[] computeFishesRepartition() {
        long[] fishesRepartition = new long[this.reproductionMaturity + 1];

        for (int i = 0; i < this.initialPopulation.size(); i++) {
            int timeBeforeReproduction = this.initialPopulation.get(i);
            fishesRepartition[timeBeforeReproduction] += 1;
        }
        return fishesRepartition;

    }
}

