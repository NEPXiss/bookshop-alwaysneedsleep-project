package item;

import javafx.scene.image.Image;
import usage.BookGenre;
import usage.Orderable;

public class SaleBook extends Book implements Orderable {
    private double price;

    public SaleBook(int quantity, String itemLocation, BookGenre bookGenre, String title, String author, String imageByPath, String description, int rating, double price) {
        super(quantity, itemLocation, bookGenre, title, author, imageByPath, description, rating);
        this.price = price;
    }

    @Override
    public boolean isOrderable() {
        if (this.getQuantity() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = Math.max(0,price);
    }
}
