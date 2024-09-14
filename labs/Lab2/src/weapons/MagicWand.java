package weapons;

public class MagicWand extends Weapons {
    private int spellPower;
    private String wandMaterial;

    public MagicWand(String name, int damage, int spellPower, String wandMaterial) {
        super(name, damage);
        this.spellPower = spellPower;
        this.wandMaterial = wandMaterial;
    }

    public int getSpellPower() {
        return spellPower;
    }

    public void setSpellPower(int spellPower) {
        this.spellPower = spellPower;
    }

    public String getWandMaterial() {
        return wandMaterial;
    }

    public void setWandMaterial(String wandMaterial) {
        this.wandMaterial = wandMaterial;
    }

    @Override
    public void attack() {
        System.out.println("The magic wand casts a spell with " + getDamage() + " damage. It has a spell power of "
                + spellPower + " and is made of " + wandMaterial + ".");
    }
}
