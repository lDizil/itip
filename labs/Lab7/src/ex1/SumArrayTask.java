package ex1;

import java.util.concurrent.*;

public class SumArrayTask implements Callable<Integer> {

    public static void main(String[] args) {
        int[] array = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = 1 + i;
        }

        ExecutorService executor = Executors.newFixedThreadPool(2);
        int middle = array.length / 2;
        Callable<Integer> task1 = new SumArrayTask(array, 0, middle);
        Callable<Integer> task2 = new SumArrayTask(array, middle, array.length);

        try {
            Future<Integer> result1 = executor.submit(task1);
            Future<Integer> result2 = executor.submit(task2);

            int totalSum = result1.get() + result2.get();
            System.out.println(totalSum);
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван: " + e.getMessage());
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            System.out.println("Ошибка выполнения задачи: " + e.getCause());
        } finally {
            executor.shutdown();
        }
    }

    private int[] array;
    private int start;
    private int end;

    public SumArrayTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
        return sum;
    }

}
