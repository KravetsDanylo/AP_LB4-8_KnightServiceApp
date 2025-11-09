package equipment;

import java.io.Serial;
import java.io.Serializable;

public class Sword extends Weapon implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final double bladeLength;
    private final boolean isOneHanded;

    public Sword(String name, double weight, double price, double damage, double bladeLength, boolean isOneHanded) {
        super(name, weight, price, damage);
        this.bladeLength = bladeLength;
        this.isOneHanded = isOneHanded;
    }

    public double getBladeLength() {
        return bladeLength;
    }

    public boolean isOneHanded() {
        return isOneHanded;
    }

    @Override
    public String toString() {
        String baseInfo = super.toString();
        String handType = isOneHanded() ? "One-handed" : "Two-handed";
        return String.format("%s, Blade length(in meter): %.1f, Type: %s", baseInfo, getBladeLength(), handType);
    }
}
