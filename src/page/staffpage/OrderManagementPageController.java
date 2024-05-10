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
import page.staffpage.staffcard.StaffOrderCardController;
import store.Order;
import store.ProgramController;
import store.StoreStorage;
import utils.Config;

public class OrderManagementPageController extends StaffPage {
    @FXML
    private VBox ordersBox;
    @FXML
    private Label logOutLabel;
    @FXML
    private ImageView profileAvatarIcon;
    @FXML
    private Label usernameLabel;
    @FXML
    private ImageView topLeftIconLogo;
    @FXML
    private TextField searchTextField;

    private static OrderManagementPageController instance;

    public OrderManagementPageController(){
        OrderManagementPageController.instance = this;
    }

    public static OrderManagementPageController getInstance(){
        if (instance == null) {
            OrderManagementPageController.instance = new OrderManagementPageController();
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
                setOrdersBox(input);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        t.start();
    }

    public void setOrdersBox(String input) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if (input.isEmpty()) {
                    ordersBox.getChildren().clear();
                    for (Order order : StoreStorage.getStorage().getOrderArrayList()) {
                        FXMLLoader fxmlLoader = new FXMLLoader();
                        fxmlLoader.setLocation(getClass().getResource("/page/staffpage/staffcard/StaffOrderCard.fxml"));
                        HBox orderCard = null;
                        try {
                            orderCard = fxmlLoader.load();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        StaffOrderCardController staffOrderCardController = fxmlLoader.getController();
                        staffOrderCardController.setCard(order);
                        ordersBox.getChildren().add(orderCard);
                    }
                } else {
                    ordersBox.getChildren().clear();
                    for (Order order : StoreStorage.getStorage().getOrderArrayList()) {
                        if ((order.toString().toLowerCase().contains(input.toLowerCase())) || (order.getTelNumber().contains(input.toLowerCase())) || (order.getUsername().contains(input.toLowerCase()))){
                            FXMLLoader fxmlLoader = new FXMLLoader();
                            fxmlLoader.setLocation(getClass().getResource("/page/staffpage/staffcard/StaffOrderCard.fxml"));
                            HBox orderCard = null;
                            try {
                                orderCard = fxmlLoader.load();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                            StaffOrderCardController staffOrderCardController = fxmlLoader.getController();
                            staffOrderCardController.setCard(order);
                            ordersBox.getChildren().add(orderCard);
                        }
                    }
                }
            }
        });
    }

    public void onSetSearchBoxClicked() {
        setOrdersBox(searchTextField.getText());
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
