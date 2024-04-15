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
import javafx.stage.Stage;
import person.AdminAccount;
import person.StaffAccount;
import person.UserAccount;
import store.StoreAccountDataBase;
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


    public void staffSignInButtonClicked(){
        boolean isStaffAccount = StoreAccountDataBase.getStoreAccountDataBase().getAccountMap().get(usernameTextField.getText()) instanceof StaffAccount;
        boolean isAdminAccount = StoreAccountDataBase.getStoreAccountDataBase().getAccountMap().get(usernameTextField.getText()) instanceof AdminAccount;
        boolean isStaffOrAdminAccount = isAdminAccount || isStaffAccount;
        boolean isAccountExist = StoreAccountDataBase.getStoreAccountDataBase().getAccountMap().containsKey(usernameTextField.getText());
        if (isAccountExist && isStaffOrAdminAccount){
            if (isStaffAccount){
                if (GetAccess.validateLogin(usernameTextField.getText(),logInPasswordField.getText())){
                    staffLogInMessageLabel.setText("Logging in...");
                    ////go to staff main page
                }else{
                    staffLogInMessageLabel.setText("Incorrect Password - Please try logging in again");
                }
            }
            else { if (GetAccess.validateLogin(usernameTextField.getText(),logInPasswordField.getText())){
                    staffLogInMessageLabel.setText("Logging in...");
                    ////go to staff main page
                }else{
                    staffLogInMessageLabel.setText("Incorrect Password - Please try again");
                }
            }
        } else {
            staffLogInMessageLabel.setText("This username has not been registered");
        }
    }

    public void setSignInAsUserButtonClicked() throws IOException {
        Main userSigninPage = new Main();
        userSigninPage.changeScene("../page/LoginInterface.fxml");
    }


}
