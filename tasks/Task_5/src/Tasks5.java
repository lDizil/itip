public class Tasks5 {
    public static void main(String[] args) throws Exception {
        System.out.println(task1("ABAB", "CDCD"));
        System.out.println(task1("ABCBA", "BCDCB"));
        System.out.println(task1("FFGG", "CDCD"));
        System.out.println(task1("FFFF", "ABCD"));

        System.out.println(task2(26, 39));
        System.out.println(task2(122, 81));
        System.out.println(task2(1222, 30277));

        System.out.println(task3(4666));
        System.out.println(task3(544));
        System.out.println(task3(121317));
        System.out.println(task3(0));
        System.out.println(task3(12345));
        System.out.println(task3(1289396387328L));

        System.out.println(task4("caster", "cat", "create", "sat"));
        System.out.println(task4("recant", "trance", "recant"));
        System.out.println(task4("tossed", "dote", "dotes", "toes", "set", "dot", "dots", "sted"));
    }

    public static boolean task1(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;

        for (int i = 0; i < str1.length(); i++) {
            if (str1.indexOf(str1.charAt(i)) != str2.indexOf(str2.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static int task2(int num1, int num2) {
        String str1 = Integer.toString(num1);
        String str2 = Integer.toString(num2);
        while (str1.length() < str2.length())
            str1 = "0" + str1;
        while (str2.length() < str1.length())
            str2 = "0" + str2;

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str1.length(); i++) {
            int digit1 = str1.charAt(i) - '0';
            int digit2 = str2.charAt(i) - '0';
            result.append(digit1 + digit2);
        }

        return Integer.parseInt(result.toString());
    }

    public static int task3(long num) {
        if (num >= 0 && num < 10) {
            return 1;
        }
        return 1 + task3(num / 10);
    }

    public static int task4(String key, String... words) {
        int totalPoints = 0;
        for (String word : words) {
            if (isValidWord(word, key)) {
                int len = word.length();
                totalPoints += len == 3 ? 1 : len == 4 ? 2 : len == 5 ? 3 : len == 6 ? 54 : 0;
            }
        }

        return totalPoints;
    }

    private static boolean isValidWord(String word, String key) {
        int[] letterCounts = new int[26];

        for (char c : key.toCharArray()) {
            letterCounts[c - 'a']++;
        }

        for (char c : word.toCharArray()) {
            if (--letterCounts[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
