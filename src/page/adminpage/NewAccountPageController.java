package page.adminpage;

import application.Main;
import base.Account;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import page.login.LoginController;
import person.StaffAccount;
import person.UserAccount;
import store.ProgramController;
import utils.Config;

public class NewAccountPageController {
    @FXML
    private Label logOutLabel;
    @FXML
    private ImageView profileAvatarIcon;
    @FXML
    private Label usernameLabel;
    @FXML
    private ImageView topLeftIconLogo;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private TextField staffNumberTextField;
    @FXML
    private ChoiceBox<String> accountTypeBox;

    private static NewAccountPageController instance;

    public NewAccountPageController() { NewAccountPageController.instance = this;}

    public static NewAccountPageController getInstance(){
        if (instance == null) {
            NewAccountPageController.instance = new NewAccountPageController();
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

        String[] types = {"USER", "STAFF"};
        accountTypeBox.getItems().addAll(types);
    }

    public void onCreateAccountButtonClicked() {
        if (accountTypeBox.getValue().equals("USER")){
            if ((usernameTextField.getText().isEmpty()) || (passwordTextField.getText().isEmpty())){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error registering an account");
                alert.setHeaderText(null);
                alert.setContentText("Please enter username and password");
                alert.showAndWait();
            } else {
                UserAccount account = new UserAccount(usernameTextField.getText(),passwordTextField.getText());
                account.addAccountToDataBase();
                backToAdminMainPage();
            }
        } else if (accountTypeBox.getValue().equals("STAFF")) {
            if ((usernameTextField.getText().isEmpty()) || (passwordTextField.getText().isEmpty()) || (accountTypeBox.getValue().isEmpty())) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error registering an account");
                alert.setHeaderText(null);
                alert.setContentText("Please enter username, staff number and password");
                alert.showAndWait();
            } else {
                StaffAccount account = new StaffAccount(usernameTextField.getText(),passwordTextField.getText(),Integer.parseInt(staffNumberTextField.getText()));
                account.addAccountToDataBase();
                backToAdminMainPage();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error registering an account");
            alert.setHeaderText(null);
            alert.setContentText("Please choose an account type");
            alert.showAndWait();
        }
    }

    public void backToAdminMainPage() {
        Main adminMainPage = Main.getInstance();
        adminMainPage.changeScene("/page/adminpage/AdminMainPage.fxml");
        AdminMainPageController.getInstance().setPage("");
    }

    public void logOutLabelClicked() {
        Main backToLogInPage = Main.getInstance();
        backToLogInPage.changeScene("/page/login/LoginInterface.fxml");

        ///Set logo image in LoginInterface
        LoginController.getInstance().setLogoImage();
    }

    /// All methods below are related to "graphical" FX EventHandler
    public void onMouseEnterLogOutButton() {
        logOutLabel.setBackground(Background.fill(Color.web("D4D4D4")));
    }
    public void onMouseExitLogOutButton() {
        logOutLabel.setBackground(Background.fill(Color.web("FFFFFF")));
    }
}
