package page;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class BookPageController {

    public void onTopLeftLabelClicked() {
        Main userMainPage = Main.getInstance();
        userMainPage.changeScene("../page/UserMainPageInterface.fxml");

        ///// Set usernameLabel and Logo in UserMainPageInterface
        UserMainPageController.getInstance().setUsernameLabel();
        UserMainPageController.getInstance().setProfileAvatarIcon();
        UserMainPageController.getInstance().setTopLeftIconLogo();

        ///// Reload/Set items in UserMainPageInterface
        UserMainPageController.getInstance().reloadUserMainPage();

    }

    public void setHeartIcon() {

    }


}
