package ex2;

import java.util.concurrent.*;
import java.util.List;
import java.util.ArrayList;

public class MaxInRowTask implements Callable<Integer> {
    private int[] row;

    public MaxInRowTask(int[] row) {
        this.row = row;
    }

    @Override
    public Integer call() {
        int max = row[0];
        for (int num : row) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[5][5];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 100);
            }
        }

        System.out.println("Матрица:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<Callable<Integer>> tasks = new ArrayList<>();
        for (int[] row : matrix) {
            tasks.add(new MaxInRowTask(row));
        }

        try {
            List<Future<Integer>> results = executor.invokeAll(tasks);

            int maxValue = Integer.MIN_VALUE;
            for (Future<Integer> result : results) {
                try {
                    int rowMax = result.get();
                    if (rowMax > maxValue) {
                        maxValue = rowMax;
                    }
                } catch (ExecutionException e) {
                    System.out.println("Ошибка при выполнении задачи: " + e.getCause());
                }
            }

            System.out.println("Максимальное значение: " + maxValue);
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван: " + e.getMessage());
            Thread.currentThread().interrupt();
        } finally {
            executor.shutdown();
        }
    }
}
