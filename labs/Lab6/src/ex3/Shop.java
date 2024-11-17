package ex3;

import java.util.concurrent.ConcurrentHashMap;
import java.util.List;
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

    public List<String> getMostPopularProducts() {
        int maxSales = sold.values().stream().mapToInt(Integer::intValue).max().orElse(0);
        if (maxSales == 0) {
            return List.of("Нет продаж");
        }

        return sold.entrySet().stream()
                .filter(entry -> entry.getValue() == maxSales)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static void main(String[] args) {
        Shop tracker = new Shop();

        tracker.addSale("Яблоки", 10);
        tracker.addSale("Апельсины", 6);
        tracker.addSale("Яблоки", 3);
        tracker.addSale("Бананы", 7);
        tracker.addSale("Апельсины", 7);

        tracker.soldList();

        System.out.println("Общее количетсво продаж: " + tracker.totalSales() + " шт.");

        System.out.println("Самые популярные товары: " + String.join(", ", tracker.getMostPopularProducts()));

    }
}
