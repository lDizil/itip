package ex2;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        File inputFile = new File("D:\\Zone 51\\учеба вуз\\итип\\labs\\Lab4\\src\\input.txt");
        File outputFile = new File("D:\\Zone 51\\учеба вуз\\итип\\labs\\Lab4\\src\\output.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Файл успешно скопирован.");
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: файл не найден.");
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода.");
        }
    }
}
