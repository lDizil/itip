public class Task10 {
    public static void main(String[] args) {
        int students = 5;
        int tables = 2;
        int result = ((tables * 2 - students) < 1) ? (students - tables * 2) : 0;
        System.out.println(result);
    }
}
