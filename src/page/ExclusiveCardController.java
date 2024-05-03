package page;

import base.StoreItem;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
    }

    public HBox getItemCard() {
        return itemCard;
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
        if (itemGenre.equals(ItemGenre.FICTION)){
            genreLabel.setText("Fiction");
        } else if (itemGenre.equals(ItemGenre.EDUCATION)) {
            genreLabel.setText("Education");
        } else if (itemGenre.equals(ItemGenre.HISTORY)) {
            genreLabel.setText("History");
        } else if (itemGenre.equals(ItemGenre.SCIENCE)) {
            genreLabel.setText("Science");
        } else if (itemGenre.equals(ItemGenre.PSYCHOLOGY)) {
            genreLabel.setText("Psychology");
        } else if (itemGenre.equals(ItemGenre.STATIONERY)) {
            genreLabel.setText("Stationery");
        }
    }

    public void setPriceLabel(double price) {
        this.priceLabel.setText(price + "฿ ");
    }

    public void setStarLabel(int starRate) {
        String stars = "";
        for (int i=0; i < starRate; i++) {
        stars += "★";
        }
        this.starLabel.setText(stars);
    }
}
