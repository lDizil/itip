package weapons;

public class Sword extends Weapons {
    private int length;
    private String material;

    public Sword() {
        super("Unknow Sword", 0);
        this.length = 0;
        this.material = "Unknown";
    }

    public Sword(String name, int damage, int length, String material) {
        super(name, damage);
        this.length = length;
        this.material = material;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public void attack() {
        if (getDamage() == 0) {
            System.out.println("The sword attacks with unknown damage. It is " + length +
                    " cm long and made of " + material + ".");
        } else {
            System.out.println("The sword slashes with " + getDamage() + " damage. It is " + length +
                    " cm long and made of " + material + ".");
        }
    }

    // Перегруженный метод attack
    public void attack(String attackType) {
        if (getDamage() == 0) {
            System.out.println("The sword performs a " + attackType + " attack with unknown damage. It is " + length +
                    " cm long and made of " + material + ".");
        } else {
            System.out.println(
                    "The sword performs a " + attackType + " attack with " + getDamage() + " damage. It is " + length +
                            " cm long and made of " + material + ".");
        }
    }
}
