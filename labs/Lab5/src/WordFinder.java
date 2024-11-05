import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

public class WordFinder {

    public static void main(String[] args) {
        try {
            System.out.println(wordFinder("This is an Example of a String with multiple words starting with E", 's'));
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    public static List<String> wordFinder(String a, char target) throws InvalidInputException {
        if (a == null || a.isEmpty()) {
            throw new InvalidInputException("Input string cannot be null or empty.");
        }

        List<String> foundWords = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\b" + target + "[a-zA-Z]*\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(a);

        while (matcher.find()) {
            foundWords.add(matcher.group());
        }

        if (foundWords.isEmpty()) {
            throw new InvalidInputException("No words found starting with the specified letter.");
        }

        return foundWords;
    }

    static class InvalidInputException extends Exception {
        public InvalidInputException(String message) {
            super(message);
        }
    }
}
