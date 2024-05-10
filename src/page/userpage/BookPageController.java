package page.userpage;

import application.Main;
import base.StoreItem;
import item.Book;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import page.card.CardController;
import person.UserAccount;
import store.ProgramController;
import store.StoreStorage;
import utils.Config;

public class BookPageController extends UserPage {
    @FXML
    private ImageView wishlistIcon;
    @FXML
    private HBox moreFromThisBox;
    @FXML
    private ImageView storeItemImage;
    @FXML
    private Label titleLabel;
    @FXML
    private Label authorBrandLabel;
    @FXML
    private Text descriptionText;
    @FXML
    private Label availableLabel;
    @FXML
    private ChoiceBox<String> quantityBox;
    @FXML
    private Label priceLabel;
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
    private Label backLabel;
    @FXML
    private Label quantityBoxAlert;
    @FXML
    private TextField searchTextField;
    @FXML
    private Label addToWishlistLabel;
    private final String[] quantity = {"1", "2", "3", "4", "5"};
    private StoreItem storeItem;
    private static BookPageController instance;

    public BookPageController() {
        BookPageController.instance = this;
    }

    public static BookPageController getInstance() {
        if (instance == null) {
            BookPageController.instance = new BookPageController();
        }
        return instance;
    }

    @Override
    public void setPage(StoreItem storeItem) {
        try {
            this.storeItem = storeItem;

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

            /// Set Wishlist Heart Icon
            String classLoaderPath = ClassLoader.getSystemResource("icons/transparenthearticon.png").toString();
            Image profileImage = new Image(classLoaderPath);
            wishlistIcon.setImage(profileImage);

            /// Set item detail
            storeItemImage.setImage(storeItem.getImage());
            titleLabel.setText(storeItem.getTitle());
            authorBrandLabel.setText(storeItem.getAuthorBrand());
            if (storeItem.isOrderable()) {
                availableLabel.setText("In Stock");
            } else {
                availableLabel.setText("Out of Stock");
            }

            /// Set quantityBox
            quantityBox.getItems().addAll(quantity);
            priceLabel.setText(storeItem.getPrice() + " ฿");
            descriptionText.setText(storeItem.getFullDescription());
        } catch (Exception e) {
        }
    }

    public void setMoreFromThisBox(StoreItem storeItemOfThisPage) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                for (StoreItem storeItem : StoreStorage.getStorage().getShelfMap().keySet()) {
                    if ((storeItem.getAuthorBrand().equals(storeItemOfThisPage.getAuthorBrand())) && !(storeItem.equals(storeItemOfThisPage))) {
                        FXMLLoader fxmlLoader = new FXMLLoader();
                        fxmlLoader.setLocation(getClass().getResource("/page/card/Card.fxml"));
                        VBox itemCard = null;
                        try {
                            itemCard = fxmlLoader.load();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        CardController cardController = fxmlLoader.getController();
                        cardController.setCard(storeItem);
                        moreFromThisBox.getChildren().add(itemCard);
                    }
                }
            }
        });
    }

    /// All methods below are related to "functional" FX EventHandler
    public void userCartLabelClicked() {
        super.userCartLabelClicked();
    }

    public void onSearchButtonClicked() {
        Main searchPage = Main.getInstance();
        searchPage.changeScene("/page/userpage/SearchPageInterface.fxml");

        ///Set search Page
        SearchPageController.getInstance().setPage(this.searchTextField.getText());
    }

    public void returnToUserMainPage() {
        super.returnToUserMainPage();
    }

    public void logOutLabelClicked() {
        super.logOutLabelClicked();
    }

    public void onUserOrderLabelClicked() {super.onUserOrderLabelClicked();}

    public void onWishlistLabelClicked() {
        super.onWishlistLabelClicked();
    }

    public void categoriesLabelClicked() {
        super.categoriesLabelClicked();
    }

    public void onQuantityBoxSelected() {
        if (this.quantityBox.getValue() == null) {
            quantityBoxAlert.setText("Please select quantity");
        } else {
            UserAccount userAccount = (UserAccount) ProgramController.getInstance().getEnteredAccount();

            ///POLYMORPHISM
            if (this.storeItem.isOrderable()) {
                if (!(userAccount.getCartMap().containsKey(this.storeItem))) {
                    if (Integer.parseInt(this.quantityBox.getValue())<=this.storeItem.getQuantity()){
                        userAccount.getCartMap().put(this.storeItem, Integer.parseInt(this.quantityBox.getValue()));
                        quantityBoxAlert.setText("");
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Item already added to cart");
                        alert.setHeaderText(null);
                        alert.setContentText(Integer.parseInt(this.quantityBox.getValue()) + " quantity of this item has been added to your cart!");
                        alert.showAndWait();
                    } else {
                        quantityBoxAlert.setText("there are " + this.storeItem.getQuantity() + " quantity of this item left!");
                    }
                } else {
                    if (userAccount.getCartMap().get(this.storeItem) + Integer.parseInt(this.quantityBox.getValue()) > 5) {
                        quantityBoxAlert.setText("You can order a maximum of 5 quantity of this item per order. You have " + userAccount.getCartMap().get(this.storeItem) + " on your cart.");
                    } else {
                        int oldQuantity = userAccount.getCartMap().get(this.storeItem);
                        if ((oldQuantity + Integer.parseInt(this.quantityBox.getValue())) <= this.storeItem.getQuantity()) {
                            userAccount.getCartMap().put(this.storeItem, oldQuantity + Integer.parseInt(this.quantityBox.getValue()));
                            quantityBoxAlert.setText("");
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Item already added to cart");
                            alert.setHeaderText(null);
                            alert.setContentText(Integer.parseInt(this.quantityBox.getValue()) + " more quantity of this item has been added to your cart!");
                            alert.showAndWait();
                        } else {
                            quantityBoxAlert.setText("there are " + this.storeItem.getQuantity() + " quantity of this item left!");
                        }
                    }
                }
            } else {
                quantityBoxAlert.setText("item out of stock!");
            }
        }
    }

    public void onAddToWishlistLabelClicked() {
        UserAccount userAccount = (UserAccount) ProgramController.getInstance().getEnteredAccount();
        if (userAccount.getWishList().contains(this.storeItem)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Item already added to wishlist");
            alert.setHeaderText(null);
            alert.setContentText("This item has already been added to your wishlist!");
            alert.showAndWait();
        } else {
            userAccount.getWishList().add(this.storeItem);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Item added to wishlist");
            alert.setHeaderText(null);
            alert.setContentText("This item has been added to your wishlist!");
            alert.showAndWait();
        }
    }


    /// All methods below are related to "graphical" FX EventHandler
    public void onEnterAddToWishlistLabel() {
        addToWishlistLabel.setTextFill(Color.web("3737D5"));
    }

    public void onExitAddToWishlistLabel() {
        addToWishlistLabel.setTextFill(Color.BLACK);
    }

    public void onMouseEnterBackLabel() {
        backLabel.setBackground(Background.fill(Color.web("606060")));
    }

    public void onMouseExitBackLabel() {
        backLabel.setBackground(Background.fill(Color.web("DFDFDF")));
    }

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
