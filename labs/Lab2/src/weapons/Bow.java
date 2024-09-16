package weapons;

public class Bow extends Weapons {

    private int strength;
    private String range;

    public Bow(String name, int damage, int strength, String range) {
        super(name, damage);
        this.strength = strength;
        this.range = range;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    @Override
    public void attack() {
        System.out
                .println("The " + getName() + " shoots an arrow with " + getDamage() + " damage. It has low strength: "
                        + strength + ", and arrow max range distance " + range + ".");
    }
}
