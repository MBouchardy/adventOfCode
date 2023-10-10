package year2018.day5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Polymer {

    public String composition;

    public Polymer(String composition) {

        this.composition = composition;
    }

    // Get all the possible reaction (aA, Aa, ... zZ, zZ)
    private static final List<String> reactionsList = getPossibleReactions();

    private static List<String> getPossibleReactions() {
        List<String> possibleReactions = new ArrayList<>();

        for (char c = 'A'; c <= 'Z'; c++) {
            String upperLowerPair = "%s%s".formatted(String.valueOf(c), (char) (c + 32));
            possibleReactions.add(upperLowerPair);
            possibleReactions.add(upperLowerPair.charAt(1) + "" + upperLowerPair.charAt(0));

        }
        return possibleReactions;
    }

    //Get polymer after reaction
    public String getPolymerSizeAfterReaction() {
        boolean reacted = true;

        while (reacted) {
            reacted = false;
            for (String reagent : reactionsList) {
                if (composition.contains(reagent)) {
                    composition = composition.replace(reagent, "");
                    reacted = true;
                }
            }
        }
        return composition;
    }

    public String getShortestFullyReactedPolymerSize() {
        // Get all alphabet letters
        return IntStream.range(65, 91)
                .mapToObj(intChar -> (char) intChar)
                // Get liste of modifiedPolymer ( 1 by removed letter) => "(?i)"  case insensitive
                .map(letter -> this.composition.replaceAll("(?i)" + letter, ""))
                // Creation modifiedPolymer
                .map(Polymer::new)
                // Get size of each modifiedPolymer after reaction
                .map(Polymer::getPolymerSizeAfterReaction)
                // Get shortest modified Polymer
                .min(Comparator.comparingInt(String::length))
                .orElseThrow();
    }
}
