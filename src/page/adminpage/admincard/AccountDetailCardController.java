package page.adminpage.admincard;

import base.Account;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import page.adminpage.AdminMainPageController;
import person.UserAccount;

import java.util.Optional;

public class AccountDetailCardController {
    @FXML
    private Label usernameLabel;
    @FXML
    private Label accountTypeLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private HBox passwordHBox;
    @FXML
    private HBox buttonBox;
    @FXML
    private Button saveButton;
    @FXML
    private Button deleteButton;
    @FXML
    private HBox cardBox;
    @FXML
    private Button resetButton;
    private Account account;

    public void setCard(Account account){
        this.account = account;
        usernameLabel.setText(account.getUsername());
        accountTypeLabel.setText(account.getAccountType()); //POLYMORPHISM
        usernameTextField.setText(account.getUsername());

        if (account instanceof UserAccount){
            usernameTextField.setDisable(true);
            PasswordField passwordField = new PasswordField();
            passwordField.setPrefWidth(310);
            passwordField.setPrefHeight(25);
            passwordField.setText(account.getPassword());
            passwordField.setDisable(true);
            passwordHBox.getChildren().add(passwordField);
            buttonBox.getChildren().remove(saveButton);
            buttonBox.getChildren().remove(resetButton);
        } else {
            TextField textField = new TextField();
            textField.setPrefWidth(310);
            textField.setPrefHeight(25);
            textField.setText(account.getPassword());
            passwordHBox.getChildren().add(textField);
        }
    }

    public void onSaveButtonClicked() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Account Confirmation Dialog");
        alert.setContentText("Do you want to proceed?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            this.account.setUsername(usernameTextField.getText());
            TextField textField = (TextField) passwordHBox.getChildren().get(1);
            this.account.setPassword(textField.getText());
            usernameTextField.setText(this.account.getUsername());
            textField.setText(this.account.getPassword());
        } else {
            alert.close();
        }
    }

    public void onResetButtonClicked() {
        usernameTextField.setText(this.account.getUsername());
        TextField textField = (TextField) passwordHBox.getChildren().get(1);
        textField.setText(this.account.getPassword());
    }

    public void onDeleteButtonClicked(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Account Confirmation Dialog");
        alert.setContentText("You are deleting an account : Do you want to proceed?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            if (account.deleteAccount()){
                AdminMainPageController.getInstance().getAccountBox().getChildren().remove(cardBox);
            }
        } else {
            alert.close();
        }
    }

}
