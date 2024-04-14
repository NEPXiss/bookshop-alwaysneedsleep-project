package item;

import base.StoreItem;
import javafx.scene.image.Image;
import usage.BookGenre;


public abstract class Book extends StoreItem {
    private BookGenre bookGenre;
    private String title;
    private String author;
    private Image image;
    private String description;
    private int rating;

    public Book(int quantity, String itemLocation, BookGenre bookGenre, String title, String author, String imageByPath, String description, int rating) {
        super(quantity, itemLocation);
        this.bookGenre = bookGenre;
        this.title = title;
        this.author = author;
        setImageByPath(imageByPath);
        this.description = description;
        if (rating < 0) {
            this.rating = 0;
        } else if (rating > 5) {
            this.rating = 5;
        }
    }

    public BookGenre getBookGenre() {
        return bookGenre;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Image getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public int getRating() {
        return rating;
    }

    public void setBookGenre(BookGenre bookGenre) {
        this.bookGenre = bookGenre;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(int rating) {
        if (rating < 0) {
            this.rating = 0;
        } else if (rating > 5) {
            this.rating = 5;
        }
    }
}
