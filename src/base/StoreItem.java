package base;

import javafx.scene.image.Image;
import store.StoreStorage;
import usage.ItemGenre;
import usage.Orderable;

public abstract class StoreItem implements Orderable {
    private int quantity;
    private String itemLocation;
    private String title;
    private Image image;
    private ItemGenre itemGenre;
    private double price;
    private String authorBrand;
    private String imagePath;
    private int rating;
    private String description;

    public StoreItem(String title, String authorBrand, ItemGenre itemGenre, double price, int rating, int quantity, String itemLocation, String imageByPath, String description) {
        this.title = title;
        this.authorBrand = authorBrand;
        this.quantity = quantity;
        this.itemGenre = itemGenre;
        this.price = price;
        setRating(rating);
        this.itemLocation = itemLocation;
        this.imagePath = imageByPath;
        setImageByPath(imageByPath);
        this.description = description;

    }

    public void removeItself() {
        StoreStorage.getStorage().getShelfMap().remove(this);
        StoreStorage.getStorage().getRecommendedItemsList().remove(this);
        StoreStorage.getStorage().getNewArrivalList().remove(this);
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
            String classLoaderPath = ClassLoader.getSystemResource("default/defaultbook.png").toString();
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
    public void setTitle(String title) {
        this.title = title;
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

    public void setAuthorBrand(String authorBrand) {
        this.authorBrand = authorBrand;
    }

    public int getRating() {
        return rating;
    }

    public Image getImage() {
        return image;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setItemGenre(ItemGenre itemGenre){
        this.itemGenre = itemGenre;
    }

    public void setRating(int rating) {
        if (rating < 1) {
            this.rating = 1;
        } else if (rating > 5) {
            this.rating = 5;
        } else {
            this.rating = rating;
        }
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getFullDescription(){
        return "StoreItem : " + getItemGenre().toString() + "\n\n" + description;
    }
}
