package person;

import base.Account;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import utils.Config;

public class AdminAccount extends Account {
    public AdminAccount() {
        super(Config.adminUsernane, Config.adminPassword);
    }
    @Override
    public String getAccountType() {
        return "ADMIN";
    }
    @Override
    public boolean deleteAccount(){
        ///// ADMIN ACCOUNT CANNOT BE DELETED //// POLYMORPHISM
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Delete ERROR Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Admin account cannot be deleted!");
        alert.showAndWait();
        return false;
    }
}
