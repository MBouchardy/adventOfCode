package year2015.day4;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {

        String secretKey = "ckczppom";
        int number = 0;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            String hashString = "";
            while (hashString.length() == 0 || hashString.length() > 27) {
                // increment number while not answer found
                number++;
                String input = secretKey + number;
                byte[] inputBytes = input.getBytes();
                byte[] hashBytes = md.digest(inputBytes);
                // BigInteger to allow numeric comparison (1 for positive value)
                BigInteger hashNumber = new BigInteger(1, hashBytes);

                // Check if the first five characters are zeros
                // Convert hashNumber in hexa
                hashString = hashNumber.toString(16);
            }
            // Get number
            System.out.println("Number: " + number);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
