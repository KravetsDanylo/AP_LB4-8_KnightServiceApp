package equipment;

import java.io.Serial;
import java.io.Serializable;

public class Helmet extends Armor implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final boolean hasVisor;

    public Helmet(String name, double weight, double price, double defence, boolean hasVisor) {
        super(name, weight, price, defence);
        this.hasVisor = hasVisor;
    }

    public boolean isHasVisor() {
        return hasVisor;
    }

    @Override
    public String toString() {
        String baseInfo = super.toString();
        String visorInfo = isHasVisor() ? "Is visor" : "Without visor";
        return String.format("%s, Visor type: %s", baseInfo, visorInfo);
    }

    @Override
    public String getSlotType() {
        return "HELMET";
    }
}
