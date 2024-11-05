import java.util.regex.*;

public class PasswordValidator {
    public static void main(String[] args) {
        try {
            System.out.println(passwordValidator("23mdMdmd21"));
        } catch (InvalidPasswordException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    public static String passwordValidator(String a) throws InvalidPasswordException {
        if (a == null || a.isEmpty()) {
            throw new InvalidPasswordException("Password cannot be empty or null.");
        }
        Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$");
        Matcher matcher = pattern.matcher(a);

        if (matcher.matches()) {
            return "Valid password!";
        } else {
            return "Invalid password!";
        }
    }

    static class InvalidPasswordException extends Exception {
        public InvalidPasswordException(String message) {
            super(message);
        }
    }
}
