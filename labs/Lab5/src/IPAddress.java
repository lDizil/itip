import java.util.regex.*;

public class IPAddress {

    public static void main(String[] args) {
        try {
            System.out.println(ipAddress("192.168.0.1"));
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    public static String ipAddress(String a) throws InvalidInputException {

        if (a == null || a.isEmpty()) {
            throw new InvalidInputException("Input ip cannot be null or empty.");
        }

        Pattern pattern = Pattern
                .compile("^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$");
        Matcher matcher = pattern.matcher(a);
        if (matcher.matches()) {
            return "Valid IP address!";
        } else {
            return "Invalid IP address!";
        }
    }

    static class InvalidInputException extends Exception {
        public InvalidInputException(String message) {
            super(message);
        }
    }
}
