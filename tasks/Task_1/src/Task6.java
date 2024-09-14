public class Task6 {
    public static void main(String[] args) {
        System.out.println(amount(22, 1.4, 2));
        System.out.println(amount(45, 1.8, 1.9));
        System.out.println(amount(100, 2, 2));
    }

    public static int amount(int n, double w, double h) {
        double Fabric = n;
        double Detail = w * h * 2;

        int number = (int) (Fabric / Detail);

        return number;
    }

}
