package ssc;

/**
 * Class to encode the run length of a given string.
 *
 * Note - we'll include characters other than alphanumeric, such as whitespace.
 *
 * @author David.Tegart
 */
public class RunLengthEncoder {

    public static void main(String[] args) {

        RunLengthEncoder counter = new RunLengthEncoder();

        System.out.println("Encoded string for: " + args[0] + " is: " + counter.encode(args[0]));
    }

    public String encode(String input) {

        if(input == null || input.isEmpty()) {
            return "";
        }

        if(input.length() == 1) {
            return input.charAt(0) + "1";
        }

        StringBuilder encoded = new StringBuilder();
        RunCount currentRun = new RunCount(input.charAt(0), 1);

        char[] chars = input.toCharArray();
        for(int i = 1; i < chars.length; i++) {

            if(currentRun.character == chars[i]) {
                currentRun.count++; // Another consecutive character, increase the count
            } else {
                encoded.append(currentRun.character).append(currentRun.count);
                currentRun = new RunCount(chars[i], 1); // Run has ended so start another
            }
        }

        // Handle the last character(s)
        encoded.append(currentRun.character).append(currentRun.count);

        return encoded.toString();
    }

    static class RunCount {
        char character;
        int count;

        public RunCount(char character, int count) {
            this.character = character;
            this.count = count;
        }
    }
}