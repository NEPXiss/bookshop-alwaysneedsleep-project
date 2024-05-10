package page.staffpage.staffcard;

import application.Main;
import base.StoreItem;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import page.staffpage.ItemStaffPageController;
import page.staffpage.UserPageManagementController;
import store.StoreStorage;

public class NewArrivalSearchCardController extends NewArrivalCardController{
    @FXML
    private Label titleLabel;
    @FXML
    private HBox cardBox;
    private StoreItem storeItem;
    @Override
    public void setCard(StoreItem storeItem) {
        super.setCard(storeItem);
        this.storeItem = storeItem;
    }

    public void onMouseClickTitleLabel(){
        Main itemStaffPage = Main.getInstance();
        itemStaffPage.changeScene("/page/staffpage/ItemStaffPage.fxml");

        ///Set page
        ItemStaffPageController.getInstance().setPage(this.storeItem);
    }

    public void addToNewArrivals() {
        if (!(StoreStorage.getStorage().getNewArrivalList().contains(this.storeItem))){
            StoreStorage.getStorage().getNewArrivalList().add(this.storeItem);
            Thread t = new Thread(() -> {
                try {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            /// remove card
                            UserPageManagementController.getInstance().getNewArrivalBox().getChildren().add(cardBox);
                        }
                    });
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            t.start();
        } else {
        }
    }

    public void onEnterTitleLabel(){
        titleLabel.setTextFill(Color.web("3737D5"));
    }
    public void onExitTitleLabel() {
        titleLabel.setTextFill(Color.BLACK);
    }
}
