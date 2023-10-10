package year2016.day4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        int sumId = 0;
        List<Room> rooms = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/inputs/day_04_2016.txt"))) {
            String line;


            while ((line = br.readLine()) != null) {
                // Get checkSum
                String checksum = getCheckSum(line);

                // Get roomID
                String roomID = getRoomID(line);
                // Get encryptedName
                String encryptedName = getEncryptedName(line);
                //add
                Room room = new Room(roomID, encryptedName, checksum);
                rooms.add(room);

                if (isRealRoom(room)) {
                    sumId += Integer.parseInt(room.getRoomID());
                }
            }

            // get result
            System.out.println(sumId);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getCheckSum(String input) {
        String checkSum = null;
        String pattern = "\\[([a-zA-Z]+)]";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(input);

        if (matcher.find()) {
            checkSum = matcher.group(1);
        }

        return checkSum;
    }

    public static String getRoomID(String input) {
        String roomID = null;
        String pattern = "-(\\d+)";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(input);

        if (matcher.find()) {
            roomID = matcher.group(1);
        }

        return roomID;

    }

    public static String getEncryptedName(String input) {

        String patternCheckSum = "\\[([a-zA-Z]+)]";
        String patternID = "-(\\d+)";

        String encryptedName = input.replaceAll(patternCheckSum, "");
        encryptedName = encryptedName.replaceAll(patternID, "");

        return encryptedName;
    }

    // public static boolean checkAlphabetization(String input) {
    //   for (int i = 0; i < input.length(); i++) {
    //     if (input.charAt(i) < input.charAt(i - 1)) {
    //       return false;
    //   }
    //}
    //  return true;
    //}

    public static boolean isRealRoom(Room room) {
        String encryptedName = room.getEncryptedName();
        String checkSum = room.getCheckSum();

        // check 5 most common letters in encryptedName and sort alphabetically
        //Counting occurence of each letter of encryptedName
        Map<String, Long> occurenceMap = encryptedName.chars()
                .mapToObj(c -> (char) c)
                .filter(Character::isLetter)
                .map(String::valueOf)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Order by occurence and alphabetic order
        List<String> orderedList = new ArrayList<>(occurenceMap.keySet());
        orderedList.sort(String::compareTo);
        orderedList.sort(Comparator.comparingLong(occurenceMap::get)
                .reversed());

        String currentCheckSum = String.join("", orderedList);
        currentCheckSum = currentCheckSum.substring(0, 5);

        // Compare if equal checkSum
        return checkSum.equals(currentCheckSum);

    }
}

