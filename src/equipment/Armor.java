package equipment;

import java.io.Serial;
import java.io.Serializable;

abstract public class Armor extends Ammunition implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final double defence;

    public Armor(String name, double weight, double price, double defence) {
        super(name, weight, price);
        this.defence = defence;
    }

    public double getDefence() {
        return defence;
    }

    @Override
    public String toString() {
        String baseInfo = super.toString();
        return String.format("%s, Defence: %.1f", baseInfo, getDefence());
    }
}
