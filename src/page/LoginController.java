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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import person.UserAccount;
import store.ProgramController;
import store.StoreAccountDataBase;
import usage.ControllerInstance;
import utils.Config;
import utils.GetAccess;

import java.io.IOException;
import java.util.function.LongToIntFunction;


public class LoginController {

    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField logInPasswordField;
    @FXML
    private Label signInAsStaffButton;
    @FXML
    private Label logInMessageLabel;
    @FXML
    private ImageView displayLogoImage  = new ImageView();
    private static LoginController instance;

    public LoginController() {
        LoginController.instance = this;
    }

    public static LoginController getInstance() {
        if (instance == null) {
            LoginController.instance = new LoginController();
        }
        return instance;
    }

    public void setLogoImage() {
        try {
            String classLoaderPath = ClassLoader.getSystemResource(Config.logoImage1).toString();
            Image logoImage = new Image(classLoaderPath);
            displayLogoImage.setImage(logoImage);
        } catch (Exception e) {}
    }

    public void signInButtonClicked() throws IOException {
        boolean isUserAccount = StoreAccountDataBase.getStoreAccountDataBase().getAccountMap().get(usernameTextField.getText()) instanceof UserAccount;
        boolean isAccountExist = GetAccess.isAccountExist(usernameTextField.getText());

        if (!(usernameTextField.getText().isEmpty()) && !(logInPasswordField.getText().isEmpty())) {
            if (isAccountExist && isUserAccount) {
                if (GetAccess.validateLogin(usernameTextField.getText(), logInPasswordField.getText())) {
                    ///// Go to UserMainPage
                    logInMessageLabel.setText("Logging in...");
                    Main userMainPage = Main.getInstance();
                    userMainPage.changeScene("../page/UserMainPageInterface.fxml");

                    ///// Set ProgramController
                    ProgramController.getInstance().setEnteredAccount(StoreAccountDataBase.getStoreAccountDataBase().getAccountMap().get(usernameTextField.getText()), ControllerInstance.USER);

                    ///// Set usernameLabel in UserMainPageInterface
                    UserMainPageController.getInstance().setUsernameLabel();
                    UserMainPageController.getInstance().setProfileAvatarIcon();

                    ///// Reload/Set items in UserMainPageInterface
                    UserMainPageController.getInstance().reloadUserMainPage();
                } else {
                    logInMessageLabel.setText("Incorrect Password - Please try again");
                }
            } else {
                logInMessageLabel.setText("This username has not been registered");
            }
        } else if ((usernameTextField.getText().isEmpty()) && !(logInPasswordField.getText().isEmpty())) {
            logInMessageLabel.setText("Please enter your username");

        } else if (!(usernameTextField.getText().isEmpty()) && (logInPasswordField.getText().isEmpty())) {
            logInMessageLabel.setText("Please enter your password");
        } else {
            logInMessageLabel.setText("Please enter username and password");
        }
    }

    public void setSignInAsStaffButtonClicked() throws IOException {
        Main staffSigninPage = Main.getInstance();
        staffSigninPage.changeScene("../page/StaffLoginInterface.fxml");

        /// Set Logo image for StaffInterface
        StaffLogInController.getInstance().setLogoImage();
    }

    public void registerButtonClicked() throws IOException {
        Main registrationPage = Main.getInstance();
        registrationPage.changeScene("../page/RegistrationInterface.fxml");

        /// Set Logo image for RegistrationInterface
        RegistrationController.getInstance().setLogoImage();
    }

    public void onMouseEnterSignInAsStaffButton(){
        signInAsStaffButton.setPrefWidth(105);
    }

    public void onMouseExitSignInAsStaffButton(){
        signInAsStaffButton.setPrefWidth(95);
    }

}
