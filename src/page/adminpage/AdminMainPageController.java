package page.adminpage;

import application.Main;
import base.Account;
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
import page.adminpage.admincard.AccountDetailCardController;
import page.login.LoginController;
import page.staffpage.StaffMainPageController;
import page.staffpage.staffcard.ItemCardController;
import store.ProgramController;
import store.StoreDataBase;
import store.StoreStorage;
import utils.Config;

public class AdminMainPageController {
    @FXML
    private Label logOutLabel;
    @FXML
    private ImageView profileAvatarIcon;
    @FXML
    private Label usernameLabel;
    @FXML
    private ImageView topLeftIconLogo;
    @FXML
    private VBox accountBox;
    @FXML
    private TextField searchTextField;
    private static AdminMainPageController instance;

    public AdminMainPageController() { AdminMainPageController.instance = this;}

    public static AdminMainPageController getInstance(){
        if (instance == null) {
            AdminMainPageController.instance = new AdminMainPageController();
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
                setAccountBox(input);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        t.start();
    }

    public void setAccountBox(String input) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if (input.isEmpty()) {
                    accountBox.getChildren().clear();
                    for (Account account : StoreDataBase.getStoreAccountDataBase().getAccountMap().values()) {
                        FXMLLoader fxmlLoader = new FXMLLoader();
                        fxmlLoader.setLocation(getClass().getResource("/page/adminpage/admincard/AccountDetailCard.fxml"));
                        HBox itemCard = null;
                        try {
                            itemCard = fxmlLoader.load();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        AccountDetailCardController accountDetailCardController = fxmlLoader.getController();
                        accountDetailCardController.setCard(account);
                        accountBox.getChildren().add(itemCard);
                    }
                } else {
                    accountBox.getChildren().clear();
                    for (Account account : StoreDataBase.getStoreAccountDataBase().getAccountMap().values()) {
                        if (account.getUsername().toLowerCase().contains(input.toLowerCase()) || (account.getAccountType().toLowerCase().contains(input.toLowerCase()))) {
                            FXMLLoader fxmlLoader = new FXMLLoader();
                            fxmlLoader.setLocation(getClass().getResource("/page/adminpage/admincard/AccountDetailCard.fxml"));
                            HBox itemCard = null;
                            try {
                                itemCard = fxmlLoader.load();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                            AccountDetailCardController accountDetailCardController = fxmlLoader.getController();
                            accountDetailCardController.setCard(account);
                            accountBox.getChildren().add(itemCard);
                        }
                    }
                }
            }
        });
    }

    public void onSetSearchBoxClicked() {
        setPage(searchTextField.getText());
    }

    public void onAddNewAccountButtonClicked() {
        Main newAccountPage = Main.getInstance();
        newAccountPage.changeScene("/page/adminpage/NewAccountPage.fxml");

        ///Set Page
        NewAccountPageController.getInstance().setPage();
    }

    public VBox getAccountBox() {
        return accountBox;
    }

    public void logOutLabelClicked() {
        Main backToLogInPage = Main.getInstance();
        backToLogInPage.changeScene("/page/login/LoginInterface.fxml");

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
}
