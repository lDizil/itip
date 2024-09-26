package ex1;

public class Main {
    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>();

        // Добавляем элементы
        hashTable.put("apple", 5);
        hashTable.put("banana", 3);
        hashTable.put("orange", 7);
        hashTable.put("fish", 6);

        // Получаем значение по ключу
        System.out.println("Value for 'banana': " + hashTable.get("banana"));

        // Удаляем элемент
        hashTable.remove("banana");
        System.out.println("Value for 'banana' after removal: " + hashTable.get("banana"));

        // Размер таблицы
        System.out.println("Size: " + hashTable.size());

        // Проверка, пуста ли таблица
        System.out.println("Is empty: " + hashTable.isEmpty());

        hashTable.printAll();
    }
}
