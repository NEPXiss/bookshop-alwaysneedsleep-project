package page.staffpage;

import base.StoreItem;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import page.staffpage.staffcard.ItemCardController;
import store.ProgramController;
import store.StoreStorage;
import utils.Config;

public class ProductManagementController extends StaffPage {
    @FXML
    private Label logOutLabel;
    @FXML
    private ImageView profileAvatarIcon;
    @FXML
    private Label usernameLabel;
    @FXML
    private ImageView topLeftIconLogo;
    @FXML
    private VBox productBox;
    @FXML
    private TextField searchTextField;

    private static ProductManagementController instance;

    public ProductManagementController(){
        ProductManagementController.instance = this;
    }

    public static ProductManagementController getInstance(){
        if (instance == null) {
            ProductManagementController.instance = new ProductManagementController();
        }
        return instance;
    }

    public void setPage(String input){
        /// POLYMORPHISM
        usernameLabel.setText(ProgramController.getInstance().getEnteredAccount().getDisplayUsername());

        /// Set Avatar Icon
        try {
            String classLoaderPath = ClassLoader.getSystemResource(Config.profileImage).toString();
            Image profileImage = new Image(classLoaderPath);
            profileAvatarIcon.setImage(profileImage);
        } catch (Exception e) {
        }

        /// Set Top Left Logo
        try {
            String classLoaderPath = ClassLoader.getSystemResource(Config.logoImage1).toString();
            Image profileImage = new Image(classLoaderPath);
            topLeftIconLogo.setImage(profileImage);
        } catch (Exception e) {
        }

        Thread t = new Thread(() -> {
            try {
                setProductBox(input);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        t.start();
    }

    public void setProductBox(String input) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if (input.isEmpty()) {
                    productBox.getChildren().clear();
                    for (StoreItem item : StoreStorage.getStorage().getShelfMap().keySet()) {
                        FXMLLoader fxmlLoader = new FXMLLoader();
                        fxmlLoader.setLocation(getClass().getResource("../staffpage/staffcard/ItemCard.fxml"));
                        HBox itemCard = null;
                        try {
                            itemCard = fxmlLoader.load();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        ItemCardController itemCardController = fxmlLoader.getController();
                        itemCardController.setCard(item);
                        productBox.getChildren().add(itemCard);
                    }
                } else {
                    productBox.getChildren().clear();
                    for (StoreItem item : StoreStorage.getStorage().getShelfMap().keySet()) {
                        if ((item.getTitle().toLowerCase().contains(input.toLowerCase())) || (item.getAuthorBrand().toLowerCase().contains(input.toLowerCase()))){
                            FXMLLoader fxmlLoader = new FXMLLoader();
                            fxmlLoader.setLocation(getClass().getResource("../staffpage/staffcard/ItemCard.fxml"));
                            HBox itemCard = null;
                            try {
                                itemCard = fxmlLoader.load();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                            ItemCardController itemCardController = fxmlLoader.getController();
                            itemCardController.setCard(item);
                            productBox.getChildren().add(itemCard);
                        }
                    }
                }
            }
        });
    }

    public void onSetSearchBoxClicked() {
        setPage(searchTextField.getText());
    }

    @Override
    public void logOutLabelClicked() {
        super.logOutLabelClicked();
    }

    @Override
    public void topLeftLabelClicked() {
        super.topLeftLabelClicked();
    }

    /// All methods below are related to "graphical" FX EventHandler
    public void onMouseEnterLogOutButton() {
        logOutLabel.setBackground(Background.fill(Color.web("D4D4D4")));
    }
    public void onMouseExitLogOutButton() {
        logOutLabel.setBackground(Background.fill(Color.web("FFFFFF")));
    }
}
