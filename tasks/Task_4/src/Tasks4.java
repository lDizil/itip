import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

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

}
