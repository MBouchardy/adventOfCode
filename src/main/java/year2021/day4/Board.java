package year2021.day4;

import java.util.Arrays;

public class Board {
    private int[][] board;
    private int nextRowIndex;

    public Board() {
        board = new int[2][25]; // [value] [ 0 = unmarked / 1 = marked]
        nextRowIndex = 0;
    }

    public int[][] getBoard() {
        return board;
    }

    public int getNextRowIndex() {
      return nextRowIndex;
    }
    public void incrementNextRowIndex() {
        nextRowIndex++;
    }

    public int[] sumBoardLeft() {
        int[] readedLine = board[1];
        int[] fullRow = new int[]{1, 1, 1, 1, 1};
        int[] valueOfFullRow = null;
        for (int i = 0; i < readedLine.length - 4; i++) {
            int[] row = Arrays.copyOfRange(readedLine, i, i + 5);
            if (Arrays.equals(row, fullRow)) {
                valueOfFullRow = Arrays.copyOfRange(board[0], i, i + 5);
                i += 4;
            }
        }
        return valueOfFullRow;

    }

    public int sumBoardLeft(int[] valueOfFullRow) {
        int sum = 0;
        int[] boardCopy = Arrays.copyOf(board[1],board[1].length);

        for (int i = 0; i <boardCopy.length; i++) {
            if (Arrays.asList(valueOfFullRow).contains(boardCopy[i])) {
                boardCopy[i] = 0;
            }
        }
        for (int value : boardCopy){
            sum += value;
        }
        return sum;
    }
}
