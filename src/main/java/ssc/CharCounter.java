package ssc;

/**
 * Class to encode the run length of a given string.
 *
 * Note - we'll consider characters other than alphanumeric, such as whitespace.
 *
 * @author David.Tegart
 */
public class CharCounter {

    public static void main(String[] args) {

        CharCounter counter = new CharCounter();

        System.out.println("Encoded string for: " + args[0] + " is: " + counter.encode(args[0]));
    }

    public String encode(String input) {

        StringBuilder output = new StringBuilder();
        if(input == null || input.isEmpty()) {
            return "";
        }

        if(input.length() == 1) {
            return input.charAt(0) + "1";
        }

        char[] chars = input.toCharArray();

        int counter = 1;
        char prevChar = chars[0];
        for(int i = 1; i < chars.length; i++) {

            if(prevChar == chars[i]) { // Another consecutive character
                counter++;
            } else { // Not a consecutive character, so append the count to the output and change the prevChar
                output.append(prevChar).append(counter);
                prevChar = chars[i];
                counter = 1;
            }
        }

        // Handle the last char(s)
        if(counter >= 1) {
            output.append(prevChar).append(counter);
        }

        return output.toString();
    }
}