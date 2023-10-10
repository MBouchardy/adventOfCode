package year2022.day4;

public class Elf {
    private int min;
    private int max;

    public Elf(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public void setMin(int min) {
        this.min = min;
    }
    public void setMax(int max) {
        this.max = max;
    }

    public static Elf creatElf(String inputParts) {
        String[] parts = inputParts.split("-");
        int min = Integer.parseInt(parts[0]);
        int max = Integer.parseInt(parts[1]);
        return new Elf(min, max);
    }

}



