package page.staffpage;

import application.Main;
import page.login.LoginController;

public abstract class StaffPage {
    public void logOutLabelClicked() {
        Main backToLogInPage = Main.getInstance();
        backToLogInPage.changeScene("/page/login/LoginInterface.fxml");

        ///Set logo image in LoginInterface
        LoginController.getInstance().setLogoImage();
    }

    public void topLeftLabelClicked(){
        Main staffMainPage = Main.getInstance();
        staffMainPage.changeScene("/page/staffpage/StaffMainPage.fxml");

        ///// Set StaffPage
        StaffMainPageController.getInstance().setPage();
    }

    public void goToProductManagementPage(){
        Main productManagementPage = Main.getInstance();
        productManagementPage.changeScene("/page/staffpage/ProductManagementPage.fxml");

        ///// Set StaffPage
        ProductManagementController.getInstance().setPage("");
    }

    public void goToUserPageManagementPage(){
        Main userPageManagementPage = Main.getInstance();
        userPageManagementPage.changeScene("/page/staffpage/UserPageManagement.fxml");

        ///// Set StaffPage
        UserPageManagementController.getInstance().setPage();
    }

    public void goToOrderManagementPage(){
        Main orderManagementPage = Main.getInstance();
        orderManagementPage.changeScene("/page/staffpage/OrderManagementPage.fxml");

        ///// Set StaffPage
        OrderManagementPageController.getInstance().setPage("");
    }
}
