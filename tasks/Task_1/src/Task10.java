public class Task10 {
    public static void main(String[] args) {
        int students = 53;
        int tables = 58;
        int requiredTables = (int) Math.ceil(students / 2.0);
        int result = (requiredTables > tables) ? (requiredTables - tables) : 0;
        System.out.println(result);
    }
}
