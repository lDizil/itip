public class Tasks1 {
    public static void main(String[] args) {
        // task1: Перевод галлонов в литры
        int gallons = 8;
        double liters = gallonsToLiters(gallons);
        System.out.println(gallons + " галлонов = " + liters + " литров");

        // task2: Расчет калорий по интенсивности
        int time = 15;
        int intensive = 3;
        int cal = fitCalc(time, intensive);
        System.out.println("Сожженные калории: " + cal);

        // task3: Подсчет стоимости товаров
        int boxes = 20;
        int bags = 50;
        int barrels = 100;
        int value_boxes = 3;
        int value_bags = 4;
        int value_barrels = 2;
        System.out.println("Стоимость товаров: " + (boxes * value_boxes + bags * value_bags + barrels * value_barrels));

        // task4: Определение типа треугольника
        int X = 3;
        int Y = 4;
        int Z = 5;
        System.out.println("Тип треугольника: " + getTriangleType(X, Y, Z));

        // task5: Максимум из двух чисел
        int a = 8;
        int b = 4;
        int max = (a > b) ? a : b;
        System.out.println("Максимум из двух чисел: " + max);

        // task6: Количество деталей на ткани
        System.out.println("Количество деталей на ткани: " + amount(22, 1.4, 2));
        System.out.println(amount(45, 1.8, 1.9));
        System.out.println(amount(100, 2, 2));

        // task7: Факториал числа
        a = 3;
        int result = 1;
        for (int i = 1; i <= a; i++) {
            result *= i;
        }
        System.out.println("Факториал числа: " + result);

        // task8: НОД двух чисел
        int num1 = 48;
        int num2 = 18;
        int gcd = findGCD(num1, num2);
        System.out.println("НОД: " + gcd);

        // task9: Расчет дохода от продажи билетов
        int ticket = 53;
        int cost = 1250;
        float ticketSaler = (ticket * cost) * 0.72f;
        System.out.println("Доход от продажи билетов: " + ticketSaler);

        // task10: Столы для студентов
        int students = 5;
        int tables = 2;
        int requiredTables = (int) Math.ceil(students / 2.0);
        int res = (requiredTables > tables) ? (requiredTables - tables) : 0;
        System.out.println(res);
    }

    // task1: Перевод галлонов в литры
    public static double gallonsToLiters(int gallons) {
        double liters = 3.78541 * gallons;
        return liters;
    }

    // task2: Расчет калорий
    public static int fitCalc(int intensive, int time) {
        int cal = intensive * time;
        return cal;
    }

    // task4: Определение типа треугольника
    public static String getTriangleType(int X, int Y, int Z) {
        if (X + Y <= Z || X + Z <= Y || Y + Z <= X) {
            return "not a triangle";
        }

        if (X == Y && Y == Z) {
            return "isosceles";
        }
        if (X == Y || Y == Z || X == Z) {
            return "equilateral";
        }
        return "different-sided";
    }

    // task6: Количество деталей на ткани
    public static int amount(int n, double w, double h) {
        double Fabric = n;
        double Detail = w * h * 2;

        int number = (int) (Fabric / Detail);
        return number;
    }

    // task8: НОД двух чисел
    public static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }
}
