import java.util.regex.*;

public class Highlighter {

    public static void main(String[] args) {
        try {
            System.out.println(highlighter("ThisIsAStringWithLowerAndUpperCase"));
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    public static String highlighter(String a) throws InvalidInputException {

        if (a == null || a.isEmpty()) {
            throw new InvalidInputException("Input string cannot be null or empty.");
        }

        Pattern pattern = Pattern.compile("([a-z])([A-Z])");
        Matcher matcher = pattern.matcher(a);
        StringBuffer result = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(result, matcher.group(1) + "!" + matcher.group(2) + "!");
        }
        matcher.appendTail(result);

        return result.toString();
    }

    static class InvalidInputException extends Exception {
        public InvalidInputException(String message) {
            super(message);
        }
    }
}
