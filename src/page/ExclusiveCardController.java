package page;

import application.Main;
import base.StoreItem;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import usage.ItemGenre;

public class ExclusiveCardController {
    @FXML
    private HBox itemCard;
    @FXML
    private ImageView itemImage;
    @FXML
    private Label itemTitleLabel;
    @FXML
    private Label authorBrandLabel;
    @FXML
    private Label genreLabel;
    @FXML
    private Label priceLabel;
    @FXML
    private Label starLabel;
    private StoreItem storeItem;
    private static ExclusiveCardController instance;

    public ExclusiveCardController() {
        ExclusiveCardController.instance = this;
    }

    public void setCard(StoreItem storeItem) {
        setItemImage(storeItem.getImage());
        setItemTitleLabel(storeItem.getTitle());
        setStarLabel(storeItem.getRating());
        setPriceLabel(storeItem.getPrice());
        setAuthorBrandLabel(storeItem.getAuthorBrand());
        setGenreLabel(storeItem.getItemGenre());
        this.storeItem = storeItem;
    }

    public StoreItem getStoreItem() {
        return storeItem;
    }

    public void setItemImage(Image itemImage) {
        this.itemImage.setImage(itemImage);
    }

    public void setItemTitleLabel(String itemTitle) {
        this.itemTitleLabel.setText(itemTitle);
    }

    public void setAuthorBrandLabel(String authorBrand) {
        this.authorBrandLabel.setText(authorBrand);
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
        } else if (itemGenre.equals(ItemGenre.STATIONERY)) {
            genreLabel.setText("Stationery");
        }
    }

    public void setPriceLabel(double price) {
        this.priceLabel.setText(price + "฿ ");
    }

    public void setStarLabel(int starRate) {
        String stars = "";
        for (int i = 0; i < starRate; i++) {
            stars += "★";
        }
        this.starLabel.setText(stars);
    }

    public void onMouseClickTitleLabel(){
        Main bookPage = Main.getInstance();
        bookPage.changeScene("../page/BookPageInterface.fxml");

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

    public void onEnterTitleLabel(){
        itemTitleLabel.setTextFill(Color.web("3737D5"));
    }

    public void onExitTitleLabel() {
        itemTitleLabel.setTextFill(Color.BLACK);
    }
}
