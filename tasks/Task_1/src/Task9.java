public class Task9 {
    public static void main(String[] args) {
        int ticket = 53;
        int cost = 1250;
        int ticketSaler = (ticket * cost) - ((ticket * cost / 100) * 28);
        System.out.println(ticketSaler);
    }
}
