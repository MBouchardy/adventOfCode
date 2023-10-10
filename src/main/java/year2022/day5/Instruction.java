package year2022.day5;

public class Instruction {
    public int numberOfMove;
    public int pileOfStart;
    public int pileOfArrival;

    public Instruction (int numberOfMove, int pileOfStart, int pileOfArrival) {
        this.numberOfMove = numberOfMove;
        this.pileOfStart = pileOfStart;
        this.pileOfArrival = pileOfArrival;
    }

    public int getNumberOfMove (){
        return numberOfMove;
    }

    public int getPileOfStart(){
        return pileOfStart;
    }

    public int getPileOfArrival() {
        return pileOfArrival;
    }

}
