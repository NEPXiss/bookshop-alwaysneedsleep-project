package page.staffpage.staffcard;

import application.Main;
import base.StoreItem;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import page.card.WishlistCardController;
import page.staffpage.ItemStaffPageController;
import page.userpage.BookPageController;

public class ItemCardController extends WishlistCardController {
    @FXML
    private Label titleLabel;
    @FXML
    private Label shelfLabel;
    @FXML
    private Label quantityLabel;
    private StoreItem storeItem;

    @Override
    public void setCard(StoreItem storeItem) {
        super.setCard(storeItem);
        this.storeItem = storeItem;
        shelfLabel.setText(storeItem.getItemLocation());
        quantityLabel.setText(String.valueOf(storeItem.getQuantity()));
    }

    public void onMouseClickTitleLabel(){
        Main itemStaffPage = Main.getInstance();
        itemStaffPage.changeScene("/page/staffpage/ItemStaffPage.fxml");

        ///Set page
        ItemStaffPageController.getInstance().setPage(this.storeItem);
    }

    public void onEnterTitleLabel(){
        titleLabel.setTextFill(Color.web("3737D5"));
    }
    public void onExitTitleLabel() {
        titleLabel.setTextFill(Color.BLACK);
    }
}
