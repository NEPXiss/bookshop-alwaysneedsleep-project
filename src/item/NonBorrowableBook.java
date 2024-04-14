package item;

import javafx.scene.image.Image;
import usage.BookGenre;

public class NonBorrowableBook extends Book{
    public NonBorrowableBook(int quantity, String itemLocation, BookGenre bookGenre, String title, String author, String imageByPath, String description, int rating) {
        super(quantity, itemLocation, bookGenre, title, author, imageByPath, description, rating);
    }
}
