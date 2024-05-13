package page.staffpage;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import page.userpage.BookPageController;
import store.ProgramController;
import utils.Config;

public class StaffMainPageController extends StaffPage{
    @FXML
    private Label logOutLabel;
    @FXML
    private ImageView profileAvatarIcon;
    @FXML
    private Label usernameLabel;
    @FXML
    private ImageView topLeftIconLogo;
    @FXML
    private Label productManagementLabel;
    @FXML
    private Label userpageManagementLabel;
    @FXML
    private Label orderManagementLabel;
    private static StaffMainPageController instance;

    public StaffMainPageController() { StaffMainPageController.instance = this;}

    public static StaffMainPageController getInstance(){
        if (instance == null) {
            StaffMainPageController.instance = new StaffMainPageController();
        }
        return instance;
    }

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
    }

    @Override
    public void logOutLabelClicked() {
        super.logOutLabelClicked();
    }

    @Override
    public void goToUserPageManagementPage() {
        super.goToUserPageManagementPage();
    }

    @Override
    public void goToProductManagementPage() {
        super.goToProductManagementPage();
    }

    @Override
    public void goToOrderManagementPage(){
        super.goToOrderManagementPage();
    }

    /// All methods below are related to "graphical" FX EventHandler
    public void onMouseEnterLogOutButton() {
        logOutLabel.setBackground(Background.fill(Color.web("D4D4D4")));
    }
    public void onMouseExitLogOutButton() {
        logOutLabel.setBackground(Background.fill(Color.web("FFFFFF")));
    }
    public void onEnterProductLabel(){
        productManagementLabel.setTextFill(Color.web("FFFFFF"));
    }
    public void onExitProductLabel() {
        productManagementLabel.setTextFill(Color.BLACK);
    }
    public void onEnterOrderLabel(){
        orderManagementLabel.setTextFill(Color.web("FFFFFF"));
    }
    public void onExitOrderLabel() {
        orderManagementLabel.setTextFill(Color.BLACK);
    }
    public void onEnterUserLabel(){
        userpageManagementLabel.setTextFill(Color.web("FFFFFF"));
    }
    public void onExitUserLabel() {
        userpageManagementLabel.setTextFill(Color.BLACK);
    }
}
