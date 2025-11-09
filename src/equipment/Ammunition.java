package equipment;

import java.io.Serial;
import java.io.Serializable;

abstract public class Ammunition implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final String name;
    private final double weight;
    private final double price;

    public Ammunition(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    abstract public String getSlotType();

    @Override
    public String toString() {
        return String.format("Name: %s, Weight(in kg): %.1f, Price(in usd): %.2f",
                getName(), getWeight(), getPrice());
    }
}

