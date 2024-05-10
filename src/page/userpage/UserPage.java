package page.userpage;

import application.Main;
import base.StoreItem;
import page.login.LoginController;

public abstract class UserPage {
    public void setPage(){}
    public void setPage(String searchInput){}
    public void setPage(StoreItem storeItem){}

    public void userCartLabelClicked(){
        Main cartPage = Main.getInstance();
        cartPage.changeScene("/page/userpage/CartPageInterface.fxml");

        ///Set Cart Page
        CartPageController.getInstance().setPage();
    }

    public void logOutLabelClicked() {
        Main backToLogInPage = Main.getInstance();
        backToLogInPage.changeScene("/page/login/LoginInterface.fxml");

        ///Set logo image in LoginInterface
        LoginController.getInstance().setLogoImage();
    }

    public void onUserOrderLabelClicked(){
        Main userOrderPage = Main.getInstance();
        userOrderPage.changeScene("/page/userpage/UserOrderPage.fxml");

        ///Set search Page
        UserOrderPageController.getInstance().setPage();
    }

    public void onWishlistLabelClicked(){
        Main wishlistPage = Main.getInstance();
        wishlistPage.changeScene("/page/userpage/WishlistPage.fxml");

        ///Set search Page
        WishlistPageController.getInstance().setPage();
    }

    public void categoriesLabelClicked(){
        Main categoriesPage = Main.getInstance();
        categoriesPage.changeScene("/page/userpage/CategoriesPage.fxml");

        ///Set Cart Page
        CategoriesPageController.getInstance().setPage();
    }
    public void returnToUserMainPage() {
        Main userMainPage = Main.getInstance();
        userMainPage.changeScene("/page/userpage/UserMainPageInterface.fxml");

        ///// Set UserMainPage
        UserMainPageController.getInstance().setPage();
    }
}
