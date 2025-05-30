package page.login;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import person.UserAccount;
import store.StoreDataBase;
import utils.Config;

public class RegistrationController {
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField passwordValidateField;
    @FXML
    private Label backLabel;
    @FXML
    private Label messageAlert;
    @FXML
    private ImageView displayLogoImage;
    private static RegistrationController instance;

    public RegistrationController() {
        RegistrationController.instance = this;
    }

    public static RegistrationController getInstance() {
        if (instance == null) {
            RegistrationController.instance = new RegistrationController();
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

    public void createNewUserAccount() {
        String username = usernameTextField.getText();
        String password = passwordField.getText();
        String passwordValidate = passwordValidateField.getText();

        try {
            if (username.isEmpty() || password.isEmpty() || passwordValidate.isEmpty()) {
                messageAlert.setText("Some information is missing. Please recheck your username and password");
            } else {
                if (StoreDataBase.getStoreAccountDataBase().getAccountMap().containsKey(username)) {
                    messageAlert.setText("This username has already been registered. Please try again");
                } else {
                    if (username.length() <= 4) {
                        messageAlert.setText("Your username must be at least 5 characters long");
                    } else {
                        if (password.length() <= 4) {
                            messageAlert.setText("Your password must be at least 5 characters long");
                        } else {
                            if (passwordValidate.equals(password)) {
                                /////////////////////////////////////
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Registered successfully");
                                alert.setHeaderText(null);
                                alert.setContentText("Your account has been registered!");
                                alert.showAndWait();

                                ////////////////////////////////////
                                UserAccount newUserAccount = new UserAccount(username, password);
                                newUserAccount.addAccountToDataBase();

                                ////////////////////////////////////
                                Main backToLogInPage = Main.getInstance();
                                backToLogInPage.changeScene("/page/login/LoginInterface.fxml");
                                ///Set logo image in LoginInterface
                                LoginController.getInstance().setLogoImage();

                            } else {
                                messageAlert.setText("Passwords do not match. Please try again");
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {

        }
    }

    public void backLabelClicked() {
        try {
            Main backToLogInPage = Main.getInstance();
            backToLogInPage.changeScene("/page/login/LoginInterface.fxml");

            ///Set logo image in LoginInterface
            LoginController.getInstance().setLogoImage();
        } catch (Exception e) {
        }
    }

    public void onMouseEnterBackLabel() {
        backLabel.setPrefWidth(50);
    }

    public void onMouseExitBackLabel() {
        backLabel.setPrefWidth(40);
    }


}
