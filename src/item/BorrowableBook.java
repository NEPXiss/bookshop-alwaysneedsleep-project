package item;

import javafx.scene.image.Image;
import usage.BookGenre;
import usage.Orderable;

public class BorrowableBook extends Book implements Orderable {
    public BorrowableBook(int quantity, String itemLocation, BookGenre bookGenre, String title, String author, String imageByPath, String description, int rating) {
        super(quantity, itemLocation, bookGenre, title, author, imageByPath, description, rating);
    }
    @Override
    public boolean isOrderable() {
        if (this.getQuantity() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
