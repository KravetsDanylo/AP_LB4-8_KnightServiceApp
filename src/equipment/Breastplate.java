package equipment;

import java.io.Serial;
import java.io.Serializable;

public class Breastplate extends Armor implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final String material;

    public Breastplate(String name, double weight, double price, double defence, String material) {
        super(name, weight, price, defence);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        String baseInfo = super.toString();
        return String.format("%s, Material: %s", baseInfo, getMaterial());
    }

    @Override
    public String getSlotType() {
        return "CHEST";
    }
}
