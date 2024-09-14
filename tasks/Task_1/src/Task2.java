public class Task2 {
    public static void main(String[] args) {
        int time = 41;
        int intensive = 3;
        int cal = fitCalc(time, intensive);
        System.out.println(cal);
    }

    public static int fitCalc(int intensive, int time) {
        int cal = intensive * time;
        return cal;
    }
}
