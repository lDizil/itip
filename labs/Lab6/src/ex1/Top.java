package ex1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Top {
    public static void main(String[] args) {
        File file = new File("D:\\Zone 51\\учеба вуз\\итип\\labs\\Lab6\\src\\ex1\\text.txt");

        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
            return;
        }

        Map<String, Integer> wordCounts = new HashMap<>();

        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase().replaceAll("[^a-zA-Zа-яА-Я0-9]", "");
            if (!word.isEmpty()) {
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }
        }

        scanner.close();

        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCounts.entrySet());

        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        System.out.println("Топ-10 слов:");
        for (int i = 0; i < Math.min(10, list.size()); i++) {
            Map.Entry<String, Integer> entry = list.get(i);
            System.out.println((i + 1) + ". " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
