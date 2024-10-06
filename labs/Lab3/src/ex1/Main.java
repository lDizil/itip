package ex1;

public class Main {
    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>();

        hashTable.put("apple", 5);
        hashTable.put("banana", 3);
        hashTable.put("orange", 7);
        hashTable.put("fish", 6);
        hashTable.put("fish", 7);

        System.out.println("Value for 'banana': " + hashTable.get("banana"));

        System.out.println("Size: " + hashTable.size());

        hashTable.remove("banana");
        System.out.println("Value for 'banana' after remove: " + hashTable.get("banana"));

        System.out.println("Size: " + hashTable.size());

        System.out.println("Is empty: " + hashTable.isEmpty());

        hashTable.printAll();

        for (int i = 1; i <= 30; i++) {
            hashTable.put("key" + i, i);
            System.out.println("Added key" + i + ": " + i);
            System.out.println("Current table size: " + hashTable.getTableLength());
            hashTable.printAll();
        }

    }
}
