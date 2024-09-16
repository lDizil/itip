package weapons;

public class Main {
    public static void main(String[] args) {

        Sword sword1 = new Sword("Big Pierre's sword", 120, 200, "Steel");
        Bow bow1 = new Bow("Auriel's Bow", 60, 20, "100 meters");
        MagicWand wand1 = new MagicWand("Elder Wand", 70, 90, "Elder");

        // Демонстрация работы конструктора по умолчанию
        Sword sword2 = new Sword();
        sword2.setLength(100);
        sword2.setMaterial("Iron");

        System.out.println("Weapon Details:");
        System.out.println("----------------");
        sword1.attack();
        bow1.attack();
        wand1.attack();
        sword2.attack("Fiery Chopping");

        System.out.println("----------------");
        System.out.println("Total number of weapons created: " + Weapons.getTotalWeapons());
    }
}
