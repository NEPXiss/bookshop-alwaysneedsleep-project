package page;

import base.StoreItem;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CardController {
    @FXML
    private ImageView itemImage;
    @FXML
    private Label authorBrandLabel;
    @FXML
    private Label titleLabel;
    @FXML
    private Label starLabel;
    @FXML
    private Label priceLabel;
    private static CardController instance;

    public CardController() {CardController.instance = this;}

    public void setCard(StoreItem storeItem) {
        setItemImage(storeItem.getImage());
        setItemTitleLabel(storeItem.getTitle());
        setStarLabel(storeItem.getRating());
        setPriceLabel(storeItem.getPrice());
        setAuthorBrandLabel(storeItem.getAuthorBrand());
    }

    public void setItemImage(Image itemImage) {
        this.itemImage.setImage(itemImage);
    }
    public void setItemTitleLabel(String itemTitle) {
        this.titleLabel.setText(itemTitle);
    }
    public void setAuthorBrandLabel(String authorBrand) {
        this.authorBrandLabel.setText(authorBrand);
    }
    public void setStarLabel(int starRate) {
        String stars = "";
        for (int i = 0; i < starRate; i++) {
            stars += "★";
        }
        this.starLabel.setText(stars);
    }
    public void setPriceLabel(double price) {
        this.priceLabel.setText(price + "฿");
    }


}
