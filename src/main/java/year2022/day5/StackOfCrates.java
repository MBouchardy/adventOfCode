package year2022.day5;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;

public class StackOfCrates {
    public Queue<Character> crates = Collections.asLifoQueue(new ArrayDeque<>());

    public StackOfCrates (Queue<Character> crates) {
        this.crates = crates;
    }


}

