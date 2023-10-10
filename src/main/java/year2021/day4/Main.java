package year2021.day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        List<Board> boards = new ArrayList<>();
        int[] drow = null;

        String regexBoard = "([0-9]+)(?:\\s+([0-9]+)){4}";

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/inputs/day_04_2021b.txt"))) {
            String line;
            Board currentBoard = null;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    if (drow == null) {
                        // Handle the first line (to populate drow)
                        String[] values = line.split(",");
                        drow = new int[values.length];
                        for (int i = 0; i < values.length; i++) {
                            drow[i] = Integer.parseInt(values[i]);
                        }
                    } else {
                        // Handle board data
                        Pattern pattern = Pattern.compile(regexBoard);
                        Matcher matcher = pattern.matcher(line);
                        if (matcher.matches()) {
                            if (currentBoard == null) {
                                currentBoard = new Board();
                                currentBoard.getBoard()[0] = drow;
                            }
                            int[] boardRow = new int[5];
                            for (int i = 0; i < 5; i++) {
                                boardRow[i] = Integer.parseInt(matcher.group(i + 1));
                            }
                            currentBoard.getBoard()[currentBoard.getNextRowIndex()] = boardRow;
                            currentBoard.incrementNextRowIndex();
                        } else {
                            if (currentBoard != null) {
                                boards.add(currentBoard);
                                currentBoard = null;
                            }
                        }
                    }
                }
            }

            // Add the last board if it exists
            if (currentBoard != null) {
                boards.add(currentBoard);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print the boards
        for (int i = 0; i < boards.size(); i++) {
            System.out.println("Board " + (i + 1));
            Board board = boards.get(i);
            int[][] boardData = board.getBoard();
            for (int[] boardDatum : boardData) {
                for (int j : boardDatum) {
                    System.out.print(j + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}

//read list
// file board
// Check line columns full
// If full
// Get nest list number
// Get sum winning unmarked number of winning board
// Result = nextListNumber * sum





