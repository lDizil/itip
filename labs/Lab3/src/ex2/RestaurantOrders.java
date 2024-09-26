package ex2;

import java.util.HashMap;
import java.util.Map;

public class RestaurantOrders {
    private HashMap<Integer, Order> orders;

    public RestaurantOrders() {
        orders = new HashMap<>();
    }

    // Метод для добавления заказа
    public void addOrder(int tableNumber, Order order) {
        orders.put(tableNumber, order);
        System.out.println("Added order for table " + tableNumber);
    }

    // Метод для получения заказа по номеру столика
    public Order getOrder(int tableNumber) {
        return orders.get(tableNumber);
    }

    // Метод для удаления заказа по номеру столика
    public void removeOrder(int tableNumber) {
        if (orders.remove(tableNumber) != null) {
            System.out.println("Order for table " + tableNumber + " removed.");
        } else {
            System.out.println("No order found for table " + tableNumber);
        }
    }

    // Метод для вывода всех заказов
    public void printAllOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders available.");
        } else {
            System.out.println("All orders:");
            for (Map.Entry<Integer, Order> entry : orders.entrySet()) {
                System.out.println("Table " + entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}