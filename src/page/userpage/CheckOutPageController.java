package page.userpage;

import base.StoreItem;
import item.Book;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import page.card.CartCardController;
import person.UserAccount;
import store.Order;
import store.ProgramController;
import store.StoreDataBase;
import store.StoreStorage;
import utils.Config;

import java.util.HashMap;
import java.util.Optional;

public class CheckOutPageController extends CartPageController {
    @FXML
    private Label orderingAsLabel;
    @FXML
    private Label totalPriceLabel;
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
    private ImageView qrCodeImage;
    @FXML
    private TextField telephoneTextField;
    @FXML
    private TextArea addressTextArea;
    @FXML
    private Label alertLabel;

    @Override
    public void setPage() {
        /// POLYMORPHISM
        usernameLabel.setText(ProgramController.getInstance().getEnteredAccount().getDisplayUsername());

        orderingAsLabel.setText(ProgramController.getInstance().getEnteredAccount().getUsername());

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

        /// Set QRCODE
        try {
            String classLoaderPath = ClassLoader.getSystemResource("default/qrcode.png").toString();
            Image qrCode = new Image(classLoaderPath);
            qrCodeImage.setImage(qrCode);
        } catch (Exception e) {
        }

        Thread t = new Thread(() -> {
            try {
                setCartBox();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        t.start();
    }

    public void setCartBox() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                UserAccount enteredUserAccount = (UserAccount) ProgramController.getInstance().getEnteredAccount();
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
                    cardController.setCard(item, enteredUserAccount.getCartMap().get(item));
                    cartBox.getChildren().add(itemCard);
                    totalPrice += enteredUserAccount.getCartMap().get(item) * item.getPrice();
                }
                totalPriceLabel.setText(totalPrice + " ฿");
            }
        });
    }

    public void onPlaceOrderButtonClicked() {
        if (cartBox.getChildren().isEmpty()) {
        } else {
            if (!(telephoneTextField.getText().isEmpty()) && !(addressTextArea.getText().isEmpty())) {
                UserAccount userAccount = (UserAccount) ProgramController.getInstance().getEnteredAccount();
                HashMap<StoreItem, Integer> orderItemsMap = new HashMap<>(userAccount.getCartMap());

                boolean areAllOrderable = true;
                for (StoreItem item : orderItemsMap.keySet()) {
                    if (!(StoreStorage.getStorage().getShelfMap().containsKey(item))) {
                        areAllOrderable = false;
                    }
                }

                if (areAllOrderable) {

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Product Detail Confirmation Dialog");
                    alert.setContentText("Do you want to proceed?");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {
                        double totalPrice = 0;
                        for (StoreItem item : userAccount.getCartMap().keySet()) {
                            totalPrice += item.getPrice() * userAccount.getCartMap().get(item);
                        }

                        Order newOrder = new Order(ProgramController.getInstance().getEnteredAccount().getUsername(), orderItemsMap, totalPrice, addressTextArea.getText(), telephoneTextField.getText());
                        userAccount.getOrderList().add(newOrder);
                        StoreStorage.getStorage().getOrderArrayList().add(newOrder);
                        returnToUserMainPage();
                        userAccount.getCartMap().clear();

                        /// Decrease the quantity of items:
                        for (StoreItem item : orderItemsMap.keySet()) {
                            item.setQuantity(item.getQuantity() - orderItemsMap.get(item));
                        }
                    } else {
                        alert.close();
                    }
                } else {
                    alertLabel.setText("There is a problem ordering this item. Please contact staffs");
                }
            } else {
                alertLabel.setText("Please enter your phone number and delivery address to place order");
            }
        }
    }

    /// All methods below are related to "functional" FX EventHandler

    public void returnToUserMainPage() {
        super.returnToUserMainPage();
    }

    public void onWishlistLabelClicked() {
        super.onWishlistLabelClicked();
    }

    public void onSearchButtonClicked() {
        super.onSearchButtonClicked();
    }

    public void logOutLabelClicked() {
        super.logOutLabelClicked();
    }

    public void categoriesLabelClicked() {
        super.categoriesLabelClicked();
    }

    public void userCartLabelClicked() {
        super.userCartLabelClicked();
    }

    public void onUserOrderLabelClicked() {
        super.onUserOrderLabelClicked();
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
