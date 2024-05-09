package item;

import base.StoreItem;
import usage.ItemGenre;


public class Book extends StoreItem {

    public Book(String title, String authorBrand, ItemGenre itemGenre, double price, int rating, int quantity, String itemLocation, String imageByPath, String description) {
        super(title, authorBrand, itemGenre, price, rating, quantity, itemLocation, imageByPath, description);
    }

    @Override
    public String getFullDescription(){
        return "BOOK : " + getItemGenre().toString() + "\n\n" + this.getDescription();  //POLYMORPHISM
    }
}
