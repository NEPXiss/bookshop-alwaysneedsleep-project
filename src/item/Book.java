package item;

import base.StoreItem;
import usage.ItemGenre;


public class Book extends StoreItem {
    private String description;

    public Book(String title, String authorBrand, ItemGenre itemGenre, double price, int rating, int quantity, String itemLocation, String imageByPath) {
        super(title, authorBrand, itemGenre, price, rating, quantity, itemLocation, imageByPath);
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
