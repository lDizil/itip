import java.util.Arrays;

public class Tasks3 {
    public static void main(String[] args) {
        System.out.println(task1("sparkling", "groups"));
        System.out.println(task1("bush", "hubris"));
        System.out.println(task1("", ""));
        System.out.println("---------");

        Object[][] items = {
                { "Laptop", 124200 },
                { "Phone", 51450 },
                { "Headphones", 13800 }
        };
        System.out.println(Arrays.deepToString(task2(items, 25)));
        System.out.println("---------");

        System.out.println(task3(0, 0, 5, 2, 2));
        System.out.println(task3(-2, -3, 4, 5, -6));
        System.out.println("---------");

        System.out.println(task4(243));
        System.out.println(task4(12));
        System.out.println(task4(3));
        System.out.println("---------");

        System.out.println(task5("rock", "paper"));
        System.out.println(task5("paper", "rock"));
        System.out.println(task5("scissors", "scissors"));
        System.out.println("---------");

        System.out.println(task6(39));
        System.out.println(task6(999));
        System.out.println(task6(4));
        System.out.println("---------");

        Object[][] inventory = {
                { "Скакалка", 550, 8 },
                { "Шлем", 3750, 4 },
                { "Мяч", 2900, 10 }
        };
        System.out.println(task7(inventory));
        System.out.println("---------");

        System.out.println(task8("abcba"));
        System.out.println(task8("bbb"));
        System.out.println("---------");

        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        System.out.println(isPrefix("retrospect", "sub-"));
        System.out.println(isSuffix("vocation", "-logy"));
        System.out.println("---------");

        System.out.println(task10(1, 1, 1, 1, 1));
        System.out.println(task10(1, 2, 1, 1, 1));
        System.out.println(task10(1, 2, 2, 1, 1));
        System.out.println("---------");

    }

    public static boolean task1(String a, String b) {
        return (a.isEmpty() && b.isEmpty()) ||
                (a.charAt(0) == b.charAt(b.length() - 1) && a.charAt(a.length() - 1) == b.charAt(0));
    }

    public static Object[][] task2(Object[][] a, int discount) {
        for (int i = 0; i < a.length; i++) {
            int price = (int) a[i][1];
            int newPrice = Math.max(1, (int) Math.round(price * (1 - discount / 100.0)));
            a[i][1] = newPrice;
        }
        return a;
    }

    public static boolean task3(int x, int y, int r, int m, int n) {
        return (Math.sqrt((m - x) * (m - x) + (n - y) * (n - y)) <= r);
    }

    public static boolean task4(int a) {
        int sum = 0;
        int temp = a;

        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        return (a % 2 == sum % 2);
    }

    public static String task5(String p1, String p2) {
        if (p1.equals(p2)) {
            return "Ничья";
        }
        return (p1.equals("rock") && p2.equals("scissors")) || (p1.equals("scissors") && p2.equals("paper")) ||
                (p1.equals("paper") && p2.equals("rock")) ? "Игрок 1 выигрывает" : "Игрок 2 выигрывает";
    }

    public static int task6(int num) {
        int count = 0;
        while (num > 9) {
            int product = 1;
            while (num > 0) {
                product *= num % 10;
                num /= 10;
            }
            num = product;
            count++;
        }
        return count;
    }

    public static String task7(Object[][] items) {
        String mostExpensiveItem = "";
        int maxCost = 0;

        for (Object[] item : items) {
            int price = (int) item[1];
            int quantity = (int) item[2];
            int cost = price * quantity;

            if (cost > maxCost) {
                maxCost = cost;
                mostExpensiveItem = (String) item[0];
            }
        }

        return "Наиб. общ. стоимость у предмета " + mostExpensiveItem + " - " + maxCost;
    }

    public static String task8(String str) {
        String longest = "", current = "";
        for (char c : str.toCharArray()) {
            if (current.contains("" + c)) {
                if (current.length() > longest.length())
                    longest = current;
                current = current.substring(current.indexOf(c) + 1);
            }
            current += c;
        }
        return current.length() > longest.length() ? current : longest;
    }

    // task9
    public static boolean isPrefix(String word, String prefix) {
        return word.startsWith(prefix.substring(0, prefix.length() - 1));
    }

    public static boolean isSuffix(String word, String suffix) {
        return word.endsWith(suffix.substring(1));
    }

    public static boolean task10(int a, int b, int c, int w, int h) {
        return (a <= w && b <= h) || (a <= h && b <= w) ||
                (a <= w && c <= h) || (a <= h && c <= w) ||
                (b <= w && c <= h) || (b <= h && c <= w);
    }
}
