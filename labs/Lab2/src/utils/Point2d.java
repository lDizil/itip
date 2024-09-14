package utils;

public class Point2d {
    /**
     * координата X
     **/
    private double xCoord;
    /**
     * координата Y
     **/
    private double yCoord;

    /**
     * Конструктор инициализации
     **/

    public Point2d(double x, double y) {
        xCoord = x;
        yCoord = y;
    }

    /**
     * 
     * Конструктор по умолчанию.
     **/

    public Point2d() {
        this(0, 0);
    }

    /**
     * 
     * Возвращение координаты X
     **/

    public double getX() {
        return xCoord;
    }

    /**
     * 
     * Возвращение координаты Y
     **/

    public double getY() {
        return yCoord;
    }

    /**
     * 
     * Установка значения
     * координаты X.
     **/

    public void setX(double val) {
        xCoord = val;
    }

    /**
     * 
     * Установка значения
     * координаты Y.
     **/

    public void setY(double val) {
        yCoord = val;
    }

    public static void main(String[] args) {
        Point2d myPoint = new Point2d();
        myPoint.setX(3.0);
        myPoint.setY(4.0);
        System.out.println("UserPoint: (" + myPoint.getX() + ", " + myPoint.getY() + ")");
    }
}