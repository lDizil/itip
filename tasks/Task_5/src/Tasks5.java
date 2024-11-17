import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

        System.out.println(task5(1, 2, 3, 5, 6, 7, 8, 9));
        System.out.println(task5(1, 2, 3, 10, 11, 15));
        System.out.println(task5(5, 4, 2, 1));
        System.out.println(task5(3, 5, 7, 10, 15));

        System.out.println(task6("95%", "83%", "90%", "87%", "88%", "93%"));
        System.out.println(task6("10%"));
        System.out.println(task6("53%", "79%"));

        System.out.println(task7("ладья", "A8", "H8"));
        System.out.println(task7("слон", "A7", "G1"));
        System.out.println(task7("ферзь", "C4", "D6"));

        System.out.println(task8(523, 76));
        System.out.println(task8(9132, 5564));
        System.out.println(task8(8732, 91255));

        System.out.println(task9("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println(task9("London", "July 31, 1983 23:01", "Rome"));
        System.out.println(task9("New York", "December 31, 1970 13:40", "Beijing"));

        System.out.println(task10(3));
        System.out.println(task10(30));
        System.out.println(task10(321));
        System.out.println(task10(123));
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

    public static int task5(int... nums) {
        if (nums.length == 0)
            return 0;

        int maxRun = 1;
        int currentRun = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1 || nums[i] == nums[i - 1] - 1) {
                currentRun++;
            } else {
                maxRun = Math.max(maxRun, currentRun);
                currentRun = 1;
            }
        }

        return Math.max(maxRun, currentRun);
    }

    public static String task6(String... scores) {
        int sum = 0;
        for (String score : scores) {
            sum += Integer.parseInt(score.replace("%", ""));
        }
        int currentAverage = sum / scores.length;
        int newAverage = currentAverage - 5;
        int requiredScore = newAverage * (scores.length + 1) - sum;
        return requiredScore + "%";
    }

    public static boolean task7(String chess, String start, String target) {
        int startX = start.charAt(0) - 'A' + 1;
        int startY = start.charAt(1) - '0';
        int targetX = target.charAt(0) - 'A' + 1;
        int targetY = target.charAt(1) - '0';

        switch (chess.toLowerCase()) {
            case "пешка":
                return startX == targetX && targetY - startY == 1;
            case "конь":
                return Math.abs(targetX - startX) == 2 && Math.abs(targetY - startY) == 1
                        || Math.abs(targetX - startX) == 1 && Math.abs(targetY - startY) == 2;
            case "слон":
                return Math.abs(targetX - startX) == Math.abs(targetY - startY);
            case "ладья":
                return startX == targetX || startY == targetY;
            case "ферзь":
                return startX == targetX || startY == targetY
                        || Math.abs(targetX - startX) == Math.abs(targetY - startY);
            case "король":
                return Math.abs(targetX - startX) <= 1 && Math.abs(targetY - startY) <= 1;
            default:
                return false;
        }
    }

    public static int task8(int num1, int num2) {
        char[] num1Chars = Integer.toString(num1).toCharArray();
        char[] num2Chars = Integer.toString(num2).toCharArray();

        Arrays.sort(num2Chars);
        StringBuilder num2Sorted = new StringBuilder(new String(num2Chars)).reverse();

        int num2Index = 0;
        for (int i = 0; i < num1Chars.length; i++) {
            if (num2Index < num2Sorted.length() && num1Chars[i] < num2Sorted.charAt(num2Index)) {
                num1Chars[i] = num2Sorted.charAt(num2Index++);
            }
        }

        return Integer.parseInt(new String(num1Chars));
    }

    private static final Map<String, Integer> timeOffsets = new HashMap<>() {
        {
            put("Los Angeles", -8 * 60);
            put("New York", -5 * 60);
            put("Caracas", -4 * 60 - 30);
            put("Buenos Aires", -3 * 60);
            put("London", 0);
            put("Rome", 1 * 60);
            put("Moscow", 3 * 60);
            put("Tehran", 3 * 60 + 30);
            put("New Delhi", 5 * 60 + 30);
            put("Beijing", 8 * 60);
            put("Canberra", 10 * 60);
        }
    };

    public static String task9(String cityA, String timestamp, String cityB) {
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM d, yyyy HH:mm", Locale.US);
        try {
            Date date = sdf.parse(timestamp);
            int offsetA = timeOffsets.get(cityA);
            int offsetB = timeOffsets.get(cityB);
            int timeDifference = offsetB - offsetA;
            long newTimeInMillis = date.getTime() + timeDifference * 60 * 1000;
            Date newDate = new Date(newTimeInMillis);
            SimpleDateFormat resultFormat = new SimpleDateFormat("yyyy-M-d HH:mm");
            return resultFormat.format(newDate);
        } catch (ParseException e) {
            return null;
        }
    }

    public static boolean task10(int num) {
        String strNum = Integer.toString(num);
        for (int i = 1; i < num; i++) {
            String strI = Integer.toString(i);
            char[] digitsNum = strNum.toCharArray();
            char[] digitsI = strI.toCharArray();
            Arrays.sort(digitsNum);
            Arrays.sort(digitsI);
            if (Arrays.equals(digitsNum, digitsI)) {
                return false;
            }
        }
        return true;
    }
}
