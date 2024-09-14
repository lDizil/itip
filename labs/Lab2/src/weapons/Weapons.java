package weapons;

abstract class Weapons {
    private String name;
    protected int damage;
    private static int totalWeapons = 0;

    // Конструктор по умолчанию
    public Weapons() {
        this.name = "Unknown name";
        this.damage = 0;
        totalWeapons++;
    }

    // Конструктор с параметрами
    public Weapons(String name, int damage) {
        this.name = name;
        this.damage = damage;
        totalWeapons++;
    }

    // Геттеры и Сеттеры
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public static int getTotalWeapons() {
        return totalWeapons;
    }

    public abstract void attack();

}
