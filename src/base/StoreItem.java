package base;

import javafx.scene.image.Image;
import usage.ItemGenre;
import usage.Orderable;

public abstract class StoreItem implements Orderable {
    private int quantity;
    private String itemLocation;
    private final String title;
    private Image image;
    private final ItemGenre itemGenre;
    private double price;
    private final String authorBrand;
    private int rating;

    public StoreItem(String title, String authorBrand, ItemGenre itemGenre, double price, int rating, int quantity, String itemLocation, String imageByPath) {
        this.title = title;
        this.authorBrand = authorBrand;
        this.quantity = quantity;
        this.itemGenre = itemGenre;
        this.price = price;
        setRating(rating);
        this.itemLocation = itemLocation;
        setImageByPath(imageByPath);

    }

    @Override
    public boolean isOrderable() {
        if (this.getQuantity() > 0) {
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
            String classLoaderPath = ClassLoader.getSystemResource("defaultbook.png").toString();
            this.image = new Image(classLoaderPath);
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public String getTitle() {
        return title;
    }

    public ItemGenre getItemGenre() {
        return itemGenre;
    }

    public double getPrice() {
        return price;
    }

    public String getAuthorBrand() {
        return authorBrand;
    }

    public int getRating() {
        return rating;
    }

    public Image getImage() {
        return image;
    }

    public void setRating(int rating) {
        if (rating < 0) {
            this.rating = 0;
        } else if (rating > 5) {
            this.rating = 5;
        } else {
            this.rating = rating;
        }
    }
}
