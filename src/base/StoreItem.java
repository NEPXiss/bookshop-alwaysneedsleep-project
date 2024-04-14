package base;

public abstract class StoreItem {
    private int quantity;
    private String itemLocation;

    public StoreItem(int quantity, String itemLocation) {
        this.quantity = quantity;
        this.itemLocation = itemLocation;
    }

    public boolean isAvailable() {
        if (quantity > 0) {
            return true;
        } else {
            return false;
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public String getItemLocation() {
        return itemLocation;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setItemLocation(String itemLocation) {
        this.itemLocation = itemLocation;
    }
}
