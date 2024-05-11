package page.card;

import application.Main;
import base.StoreItem;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import page.userpage.BookPageController;
import usage.ItemGenre;

public class OrderDetailCardController {
    @FXML
    private Label titleLabel;
    @FXML
    private Label authorBrandLabel;
    @FXML
    private Label genreLabel;
    @FXML
    private Label quantityLabel;
    @FXML
    private Label totalPriceLabel;
    @FXML
    private ImageView itemImage;
    private StoreItem storeItem;

    public void setCard(StoreItem storeItem, int quantity) {
        this.storeItem = storeItem;
        this.titleLabel.setText(storeItem.getTitle());
        this.authorBrandLabel.setText(storeItem.getAuthorBrand());
        setGenreLabel(storeItem.getItemGenre());
        this.itemImage.setImage(storeItem.getImage());
        this.quantityLabel.setText(String.valueOf(quantity));
        double totalPrice = storeItem.getPrice()*quantity;
        this.totalPriceLabel.setText(totalPrice + " ฿");
    }

    public void onMouseClickTitleLabel(){
        Main bookPage = Main.getInstance();
        bookPage.changeScene("/page/userpage/BookPageInterface.fxml");

        ///Set up -> setPage and setMoreFromThisAuthor
        BookPageController.getInstance().setPage(this.storeItem);
        Thread t = new Thread(() -> {
            try {
                BookPageController.getInstance().setMoreFromThisBox(this.storeItem);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        t.start();
    }

    public void setGenreLabel(ItemGenre itemGenre) {
        if (itemGenre.equals(ItemGenre.FICTION)) {
            genreLabel.setText("Fiction");
        } else if (itemGenre.equals(ItemGenre.EDUCATION)) {
            genreLabel.setText("Education");
        } else if (itemGenre.equals(ItemGenre.HISTORY)) {
            genreLabel.setText("History & Politics");
        } else if (itemGenre.equals(ItemGenre.SCIENCE)) {
            genreLabel.setText("Science");
        } else if (itemGenre.equals(ItemGenre.PSYCHOLOGY)) {
            genreLabel.setText("Psychology");
        } else if (itemGenre.equals(ItemGenre.PHILOSOPHY)) {
            genreLabel.setText("Philosophy");
        }
    }

    public void onEnterTitleLabel(){
        titleLabel.setTextFill(Color.web("3737D5"));
    }

    public void onExitTitleLabel() {
        titleLabel.setTextFill(Color.BLACK);
    }
}
