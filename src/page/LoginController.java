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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import person.UserAccount;
import store.StoreAccountDataBase;
import utils.GetAccess;

import java.io.IOException;


public class LoginController {

    @FXML
    private Button signInButton;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField logInPasswordField;
    @FXML
    private Button registerButton;
    @FXML
    private Label signInAsStaffButton;
    @FXML
    private Label logInMessageLabel;
    @FXML
    private AnchorPane leftRootPane;
    @FXML
    private AnchorPane centerRootPane;

    public void signInButtonClicked() {
        boolean isUserAccount = StoreAccountDataBase.getStoreAccountDataBase().getAccountMap().get(usernameTextField.getText()) instanceof UserAccount;
        boolean isAccountExist = GetAccess.isAccountExist(usernameTextField.getText());

        if (!(usernameTextField.getText().isEmpty()) && !(logInPasswordField.getText().isEmpty())) {
            if (isAccountExist && isUserAccount) {
                if (GetAccess.validateLogin(usernameTextField.getText(), logInPasswordField.getText())) {
                    logInMessageLabel.setText("Logging in...");
                    ////go to main page


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
    }


}
