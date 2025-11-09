package equipment;

import java.io.Serial;
import java.io.Serializable;

abstract public class Weapon extends Ammunition implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final double damage;

    public Weapon(String name, double weight, double price, double damage) {
        super(name, weight, price);
        this.damage = damage;
    }

    public double getDamage() {
        return damage;
    }

    @Override
    public String getSlotType() {
        return "WEAPON";
    }

    @Override
    public String toString() {
        String baseInfo = super.toString();
        return String.format("%s, Damage: %.1f", baseInfo, getDamage());
    }
}
