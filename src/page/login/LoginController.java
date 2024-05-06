package page.login;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import page.userpage.UserMainPageController;
import person.UserAccount;
import store.ProgramController;
import store.StoreAccountDataBase;
import usage.ControllerInstance;
import utils.Config;
import utils.GetAccess;


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
    private ImageView displayLogoImage = new ImageView();
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
        } catch (Exception e) {
        }
    }

    public void signInButtonClicked() {
        boolean isUserAccount = StoreAccountDataBase.getStoreAccountDataBase().getAccountMap().get(usernameTextField.getText()) instanceof UserAccount;
        boolean isAccountExist = GetAccess.isAccountExist(usernameTextField.getText());

        try {
            if (!(usernameTextField.getText().isEmpty()) && !(logInPasswordField.getText().isEmpty())) {
                if (isAccountExist && isUserAccount) {
                    if (GetAccess.validateLogin(usernameTextField.getText(), logInPasswordField.getText())) {
                        ///// Go to UserMainPage
                        logInMessageLabel.setText("Logging in...");
                        Main userMainPage = Main.getInstance();
                        userMainPage.changeScene("../page/userpage/UserMainPageInterface.fxml");

                        ///// Set ProgramController
                        ProgramController.getInstance().setEnteredAccount(StoreAccountDataBase.getStoreAccountDataBase().getAccountMap().get(usernameTextField.getText()), ControllerInstance.USER);

                        ///// Set usernameLabel and Logo in UserMainPageInterface
                        UserMainPageController.getInstance().setUsernameLabel();
                        UserMainPageController.getInstance().setProfileAvatarIcon();
                        UserMainPageController.getInstance().setTopLeftIconLogo();

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

        } catch (Exception e) {
        }
    }

    public void setSignInAsStaffButtonClicked() {
        try {
            Main staffSigninPage = Main.getInstance();
            staffSigninPage.changeScene("../page/login/StaffLoginInterface.fxml");

            /// Set Logo image for StaffInterface
            StaffLogInController.getInstance().setLogoImage();
        } catch (Exception e) {

        }
    }

    public void registerButtonClicked() {
        try {
            Main registrationPage = Main.getInstance();
            registrationPage.changeScene("../page/login/RegistrationInterface.fxml");

            /// Set Logo image for RegistrationInterface
            RegistrationController.getInstance().setLogoImage();
        } catch (Exception e) {
        }
    }

    public void onMouseEnterSignInAsStaffButton() {
        signInAsStaffButton.setPrefWidth(105);
    }

    public void onMouseExitSignInAsStaffButton() {
        signInAsStaffButton.setPrefWidth(95);
    }

}
