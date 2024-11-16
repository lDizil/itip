package ex3;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class Shop {
    private final ConcurrentHashMap<String, Integer> sold = new ConcurrentHashMap<>();

    public void addSale(String product, int quantity) {
        sold.merge(product, quantity, Integer::sum);
    }

    public void soldList() {
        if (sold.isEmpty()) {
            System.out.println("Проданных товаров нет");
        } else {
            System.out.println("Список проданных товаров:");
            sold.forEach((product, quantity) -> System.out.println(product + ": " + quantity + " шт."));
        }
    }

    public int totalSales() {
        return sold.values().stream().mapToInt(Integer::intValue).sum();
    }

    public String getMostPopularProduct() {
        return sold.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Нет продаж");
    }

    public static void main(String[] args) {
        Shop tracker = new Shop();

        tracker.addSale("Яблоки", 10);
        tracker.addSale("Апельсины", 5);
        tracker.addSale("Яблоки", 3);
        tracker.addSale("Бананы", 7);

        tracker.soldList();

        System.out.println("Общее количетсво продаж: " + tracker.totalSales() + " шт.");

        System.out.println("Самый популярный товар: " + tracker.getMostPopularProduct());
    }
}
