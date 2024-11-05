import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class NumberFinder {
    public static void main(String[] args) {
        try {
            System.out.println(numberFinder("The price 102 of the product is 1,99 and 93"));
        } catch (NoNumbersFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<String> numberFinder(String a) throws NoNumbersFoundException {
        Pattern pattern = Pattern.compile("(\\d+[.,]\\d+|\\b\\d+\\b)");
        Matcher matcher = pattern.matcher(a);
        List<String> nums = new ArrayList<>();
        while (matcher.find()) {
            nums.add(matcher.group());
        }
        if (nums.isEmpty()) {
            throw new NoNumbersFoundException("No decimal numbers found in the text.");
        }
        return nums;
    }

    static class NoNumbersFoundException extends Exception {
        public NoNumbersFoundException(String message) {
            super(message);
        }
    }
}
