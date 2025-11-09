package equipment;

import java.io.Serial;
import java.io.Serializable;

public class Spear extends Weapon implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final String tipType;

    public Spear(String name, double weight, double price, double damage, String tipType) {
        super(name, weight, price, damage);
        this.tipType = tipType;
    }

    public String getTipType() {
        return tipType;
    }

    @Override
    public String toString() {
        String baseInfo = super.toString();
        return String.format("%s, Tip type: %s", baseInfo, getTipType());
    }
}

