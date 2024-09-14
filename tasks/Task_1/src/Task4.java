public class Task4 {
    public static void main(String[] args) {
        int X = 3;
        int Y = 4;
        int Z = 5;
        System.out.println(getTriangleType(X, Y, Z));
    }

    public static String getTriangleType(int X, int Y, int Z) {
        if (X + Y <= Z || X + Z <= Y || Y + Z <= X) {
            return "not a triangle";
        }

        if (X == Y && Y == Z) {
            return "isosceles";
        }
        if (X == Y || Y == Z || X == Z) {
            return "equilateral";
        }
        return "different-sided";
    }

}
