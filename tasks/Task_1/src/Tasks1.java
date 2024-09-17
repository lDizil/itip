public class Tasks1 {
    public static void main(String[] args) {
        System.out.println(Task1(5));

        System.out.println(Task2(24, 2));

        System.out.println(Task3(3, 4, 2));

        System.out.println(Task4(5, 5, 4));

        System.out.println(Task5(10, 49));

        System.out.println(Task6(22, 1.4, 2));

        System.out.println(Task7(3));

        System.out.println(Task8(48, 18));

        System.out.println(Task9(53, 1250));

        System.out.println(Task10(123, 58));
    }

    public static double Task1(int gallons) {
        return gallons * 3.78;
    }

    public static int Task2(int time, int intens) {
        return time * intens;
    }

    public static int Task3(int a, int b, int c) {
        return a * 20 + b * 50 + c * 100;
    }

    // && - И, ||- ИЛИ
    public static String Task4(int X, int Y, int Z) {
        if (X + Y <= Z || X + Z <= Y || Y + Z <= X) {
            return "не треугольник";
        }

        if (X == Y && Y == Z) {
            return "равносторонний";
        }

        if (X == Y || Y == Z || X == Z) {
            return "равнобедренный";
        }
        return "разносторонний";
    }

    public static int Task5(int a, int b) {
        int max = (a > b) ? a : b;
        return max;
    }

    public static int Task6(int n, double w, double h) {
        return (int) (n / (w * h * 2));
    }

    public static int Task7(int a) {
        int result = 1;
        for (int i = 1; i <= a; i++) {
            result *= i;
        }
        return result;
    }

    public static int Task8(int a, int b) {
        if (b == 0) {
            return a;
        }
        return Task8(b, a % b);
    }

    public static float Task9(int a, int b) {
        return (a * b) * 0.72f;
    }

    public static int Task10(double a, double b) {
        if (a - b * 2 <= 0) {
            return 0;
        }
        return (int) Math.ceil((a - b * 2) / 2);
    }
}
