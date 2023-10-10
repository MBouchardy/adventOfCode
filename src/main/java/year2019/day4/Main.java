package year2019.day4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String input = "152085-670283";
        List<Integer> listOfPassword;
        //The value is within the range given in your puzzle input.
        listOfPassword = getListOfPotentialPassword(input);
        System.out.println("test filter " + listOfPassword.stream().filter(Main::isWordAPassword).count());


        //Two adjacent digits are the same (like 22 in 122345).
        List<Integer> reducedListOfPassword = getOnlyNumberWithAdjacentDigit(listOfPassword);

        //Going from left to right, the digits never decrease; they only ever increase or stay the same (like 111123 or 135679).
        List<Integer> listOfOkPassword = getOnlyIncreasingDigitsNumbers(reducedListOfPassword);
        System.out.println("il y a " + listOfOkPassword.size() + " password valide");

        // Part two check whit only one adjacent digit
        List<Integer> listOfOkPasswordPart2 = getOnlyNumberWithOneAdjacentDigit(listOfOkPassword);
        System.out.println("il y a " + listOfOkPasswordPart2.size() + " password valide");
    }

    private static boolean isWordAPassword(Integer word) {
        //je vérifie qu'il y a un doublon
        return isDigitIncreasing(word) && hasAdjacentDigits(word);
        //je vérifie que ces digits sont croissants
    }


    public static List<Integer> getListOfPotentialPassword(String input) {
        List<Integer> listPassword = new ArrayList<>();
        String[] numbers = input.split("-");
        int start = Integer.parseInt(numbers[0]);
        int end = Integer.parseInt(numbers[1]);

        for (int i = start; i < end + 1; i++) {
            listPassword.add(i);
        }

        return listPassword;
    }

    public static List<Integer> getOnlyNumberWithAdjacentDigit(List<Integer> input) {
        List<Integer> reducedList = new ArrayList<>();
        for (int number : input) {
            if (hasAdjacentDigits(number)) {
                reducedList.add(number);
            }
        }
        return reducedList;
    }

    public static boolean hasAdjacentDigits(int number) {
        String numberString = Integer.toString(number);
        for (int i = 0; i < numberString.length() - 1; i++) {
            if (numberString.charAt(i) == numberString.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }

    public static List<Integer> getOnlyNumberWithOneAdjacentDigit(List<Integer> input) {
        List<Integer> reducedList = new ArrayList<>();
        for (int number : input) {
            if (hasOneAdjacentDigitsOnly(number)) {
                reducedList.add(number);
            }
        }
        return reducedList;
    }

    public static boolean hasOneAdjacentDigitsOnly(int number) {
        String numberString = Integer.toString(number);
        for (int i = 0; i < numberString.length() - 2; i++) {
            if ((numberString.charAt(i) == numberString.charAt(i + 1))
                    && (numberString.charAt(i) != numberString.charAt(i + 2))) {
                return true;
            }
            if ((numberString.charAt(4) != numberString.charAt(5))) {
                return true;
            }
        }

        return false;
}

    public static List<Integer> getOnlyIncreasingDigitsNumbers(List<Integer> input) {
        List<Integer> listOfOkPassword = new ArrayList<>();
        for (int number : input) {
            if (isDigitIncreasing(number)) {
                listOfOkPassword.add(number);
            }
        }
        return listOfOkPassword;
    }

    public static boolean isDigitIncreasing(int number) {
        String numberString = Integer.toString(number);

        for (int i = 0; i < numberString.length() - 1; i++) {
            int currentDigit = Character.getNumericValue(numberString.charAt(i));
            int nextDigit = Character.getNumericValue(numberString.charAt(i + 1));

            if (nextDigit < currentDigit) {
                return false;
            }
        }

        return true;
    }

}
