public class Task1 {
    public static void main(String[] args) {
        int gallons = 3;
        double liters = gallonsToLiters(gallons);
        System.out.println(gallons + " галлонов = " + liters + " литров");
    }

    public static double gallonsToLiters(int gallons) {
        double liters = 3.78541 * gallons;
        return liters;
    }
}
