package ex3;

import java.util.concurrent.*;

class Worker extends Thread {
    private final CountDownLatch latch;
    private final int[] items;
    private final int maxWeight = 150;
    private final int workerId;
    private static int currentIndex = 0;
    private static final Object lock = new Object();

    public Worker(CountDownLatch latch, int[] items, int workerId) {
        this.latch = latch;
        this.items = items;
        this.workerId = workerId;
    }

    @Override
    public void run() {
        int weight = 0;
        while (true) {
            int item = 0;
            synchronized (lock) {
                if (currentIndex < items.length) {
                    item = items[currentIndex];
                    currentIndex++;
                } else {
                    break;
                }
            }

            if (weight + item > maxWeight) {
                synchronized (lock) {
                    currentIndex--;
                }
                break;
            }

            weight += item;
        }

        try {
            System.out.println("Грузчик " + workerId + " завершил с весом: " + weight + " кг");
        } catch (Exception e) {
            System.out.println("Ошибка при выводе данных для грузчика " + workerId + ": " + e.getMessage());
        } finally {
            latch.countDown();
        }
    }

    public static int getCurrentIndex() {
        synchronized (lock) {
            return currentIndex;
        }
    }
}

public class WarehouseTransfer {
    public static void main(String[] args) {
        int[] items = { 50, 60, 40, 20, 30, 60, 50, 70, 80, 40, 90, 30, 60, 80 };
        int totalWeight = 0;
        for (int item : items) {
            totalWeight += item;
        }

        System.out.println("Общий вес товаров: " + totalWeight + " кг");

        while (Worker.getCurrentIndex() < items.length) {
            CountDownLatch latch = new CountDownLatch(3);

            Worker worker1 = new Worker(latch, items, 1);
            Worker worker2 = new Worker(latch, items, 2);
            Worker worker3 = new Worker(latch, items, 3);

            worker1.start();
            worker2.start();
            worker3.start();

            try {
                latch.await();
                System.out.println(
                        "Цикл завершён. Осталось товаров: " + (items.length - Worker.getCurrentIndex()) + "\n");
            } catch (InterruptedException e) {
                System.out.println("Ошибка при ожидании завершения рабочих потоков: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Все товары были перенесены.");
    }
}
