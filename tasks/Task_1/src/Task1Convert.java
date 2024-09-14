public class Task1Convert {
    public static void main(String[] args) {
        int gallons = 8;
        double liters = gallonsToLiters(gallons);
        System.out.println(gallons + " галлонов = " + liters + " литров");
    }

    public static double gallonsToLiters(int gallons) {
        double liters = 3.78541 * gallons;
        return liters;
    }
}
