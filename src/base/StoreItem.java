package base;


import javafx.scene.image.Image;

public abstract class StoreItem {
    private int quantity;
    private String itemLocation;

    private Image image;

    public StoreItem(int quantity, String itemLocation, String imageByPath) {
        this.quantity = quantity;
        this.itemLocation = itemLocation;
        setImageByPath(imageByPath);
    }

    public boolean isAvailable() {
        if (quantity > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void setImageByPath(String imagePath) {
        try {
            String classLoaderPath = ClassLoader.getSystemResource(imagePath).toString();
            this.image = new Image(classLoaderPath);
        } catch (Exception e) {
            String classLoaderPath = ClassLoader.getSystemResource("default.png").toString();
            this.image = new Image(classLoaderPath);
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

    public Image getImage() { return image;}
}
