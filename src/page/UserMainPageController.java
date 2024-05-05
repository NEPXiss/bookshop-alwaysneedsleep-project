package page;

import application.Main;
import base.StoreItem;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import store.ProgramController;
import store.StoreStorage;
import utils.Config;

public class UserMainPageController {
    @FXML
    private Label usernameLabel;
    @FXML
    private Label logOutLabel;
    @FXML
    private Label bestSellersLabel;
    @FXML
    private Label categoriesLabel;
    @FXML
    private Label wishlistLabel;
    @FXML
    private Label userOrdersLabel;
    @FXML
    private Label settingLabel;
    @FXML
    private ImageView profileAvatarIcon;
    @FXML
    private HBox newArrivalsPane;
    @FXML
    private GridPane recommendedItemsPane;
    @FXML
    private ImageView topLeftIconLogo;
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

    public void reloadUserMainPage() {
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
                    fxmlLoader.setLocation(getClass().getResource("ExclusiveCard.fxml"));
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
                    fxmlLoader.setLocation(getClass().getResource("Card.fxml"));
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

    public void setUsernameLabel() {
        usernameLabel.setText(ProgramController.getInstance().getEnteredAccount().getUsername());
    }

    public void setProfileAvatarIcon() {
        try {
            String classLoaderPath = ClassLoader.getSystemResource(Config.profileImage).toString();
            Image profileImage = new Image(classLoaderPath);
            profileAvatarIcon.setImage(profileImage);
        } catch (Exception e) {
        }
    }

    public void setTopLeftIconLogo() {
        try {
            String classLoaderPath = ClassLoader.getSystemResource(Config.logoImage1).toString();
            Image profileImage = new Image(classLoaderPath);
            topLeftIconLogo.setImage(profileImage);
        } catch (Exception e) {
        }
    }

    public void logOutLabelClicked() {
        Main backToLogInPage = Main.getInstance();
        backToLogInPage.changeScene("../page/LoginInterface.fxml");

        ///Set logo image in LoginInterface
        LoginController.getInstance().setLogoImage();
    }


    /// All methods below are related to FX EventHandler

    public void onMouseEnterLogOutButton() {
        logOutLabel.setBackground(Background.fill(Color.web("D4D4D4")));
    }

    public void onMouseExitLogOutButton() {
        logOutLabel.setBackground(Background.fill(Color.web("FFFFFF")));
    }

    public void onMouseEnterBestSellersButton() {
        bestSellersLabel.setBackground(Background.fill(Color.web("D4D4D4")));
    }

    public void onMouseExitBestSellersButton() {
        bestSellersLabel.setBackground(Background.fill(Color.web("FFFFFF")));
    }

    public void onMouseEnterCategoriesButton() {
        categoriesLabel.setBackground(Background.fill(Color.web("D4D4D4")));
    }

    public void onMouseExitCategoriesButton() {
        categoriesLabel.setBackground(Background.fill(Color.web("FFFFFF")));
    }

    public void onMouseEnterSettingsButton() {
        settingLabel.setBackground(Background.fill(Color.web("D4D4D4")));
    }

    public void onMouseExitSettingsButton() {
        settingLabel.setBackground(Background.fill(Color.web("FFFFFF")));
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
