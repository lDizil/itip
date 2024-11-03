import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.HashMap;
import java.util.Map;

public class Tasks4 {
    public static void main(String[] args) {
        System.out.println(task1("abracadabra"));
        System.out.println(task1("abababcac"));

        System.out.println(Arrays.toString(task2(1, 5)));
        System.out.println(Arrays.toString(task2(2, 2)));
        System.out.println(Arrays.toString(task2(5, 3)));

        System.out.println(encode("MKIIT", 0, 25, 28, 10, 27));
        System.out.println(Arrays.toString(decode("MKIIT", "MTUCI")));

        System.out.println(task4("()()()"));
        System.out.println(task4("((()))"));
        System.out.println(task4("((()))(())()()(()())"));
        System.out.println(task4("((())())(()(()()))"));

        System.out.println(task5("abbccc"));
        System.out.println(task5("vvvvaajaaaaa"));

        System.out.println(task6(8));
        System.out.println(task6(1234));
        System.out.println(task6(52));

        System.out.println(task7("31312131"));
        System.out.println(task7("1111111"));
        System.out.println(task7("12223234333"));

        int[][] maze1 = {
                { 1, 3, 1 },
                { 1, -1, 1 },
                { 4, 2, 1 }
        };

        int[][] maze2 = {
                { 2, -7, 3 },
                { -4, -1, 8 },
                { 4, 5, 9 }
        };

        System.out.println(task8(maze1, 0, 0));
        System.out.println(task8(maze2, 0, 0));

        System.out.println(task9("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(task9("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));

        System.out.println(task10("CCCABDD")); // ➞ True
        System.out.println(task10("ABC"));

    }

    public static String task1(String a) {
        a = a.toLowerCase();
        for (char c : a.toCharArray()) {
            if (a.chars().filter(ch -> ch == c).count() > 3) {
                a = a.replace(String.valueOf(c), "");
                return task1(a);
            }
        }
        return a;
    }

    public static String[] task2(int n, int k) {
        if (n > k || k > 5)
            return new String[0];

        List<String> results = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        stack.push("");

        while (!stack.isEmpty()) {
            String current = stack.pop();

            if (current.length() == n) {
                results.add(current);
                continue;
            }

            for (int i = k - 1; i >= 0; i--) {
                if (!current.contains(String.valueOf(i))) {
                    stack.push(current + i);
                }
            }
        }

        return results.toArray(new String[0]);
    }

    public static String encode(String key, int... nums) {
        StringBuilder encoded = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            encoded.append((char) ((nums[i] ^ (key.charAt(i) - 'A')) + 'A'));
        }
        return encoded.toString();
    }

    public static int[] decode(String key, String str) {
        int[] decoded = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            decoded[i] = (str.charAt(i) - 'A') ^ (key.charAt(i) - 'A');
        }
        return decoded;
    }

    public static List<String> task4(String str) {
        List<String> result = new ArrayList<>();
        StringBuilder cluster = new StringBuilder();
        int balance = 0;

        for (char ch : str.toCharArray()) {
            cluster.append(ch);
            balance += (ch == '(') ? 1 : -1;

            if (balance == 0) {
                result.add(cluster.toString());
                cluster.setLength(0);
            }
        }
        return result;
    }

    public static String task5(String s) {
        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < s.length()) {
            char currentChar = s.charAt(i);
            int count = 1;
            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                count++;
                i++;
            }

            result.append(currentChar);
            if (count > 1) {
                result.append("*").append(count);
            }

            i++;
        }

        return result.toString();
    }

    public static String task6(int num) {
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                result.append(symbols[i]);
                num -= values[i];
            }
        }

        return result.toString();
    }

    public static String task7(String s) {
        Map<Character, Integer> countMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        int maxCount = 0;
        char maxChar = ' ';

        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxChar = entry.getKey();
            }
        }

        int index = s.indexOf(maxChar);

        return (index % 2 == 0) ? "чет" : "нечет";
    }

    public static String task8(int[][] maze, int i, int j) {
        int n = maze.length;

        if (maze[0][0] < 0 || maze[n - 1][n - 1] < 0) {
            return "Прохода нет";
        }

        int minCost = findMinPath(maze, 0, 0, n);

        return minCost == Integer.MAX_VALUE ? "Прохода нет" : String.valueOf(minCost);
    }

    private static int findMinPath(int[][] maze, int i, int j, int n) {
        if (i == n - 1 && j == n - 1) {
            return maze[i][j];
        }

        if (i >= n || j >= n || maze[i][j] < 0) {
            return Integer.MAX_VALUE;
        }

        int right = findMinPath(maze, i, j + 1, n);
        int down = findMinPath(maze, i + 1, j, n);

        int minCost = Math.min(right, down);

        return minCost == Integer.MAX_VALUE ? Integer.MAX_VALUE : maze[i][j] + minCost;
    }

    public static String task9(String sentence) {
        String[] words = sentence.split(" ");

        Arrays.sort(words, Comparator.comparingInt(Tasks4::extractNumber));

        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(word.replaceAll("\\d", "")).append(" ");
        }

        return result.toString().trim();
    }

    private static int extractNumber(String word) {
        return Integer.parseInt(word.replaceAll("\\D", ""));
    }

    public static boolean task10(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        int[] counts = countMap.values().stream().sorted().mapToInt(Integer::intValue).toArray();

        if (counts.length < 2)
            return true;

        for (int i = 2; i < counts.length; i++) {
            if (counts[i] != counts[i - 1] + counts[i - 2]) {
                return false;
            }
        }

        return true;
    }
}
