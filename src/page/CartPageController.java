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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import person.UserAccount;
import store.ProgramController;
import utils.Config;

public class CartPageController {
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
    private Label settingLabel;
    @FXML
    private ImageView profileAvatarIcon;
    @FXML
    private ImageView topLeftIconLogo;
    @FXML
    private VBox cartBox;
    @FXML
    private Label totalPriceLabel;
    private static CartPageController instance;

    public CartPageController() {
        CartPageController.instance = this;
    }

    public static CartPageController getInstance() {
        if (instance == null) {
            CartPageController.instance = new CartPageController();
        }
        return instance;
    }

    public void setPage(){
        usernameLabel.setText(ProgramController.getInstance().getEnteredAccount().getUsername());

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
                reloadCartBox();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        t.start();

    }

    public VBox getCartBox(){
        return this.cartBox;
    }

    public Label getTotalPriceLabel(){
        return totalPriceLabel;
    }

    /// All methods below are related to "functional" FX EventHandler
    public void reloadCartBox(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                UserAccount enteredUserAccount = (UserAccount) ProgramController.getInstance().getEnteredAccount();
                if (!(enteredUserAccount.getCartMap().isEmpty())){
                    double totalPrice = 0;
                    for (StoreItem item : enteredUserAccount.getCartMap().keySet()) {
                        FXMLLoader fxmlLoader = new FXMLLoader();
                        fxmlLoader.setLocation(getClass().getResource("CartCard.fxml"));
                        HBox itemCard = null;
                        try {
                            itemCard = fxmlLoader.load();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        CartCardController cardController = fxmlLoader.getController();
                        cardController.setCard(item,enteredUserAccount.getCartMap().get(item));
                        cartBox.getChildren().add(itemCard);
                        totalPrice+=enteredUserAccount.getCartMap().get(item)*item.getPrice();
                    }
                    totalPriceLabel.setText(totalPrice + " ฿");
                }
            }
        });
    }

    public void returnToUserMainPage() {
        Main userMainPage = Main.getInstance();
        userMainPage.changeScene("../page/UserMainPageInterface.fxml");

        ///// Set usernameLabel and Logo in UserMainPageInterface
        UserMainPageController.getInstance().setUsernameLabel();
        UserMainPageController.getInstance().setProfileAvatarIcon();
        UserMainPageController.getInstance().setTopLeftIconLogo();

        ///// Reload/Set items in UserMainPageInterface
        UserMainPageController.getInstance().reloadUserMainPage();
    }

    public void logOutLabelClicked() {
        Main backToLogInPage = Main.getInstance();
        backToLogInPage.changeScene("../page/LoginInterface.fxml");

        ///Set logo image in LoginInterface
        LoginController.getInstance().setLogoImage();
    }


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
