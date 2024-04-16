package page;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import person.UserAccount;
import store.StoreAccountDataBase;

import java.io.IOException;

public class RegistrationController {
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private PasswordField passwordValidateTextField;
    @FXML
    private Button registerButton;
    @FXML
    private Label backButton;
    @FXML
    private Label messageAlert;

    public void createNewUserAccount() throws IOException {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();
        String passwordValidate = passwordValidateTextField.getText();
        if (username.isEmpty() || password.isEmpty() || passwordValidate.isEmpty()){
            messageAlert.setText("Some information is missing. Please recheck your username and password");
        } else {
            if (StoreAccountDataBase.getStoreAccountDataBase().getAccountMap().containsKey(username)){
                messageAlert.setText("This username has already been registered. Please try again");
            }
            else {
                if (username.length() <= 4) {
                    messageAlert.setText("Your username must be at least 5 characters long");
                } else {
                    if (password.length() <= 4) {
                        messageAlert.setText("Your password must be at least 5 characters long");
                    } else {
                        if (passwordValidate.equals(password)){
                            /////////////////////////////////////
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Registered successfully");
                            alert.setHeaderText(null);
                            alert.setContentText("Your account has been registered");
                            alert.showAndWait();

                            ////////////////////////////////////
                            UserAccount newUserAccount = new UserAccount(username, password);
                            newUserAccount.addAccountToDataBase();

                            ////////////////////////////////////
                            Main backToLogInPage = Main.getInstance();
                            backToLogInPage.changeScene("../page/LoginInterface.fxml");

                        } else {
                            messageAlert.setText("Passwords do not match. Please try again");
                        }
                    }
                }
            }
        }
    }

    public void backButtonClicked() throws IOException {
        Main backToLogInPage = Main.getInstance();
        backToLogInPage.changeScene("../page/LoginInterface.fxml");
    }






}
