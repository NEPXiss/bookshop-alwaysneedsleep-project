package page;

import application.Main;
import base.Account;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.AccessibleAction;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import store.ProgramController;
import utils.Config;

import java.io.IOException;

public class UserMainPageController {
    @FXML
    private Label usernameLabel;
    @FXML
    private Label logOutLabel;
    @FXML
    private ImageView profileAvatarIcon;
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
    }

}
