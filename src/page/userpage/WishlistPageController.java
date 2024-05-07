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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import page.card.CartCardController;
import page.card.WishlistCardController;
import page.login.LoginController;
import person.UserAccount;
import store.ProgramController;
import utils.Config;

public class WishlistPageController {
    @FXML
    private VBox wishlistBox;
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
    private ImageView topLeftIconLogo;
    @FXML
    private TextField searchTextField;
    private static WishlistPageController instance;

    public WishlistPageController() {WishlistPageController.instance = this;}

    public static WishlistPageController getInstance() {
        if (instance == null) {
            WishlistPageController.instance = new WishlistPageController();
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
                reloadWishlistBox();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        t.start();

    }

    public VBox getWishlistBox() {
        return wishlistBox;
    }

    public void reloadWishlistBox(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                UserAccount enteredUserAccount = (UserAccount) ProgramController.getInstance().getEnteredAccount();
                if (!(enteredUserAccount.getWishList().isEmpty())){
                    for (StoreItem item : enteredUserAccount.getWishList()) {
                        FXMLLoader fxmlLoader = new FXMLLoader();
                        fxmlLoader.setLocation(getClass().getResource("../card/WishlistCard.fxml"));
                        HBox itemCard = null;
                        try {
                            itemCard = fxmlLoader.load();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        WishlistCardController wishlistCardController = fxmlLoader.getController();
                        wishlistCardController.setCard(item);
                        wishlistBox.getChildren().add(itemCard);
                    }
                }
            }
        });
    }



    /// All methods below are related to "functional" FX EventHandler
    public void returnToUserMainPage() {
        Main userMainPage = Main.getInstance();
        userMainPage.changeScene("../page/userpage/UserMainPageInterface.fxml");

        ///// Set usernameLabel and Logo in UserMainPageInterface
        UserMainPageController.getInstance().setUsernameLabel();
        UserMainPageController.getInstance().setProfileAvatarIcon();
        UserMainPageController.getInstance().setTopLeftIconLogo();

        ///// Reload/Set items in UserMainPageInterface
        UserMainPageController.getInstance().setPage();
    }

    public void onSearchButtonClicked(){
        Main searchPage = Main.getInstance();
        searchPage.changeScene("../page/userpage/SearchPageInterface.fxml");

        ///Set search Page
        SearchPageController.getInstance().setPage(this.searchTextField.getText());
    }

    public void logOutLabelClicked() {
        Main backToLogInPage = Main.getInstance();
        backToLogInPage.changeScene("../page/login/LoginInterface.fxml");

        ///Set logo image in LoginInterface
        LoginController.getInstance().setLogoImage();
    }

    public void userCartLabelClicked(){
        Main cartPage = Main.getInstance();
        cartPage.changeScene("../page/userpage/CartPageInterface.fxml");

        ///Set Cart Page
        CartPageController.getInstance().setPage();
    }

    public void CategoriesLabelClicked(){
        Main categoriesPage = Main.getInstance();
        categoriesPage.changeScene("../page/userpage/CategoriesPage.fxml");

        ///Set Cart Page
        CategoriesPageController.getInstance().setPage();
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
