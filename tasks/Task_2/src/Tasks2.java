import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Tasks2 {
    public static void main(String[] args) {
        System.out.println(task1("Barack", "Obama"));

        System.out.println(task2(3, 12, 7, 81, 52));

        System.out.println(task3("simonov sergei evgenievich"));

        System.out.println(Arrays.toString(task4(3.5, 7.0, 1.5, 9.0, 5.5)));
        System.out.println(Arrays.toString(task4(10.0, 10.0, 10.0, 10.0, 10.0)));

        System.out.println(Arrays.toString(task5(1.6, 0, 212.3, 34.8, 0, 27.5)));

        System.out.println(task6("helloWorld"));

        System.out.println(task7(3, 5, 8, 1, 2, 4));

        System.out.println(task8("baobab", 'b'));
        System.out.println(task8("Hello, I’m under the water, please help me", 'e'));
        System.out.println(task8("you will duy faster yrim than both of yupi and yma", 'y'));

        System.out.println(task9(8, 1, 8));
        System.out.println(task9(5, 5, 5));
        System.out.println(task9(4, 9, 6));

        System.out.println(task10("LISTEN", "silent")); // true

    }

    public static String task1(String a, String b) {
        StringBuilder result = new StringBuilder();
        a = a.toLowerCase();
        b = b.toLowerCase();
        for (char ch : a.toCharArray()) {
            if (b.indexOf(ch) == -1) {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static int task2(int... numbers) {
        int count = 0;
        for (int num : numbers) {
            if (num % 2 != 0 && num % 3 == 0) {
                count++;
            }
        }
        return count;
    }

    public static String task3(String a) {
        String[] parts = a.split(" ");
        return ((parts[1].charAt(0) + "." + parts[2].charAt(0) + "." + parts[0].substring(0, 1)).toUpperCase() +
                parts[0].substring(1).toLowerCase());
    }

    /// import java.util.Arrays;

    public static double[] task4(double... numbers) {
        double min = Arrays.stream(numbers).min().getAsDouble();
        double max = Arrays.stream(numbers).max().getAsDouble();

        if (max == min) {
            return new double[numbers.length];
        }

        return Arrays.stream(numbers).map(n -> (n - min) / (max - min)).toArray();
    }

    /// import java.util.Set;
    /// import java.util.TreeSet;

    public static Integer[] task5(double... numbers) {
        Set<Integer> compressedSet = new TreeSet<>();

        for (double num : numbers) {
            if (num != 0) {
                compressedSet.add((int) num);
            }
        }

        return compressedSet.toArray(new Integer[0]);
    }

    public static String task6(String camel) {
        return camel.replaceAll("([A-Z])", "_$1").toLowerCase();
    }

    /// import java.util.Arrays;

    public static int task7(int... numbers) {
        return Arrays.stream(numbers).distinct().sorted().limit(numbers.length - 1).max().getAsInt();
    }

    public static String task8(String input, char marker) {
        List<Integer> markers = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == marker) {
                markers.add(i);
            }
        }
        for (int i = 0; i < markers.size() - 1; i += 2) {
            int start = markers.get(i) + 1;
            int end = markers.get(i + 1);
            input = input.substring(0, start) + new StringBuilder(input.substring(start, end)).reverse()
                    + input.substring(end);
        }
        return input;
    }

    public static int task9(int a, int b, int c) {
        return a == b && b == c ? 3 : (a == b || b == c || a == c ? 2 : 0);
    }

    /// import java.util.Arrays;

    public static boolean task10(String str1, String str2) {
        char[] arr1 = str1.toLowerCase().toCharArray();
        char[] arr2 = str2.toLowerCase().toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

}
