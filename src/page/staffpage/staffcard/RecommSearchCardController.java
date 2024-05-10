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

public class RecommSearchCardController extends RecommCardController{
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

    public void addToRecomm() {
        if (!(StoreStorage.getStorage().getRecommendedItemsList().contains(this.storeItem)) && (StoreStorage.getStorage().getRecommendedItemsList().size() < 18)){
            StoreStorage.getStorage().getRecommendedItemsList().add(this.storeItem);
            Thread t = new Thread(() -> {
                try {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            /// remove card
                            UserPageManagementController.getInstance().getRecommBox().getChildren().add(cardBox);
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
