package page;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import person.AdminAccount;
import person.StaffAccount;
import person.UserAccount;
import store.StoreAccountDataBase;
import utils.Config;
import utils.GetAccess;

import java.io.IOException;

public class StaffLogInController {
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField logInPasswordField;
    @FXML
    private Button staffSignInButton;
    @FXML
    private Label signInAsUserButton;
    @FXML
    private Label staffLogInMessageLabel;
    @FXML
    private ImageView displayLogoImage;
    private static StaffLogInController instance;

    public StaffLogInController(){
        StaffLogInController.instance = this;
    }

    public static StaffLogInController getInstance(){
        if (instance == null) {
            StaffLogInController.instance = new StaffLogInController();
        }
        return instance;
    }

    public void setLogoImage(){
        try {
            String classLoaderPath = ClassLoader.getSystemResource(Config.logoImage1).toString();
            Image logoImage = new Image(classLoaderPath);
            displayLogoImage.setImage(logoImage);
        } catch (Exception e) {}
    }


    public void staffSignInButtonClicked() {
        boolean isStaffAccount = StoreAccountDataBase.getStoreAccountDataBase().getAccountMap().get(usernameTextField.getText()) instanceof StaffAccount;
        boolean isAdminAccount = StoreAccountDataBase.getStoreAccountDataBase().getAccountMap().get(usernameTextField.getText()) instanceof AdminAccount;
        boolean isStaffOrAdminAccount = isAdminAccount || isStaffAccount;
        boolean isAccountExist = StoreAccountDataBase.getStoreAccountDataBase().getAccountMap().containsKey(usernameTextField.getText());

        if (!(usernameTextField.getText().isEmpty()) && !(logInPasswordField.getText().isEmpty())) {
            if (isAccountExist && isStaffOrAdminAccount) {
                if (isStaffAccount) {
                    if (GetAccess.validateLogin(usernameTextField.getText(), logInPasswordField.getText())) {
                        staffLogInMessageLabel.setText("Logging in...");
                        ////go to staff main page
                    } else {
                        staffLogInMessageLabel.setText("Incorrect Password - Please try again");
                    }
                } else {
                    if (GetAccess.validateLogin(usernameTextField.getText(), logInPasswordField.getText())) {
                        staffLogInMessageLabel.setText("Logging in...");
                        ////go to admin main page
                    } else {
                        staffLogInMessageLabel.setText("Incorrect Password - Please try again");
                    }
                }
            } else {
                staffLogInMessageLabel.setText("This username has not been registered");
            }
        } else if ((usernameTextField.getText().isEmpty()) && !(logInPasswordField.getText().isEmpty())) {
            staffLogInMessageLabel.setText("Please enter your username");

        } else if (!(usernameTextField.getText().isEmpty()) && (logInPasswordField.getText().isEmpty())) {
            staffLogInMessageLabel.setText("Please enter your password");
        } else {
            staffLogInMessageLabel.setText("Please enter username and password");
        }
    }

    public void setSignInAsUserButtonClicked() throws IOException {
        Main userSigninPage = Main.getInstance();
        userSigninPage.changeScene("../page/LoginInterface.fxml");

        ///Set logo image in LoginInterface
        LoginController.getInstance().setLogoImage();
    }
}
