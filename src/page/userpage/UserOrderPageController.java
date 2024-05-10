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
import page.card.OrderCardController;
import page.card.WishlistCardController;
import person.UserAccount;
import store.Order;
import store.ProgramController;
import utils.Config;

public class UserOrderPageController extends UserPage{
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
    @FXML
    private VBox ordersBox;
    private static UserOrderPageController instance;

    public UserOrderPageController() {UserOrderPageController.instance = this;}

    public static UserOrderPageController getInstance() {
        if (instance == null) {
            UserOrderPageController.instance = new UserOrderPageController();
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
                setOrdersBox();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        t.start();
    }

    public void setOrdersBox(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                UserAccount enteredUserAccount = (UserAccount) ProgramController.getInstance().getEnteredAccount();

                if (!(enteredUserAccount.getOrderList().isEmpty())){
                    for (Order order : enteredUserAccount.getOrderList()) {
                        FXMLLoader fxmlLoader = new FXMLLoader();
                        fxmlLoader.setLocation(getClass().getResource("/page/card/OrderCard.fxml"));
                        HBox itemCard = null;
                        try {
                            itemCard = fxmlLoader.load();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        OrderCardController orderCardController = fxmlLoader.getController();
                        orderCardController.setCard(order);
                        ordersBox.getChildren().add(itemCard);
                    }
                }


            }
        });
    }



    /// All methods below are related to "functional" FX EventHandler
    public void returnToUserMainPage() {
        super.returnToUserMainPage();
    }
    public void onWishlistLabelClicked(){
        super.onWishlistLabelClicked();
    }

    public void onSearchButtonClicked(){
        Main searchPage = Main.getInstance();
        searchPage.changeScene("/page/userpage/SearchPageInterface.fxml");

        ///Set search Page
        SearchPageController.getInstance().setPage(this.searchTextField.getText());
    }

    public void logOutLabelClicked() {
        super.logOutLabelClicked();
    }

    public void userCartLabelClicked(){
        super.userCartLabelClicked();
    }

    public void categoriesLabelClicked(){
        super.categoriesLabelClicked();
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
