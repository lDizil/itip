public class Task8 {
    public static void main(String[] args) {
        int num1 = 48;
        int num2 = 18;

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
