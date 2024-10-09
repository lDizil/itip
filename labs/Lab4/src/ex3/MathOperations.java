package ex3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MathOperations {
    public static void main(String[] args) {
        try {
            System.out.println("Сложение: " + performOperation(10, 5, "add"));
            System.out.println("Вычитание: " + performOperation(10, 5, "subtract"));
            System.out.println("Умножение: " + performOperation(10, 5, "multiply"));
            System.out.println("Деление: " + performOperation(10, 5, "divide"));

            System.out.println("Неподдерживаемая операция: " + performOperation(10, 5, "modulus"));

        } catch (CustomUnsupportedOperationException | ArithmeticException e) {
            MathOperations.logException(e);
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }

    public static double performOperation(double a, double b, String operation)
            throws CustomUnsupportedOperationException {
        switch (operation) {
            case "add":
                return a + b;
            case "subtract":
                return a - b;
            case "multiply":
                return a * b;
            case "divide":
                if (b == 0) {
                    throw new ArithmeticException("Ошибка: деление на ноль.");
                }
                return a / b;
            default:
                throw new CustomUnsupportedOperationException("Операция " + operation + " не поддерживается.");
        }
    }

    public static void logException(Exception e) {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("D:/Zone 51/учеба вуз/итип/labs/Lab4/error_log.txt", true))) {
            writer.write("Исключение: " + e.toString() + "\n");
            writer.write("Сообщение: " + e.getMessage() + "\n");
            writer.write("Стек вызовов:\n");
            for (StackTraceElement element : e.getStackTrace()) {
                writer.write(element.toString() + "\n");
            }
            writer.write("--------------------------------\n");
        } catch (IOException ioException) {
            System.out.println("Ошибка при записи в лог-файл.");
        }
    }

}
