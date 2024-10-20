package ex1;

public class ArrayAverage {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int sum = 0;
        double average = 0;

        try {
            if (arr.length == 0) {
                System.out.println("Массив пустой, среднее арифметическое не может быть вычислено.");
                return;
            }
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }
            average = (double) sum / arr.length;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: выход за границы массива! " + e.getMessage());

        } catch (ArithmeticException e) {
            System.out.println("Ошибка: деление на ноль! " + e.getMessage());

        } finally {
            System.out.println("Операция завершена.");
        }

        if (average != 0) {
            System.out.println("Среднее арифметическое: " + average);
        } else {
            System.out.println("Среднее арифметическое не определено");
        }

    }
}