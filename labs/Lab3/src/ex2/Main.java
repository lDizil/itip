package ex2;

public class Main {
    public static void main(String[] args) {
        RestaurantOrders restaurantOrders = new RestaurantOrders();

        // Добавляем заказы
        restaurantOrders.addOrder(1, new Order("Pizza, Salad", 20.0, "12:30"));
        restaurantOrders.addOrder(2, new Order("Pasta, Coke", 15.0, "13:00"));
        restaurantOrders.addOrder(3, new Order("Burger, Fries", 18.5, "14:00"));

        // Поиск заказа по номеру столика

        Order order = restaurantOrders.getOrder(2);
        System.out.println("Order for table " + 2 + ": " + order);

        // Удаление заказа
        restaurantOrders.removeOrder(1);

        // Печать всех заказов
        restaurantOrders.printAllOrders();
    }
}
