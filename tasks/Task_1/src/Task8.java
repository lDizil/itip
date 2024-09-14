public class Task8 {
    public static void main(String[] args) {
        int num1 = 259;
        int num2 = 28;

        int gcd = findGCD(num1, num2);
        System.out.println(gcd);
    }

    public static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }
}
