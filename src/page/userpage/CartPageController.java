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
import person.UserAccount;
import store.ProgramController;
import utils.Config;

public class CartPageController extends UserPage {
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
    private VBox cartBox;
    @FXML
    private Label totalPriceLabel;
    @FXML
    private TextField searchTextField;
    @FXML
    private Label proceedToCheckOutLabel;
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

    @Override
    public void setPage(){

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
                        fxmlLoader.setLocation(getClass().getResource("/page/card/CartCard.fxml"));
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
        super.returnToUserMainPage();
    }

    public void onWishlistLabelClicked(){
        super.onWishlistLabelClicked();
    }

    public void onUserOrderLabelClicked() {super.onUserOrderLabelClicked();}

    public void onSearchButtonClicked(){
        Main searchPage = Main.getInstance();
        searchPage.changeScene("/page/userpage/SearchPageInterface.fxml");

        ///Set search Page
        SearchPageController.getInstance().setPage(this.searchTextField.getText());
    }

    public void logOutLabelClicked() {
        super.logOutLabelClicked();
    }

    public void categoriesLabelClicked(){
        super.categoriesLabelClicked();
    }

    public void onProceedToCheckOutLabelClicked(){
        if (cartBox.getChildren().isEmpty()){
        } else {
            Main checkOutPage = Main.getInstance();
            checkOutPage.changeScene("/page/userpage/CheckOutPage.fxml");

            ///Set Cart Page
            CheckOutPageController.getInstance().setPage();
        }
    }


    /// All methods below are related to "graphical" FX EventHandler

    public void onMouseEnterCheckOutLabel() {proceedToCheckOutLabel.setBackground(Background.fill(Color.web( "606060")));}

    public void onMouseExitCheckOutLabel() {proceedToCheckOutLabel.setBackground(Background.fill(Color.web( "DFDFDF")));}

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
