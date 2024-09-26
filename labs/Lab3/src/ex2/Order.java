package ex2;

public class Order {
    private String dishes;
    private double price;
    private String orderTime;

    public Order(String dishes, double price, String orderTime) {
        this.dishes = dishes;
        this.price = price;
        this.orderTime = orderTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "dishes='" + dishes + '\'' +
                ", price=" + price +
                ", orderTime='" + orderTime + '\'' +
                '}';
    }
}
