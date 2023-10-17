package year2017.day6;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MemoryBank {
    private final List<Integer> memoryBlocks;

    public MemoryBank(List<Integer> memoryBlocks) {
        this.memoryBlocks = memoryBlocks;
    }

    public List<Integer> getMemoryBlock() {
        return memoryBlocks;
    }

    public void rearrangeBlocks() {

        //Get max block and index
        int maxValueBlock = Collections.max(getMemoryBlock());
        int maxValueIndex = getMemoryBlock().indexOf(maxValueBlock);

        //Down maxValueBlock to 0
        memoryBlocks.set(maxValueIndex, 0);

        //Share ValueToShare between blocks
        for (int i = 1; i <= maxValueBlock; i++) {
            //Move index starting from the following of maxValueIndex and loop at max
            int modifiedBlockIndex = (maxValueIndex + i) % memoryBlocks.size();
            //add 1 to the block
            memoryBlocks.set(modifiedBlockIndex, (memoryBlocks.get(modifiedBlockIndex) + 1));
        }

    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemoryBank that = (MemoryBank) o;
        return Objects.equals(memoryBlocks, that.memoryBlocks);
    }

    public int hashCode() {
        return Objects.hash(memoryBlocks);
    }
}
