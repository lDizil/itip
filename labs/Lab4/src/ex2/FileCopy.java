package ex2;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        File inputFile = new File("D:\\Zone 51\\учеба вуз\\итип\\labs\\Lab4\\src\\ex2\\input.txt");
        File outputFile = new File("D:\\Zone 51\\учеба вуз\\итип\\labs\\Lab4\\src\\ex2\\\\output.txt");

        try {

            compareFiles(inputFile, outputFile);
            System.out.println("Файлы уже одинаковы. Копирование не требуется.");

        } catch (CustomFilesNotEqualException e) {
            System.out.println("Файлы разные, начинаю копирование...");

            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    writer.write(line);
                    writer.newLine();
                }
                System.out.println("Файл успешно скопирован.");
            } catch (FileNotFoundException ex) {
                System.out.println("Ошибка: файл не найден.");
            } catch (IOException ex) {
                System.out.println("Ошибка ввода-вывода.");
            }
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода при сравнении файлов: " + e.getMessage());
        }
    }

    public static void compareFiles(File file1, File file2) throws CustomFilesNotEqualException, IOException {
        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1));
                BufferedReader reader2 = new BufferedReader(new FileReader(file2))) {

            String line1, line2;
            int lineNumber = 1;

            while ((line1 = reader1.readLine()) != null && (line2 = reader2.readLine()) != null) {
                if (!line1.equals(line2)) {
                    throw new CustomFilesNotEqualException("Файлы отличаются на строке " + lineNumber);
                }
                lineNumber++;
            }
        }
    }
}
