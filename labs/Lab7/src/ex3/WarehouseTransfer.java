package ex3;

import java.util.concurrent.*;
import java.util.ArrayList;
import java.util.List;

class Warehouse {
    private final List<Integer> items;
    private final Object lock = new Object();

    public Warehouse(int[] items) {
        this.items = new ArrayList<>();
        for (int item : items) {
            this.items.add(item);
        }
    }

    public int getNextItem() {
        synchronized (lock) {
            if (!items.isEmpty()) {
                return items.remove(0);
            } else {
                return -1;
            }
        }
    }

    public void returnItem(int item) {
        synchronized (lock) {
            items.add(0, item);
        }
    }

    public boolean hasMoreItems() {
        synchronized (lock) {
            return !items.isEmpty();
        }
    }
}

class Worker extends Thread {
    private final CyclicBarrier barrier;
    private final Warehouse warehouse;
    private final int workerId;
    private final int totalWorkers;
    private static final List<Integer> currentBatch = new ArrayList<>();
    private static final Object weightLock = new Object();
    private static int totalWeight = 0;
    private static final int MAX_WEIGHT = 150;
    private static int currentTurn = 1;

    public Worker(CyclicBarrier barrier, Warehouse warehouse, int workerId, int totalWorkers) {
        this.barrier = barrier;
        this.warehouse = warehouse;
        this.workerId = workerId;
        this.totalWorkers = totalWorkers;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int item = -1;

                synchronized (weightLock) {
                    while (currentTurn != workerId) {
                        weightLock.wait();
                    }

                    if (warehouse.hasMoreItems()) {
                        item = warehouse.getNextItem();
                        if (item != -1 && totalWeight + item <= MAX_WEIGHT) {
                            currentBatch.add(item);
                            totalWeight += item;
                            System.out.println("Грузчик " + workerId + " взял груз весом: " + item + " кг");
                        } else if (item != -1) {
                            warehouse.returnItem(item);
                        }
                    }

                    currentTurn = (currentTurn % totalWorkers) + 1;
                    weightLock.notifyAll();
                }

                barrier.await();

                if (workerId == 1) {
                    synchronized (weightLock) {
                        if (!currentBatch.isEmpty()) {
                            System.out.println("Грузчики переносят товары с общим весом: " + totalWeight + " кг");
                            Thread.sleep(1000);
                            System.out.println("Грузчики завершили перенос товаров.");
                            currentBatch.clear();
                            totalWeight = 0;
                        }
                    }
                }

                barrier.await();

                if (item == -1 && !warehouse.hasMoreItems()) {
                    break;
                }
            }
        } catch (InterruptedException | BrokenBarrierException e) {
            Thread.currentThread().interrupt();
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

        Warehouse warehouse = new Warehouse(items);
        CyclicBarrier barrier = new CyclicBarrier(3);

        Worker worker1 = new Worker(barrier, warehouse, 1, 3);
        Worker worker2 = new Worker(barrier, warehouse, 2, 3);
        Worker worker3 = new Worker(barrier, warehouse, 3, 3);

        worker1.start();
        worker2.start();
        worker3.start();

        try {
            worker1.join();
            worker2.join();
            worker3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Все грузчики завершили работу.");
    }
}
