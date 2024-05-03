package page;

import application.Main;
import base.Account;
import base.StoreItem;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.AccessibleAction;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import store.ProgramController;
import store.StoreStorage;
import utils.Config;

import java.io.IOException;

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

    public void reloadUserMainPage() throws IOException {
        setNewArrivals();
        setRecommendedItems();
    }

    public void setNewArrivals() throws IOException {
        for (StoreItem item: StoreStorage.getStorage().getNewArrivalList()){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("ExclusiveCard.fxml"));
            HBox itemCard = fxmlLoader.load();
            ExclusiveCardController cardController = fxmlLoader.getController();
            cardController.setCard(item);
            newArrivalsPane.getChildren().add(itemCard);
        }
    }

    public void setRecommendedItems() {

    }

    public void setUsernameLabel() {
        usernameLabel.setText(ProgramController.getInstance().getEnteredAccount().getUsername());
    }

    public void setProfileAvatarIcon() {
        try {
            String classLoaderPath = ClassLoader.getSystemResource(Config.profileImage).toString();
            Image profileImage = new Image(classLoaderPath);
            profileAvatarIcon.setImage(profileImage);
        } catch (Exception e) {}
    }

    public void logOutLabelClicked() throws IOException {
        Main backToLogInPage = Main.getInstance();
        backToLogInPage.changeScene("../page/LoginInterface.fxml");

        ///Set logo image in LoginInterface
        LoginController.getInstance().setLogoImage();
    }


    /// All methods below are related to FX EventHandler

    public void onMouseEnterLogOutButton(){
        logOutLabel.setBackground(Background.fill(Color.web("99627A")));
    }

    public void onMouseExitLogOutButton(){
        logOutLabel.setBackground(Background.fill(Color.web("E7CBCB")));
    }

    public void onMouseEnterBestSellersButton(){ bestSellersLabel.setBackground(Background.fill(Color.web("99627A")));}

    public void onMouseExitBestSellersButton(){
        bestSellersLabel.setBackground(Background.fill(Color.web("E7CBCB")));
    }

    public void onMouseEnterCategoriesButton(){
        categoriesLabel.setBackground(Background.fill(Color.web("99627A")));
    }

    public void onMouseExitCategoriesButton(){
        categoriesLabel.setBackground(Background.fill(Color.web("E7CBCB")));
    }

    public void onMouseEnterSettingsButton(){
        settingLabel.setBackground(Background.fill(Color.web("99627A")));
    }

    public void onMouseExitSettingsButton(){
        settingLabel.setBackground(Background.fill(Color.web("E7CBCB")));
    }

    public void onMouseEnterWishListButton(){
        wishlistLabel.setBackground(Background.fill(Color.web("99627A")));
    }

    public void onMouseExitWishListButton(){
        wishlistLabel.setBackground(Background.fill(Color.web("E7CBCB")));
    }

    public void onMouseEnterUserOrdersButton(){
        userOrdersLabel.setBackground(Background.fill(Color.web("99627A")));
    }

    public void onMouseExitUserOrdersButton(){
        userOrdersLabel.setBackground(Background.fill(Color.web("E7CBCB")));
    }

}
