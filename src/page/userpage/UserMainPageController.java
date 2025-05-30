package page.userpage;

import application.Main;
import base.StoreItem;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import page.card.CardController;
import page.card.ExclusiveCardController;
import store.ProgramController;
import store.StoreStorage;
import utils.Config;

public class UserMainPageController extends UserPage {
    @FXML
    private Label usernameLabel;
    @FXML
    private Label logOutLabel;
    @FXML
    private Label cartLabel;
    @FXML
    private Label categoriesLabel;
    @FXML
    private Label wishlistLabel;
    @FXML
    private Label userOrdersLabel;
    @FXML
    private ImageView profileAvatarIcon;
    @FXML
    private HBox newArrivalsPane;
    @FXML
    private GridPane recommendedItemsPane;
    @FXML
    private ImageView topLeftIconLogo;
    @FXML
    private TextField searchTextField;
    private static UserMainPageController instance;

    public UserMainPageController() {
        UserMainPageController.instance = this;
    }

    public static UserMainPageController getInstance() {
        if (instance == null) {
            UserMainPageController.instance = new UserMainPageController();
        }
        return instance;
    }

    @Override
    public void setPage() {

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
                setNewArrivals();
                setRecommendedItems();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        t.start();
    }

    public void setNewArrivals() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                for (StoreItem item : StoreStorage.getStorage().getNewArrivalList()) {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("/page/card/ExclusiveCard.fxml"));
                    HBox itemCard = null;
                    try {
                        itemCard = fxmlLoader.load();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    ExclusiveCardController cardController = fxmlLoader.getController();
                    cardController.setCard(item);
                    newArrivalsPane.getChildren().add(itemCard);
                }
            }
        });
    }

    public void setRecommendedItems() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                int row = 0;
                int column = 0;
                for (StoreItem item : StoreStorage.getStorage().getRecommendedItemsList()) {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("/page/card/Card.fxml"));
                    VBox itemCard = null;
                    try {
                        itemCard = fxmlLoader.load();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    CardController cardController = fxmlLoader.getController();
                    cardController.setCard(item);
                    recommendedItemsPane.add(itemCard, column % 6, row % 6);

                    column += 1;
                    if ((column != 0) && (column % 6 == 0)) {
                        column = 0;
                        row += 1;
                    }
                }
            }
        });
    }

    /// All methods below are related to "functional" FX EventHandler
    public void userCartLabelClicked(){
        super.userCartLabelClicked();
    }

    public void logOutLabelClicked() {
        super.logOutLabelClicked();
    }

    public void onSearchButtonClicked(){
        Main searchPage = Main.getInstance();
        searchPage.changeScene("/page/userpage/SearchPageInterface.fxml");

        ///Set search Page
        SearchPageController.getInstance().setPage(this.searchTextField.getText());
    }

    public void onWishlistLabelClicked(){
        super.onWishlistLabelClicked();
    }

    public void categoriesLabelClicked(){
        super.categoriesLabelClicked();
    }
    public void onUserOrderLabelClicked() {super.onUserOrderLabelClicked();}


    /// All methods below are related to "graphical" FX EventHandler

    public void onMouseEnterLogOutButton() {
        logOutLabel.setBackground(Background.fill(Color.web("D4D4D4")));
    }

    public void onMouseExitLogOutButton() {
        logOutLabel.setBackground(Background.fill(Color.web("FFFFFF")));
    }

    public void onMouseEnterCartButton() {
        cartLabel.setBackground(Background.fill(Color.web("D4D4D4")));
    }

    public void onMouseExitCartButton() {
        cartLabel.setBackground(Background.fill(Color.web("FFFFFF")));
    }

    public void onMouseEnterCategoriesButton() {
        categoriesLabel.setBackground(Background.fill(Color.web("D4D4D4")));
    }

    public void onMouseExitCategoriesButton() {
        categoriesLabel.setBackground(Background.fill(Color.web("FFFFFF")));
    }

    public void onMouseEnterWishListButton() {
        wishlistLabel.setBackground(Background.fill(Color.web("D4D4D4")));
    }

    public void onMouseExitWishListButton() {
        wishlistLabel.setBackground(Background.fill(Color.web("FFFFFF")));
    }

    public void onMouseEnterUserOrdersButton() {
        userOrdersLabel.setBackground(Background.fill(Color.web("D4D4D4")));
    }

    public void onMouseExitUserOrdersButton() {
        userOrdersLabel.setBackground(Background.fill(Color.web("FFFFFF")));
    }

}
