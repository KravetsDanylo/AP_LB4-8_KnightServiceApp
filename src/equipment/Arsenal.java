package equipment;

import java.util.ArrayList;
import java.util.List;
import java.io.Serial;
import java.io.Serializable;

public class Arsenal implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private List<Ammunition> availableItems;

    public Arsenal() {
        this.availableItems = new ArrayList<>();
    }

    public List<Ammunition> getAvailableItems() {
        return availableItems;
    }

    public void setAvailableItems(List<Ammunition> availableItems) {
        this.availableItems = availableItems;
    }

    public boolean addItem(Ammunition item) {
        if(item == null){
            throw new IllegalArgumentException("Item cannot be null");
        }
        return availableItems.add(item);
    }

    public boolean removeItem(Ammunition item) {
        if (item == null) {
            return false;
        }
        return availableItems.remove(item);
    }
}
