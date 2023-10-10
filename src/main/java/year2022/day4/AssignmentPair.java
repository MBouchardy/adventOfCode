package year2022.day4;

public class AssignmentPair {
    private static Elf elf1;
    private static Elf elf2;

    public AssignmentPair(Elf elf1, Elf elf2) {
        this.elf1 = elf1;
        this.elf2 = elf2;
    }

    public Elf getElf1() {
        return elf1;
    }
    public Elf getElf2() {
        return elf2;
    }

    //public void setElf1(Elf elf1) {this.elf1 = elf1;}

    //public void setElf2(Elf elf2) {this.elf2 = elf2;}

    public static boolean hasFullyContainAssignment(AssignmentPair pair) {
        elf1 = pair.getElf1();
        elf2 = pair.getElf2();
        // check elf1 contain elf2 or elf2 contain elf1
        return (elf1.getMin()) < (elf2.getMin()) && (elf1.getMax() > elf2.getMax())
                || (elf1.getMin()) > (elf2.getMin()) && (elf1.getMax() < elf2.getMax());
    }

}
