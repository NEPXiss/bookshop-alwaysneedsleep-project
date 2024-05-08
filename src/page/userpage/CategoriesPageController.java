package page.userpage;

import application.Main;
import base.StoreItem;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import page.card.CategoriesCardController;
import page.login.LoginController;
import store.ProgramController;
import usage.PageSettable;
import utils.Config;

public class CategoriesPageController implements PageSettable {
    @FXML
    private Label usernameLabel;
    @FXML
    private Label logOutLabel;
    @FXML
    private Label cartLabel;
    @FXML
    private Label categoriesLabel;
    @FXML
    private Label wishlistLabel;
    @FXML
    private Label userOrdersLabel;
    @FXML
    private ImageView profileAvatarIcon;
    @FXML
    private ImageView topLeftIconLogo;
    @FXML
    private TextField searchTextField;
    @FXML
    private VBox categoriesBox;
    private static CategoriesPageController instance;

    public CategoriesPageController() {CategoriesPageController.instance = this;}

    public static CategoriesPageController getInstance() {
        if (instance == null) {
            CategoriesPageController.instance = new CategoriesPageController();
        }
        return instance;
    }

    @Override
    public void setPage() {
        usernameLabel.setText(ProgramController.getInstance().getEnteredAccount().getUsername());

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

        Thread t = new Thread(() -> {
            try {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {

                        ///Add fiction category
                        FXMLLoader fictionLoader = new FXMLLoader();
                        fictionLoader.setLocation(getClass().getResource("../card/CategoriesCard.fxml"));
                        HBox fictionHBox = null;
                        try {
                            fictionHBox = fictionLoader.load();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        CategoriesCardController fictionCard = fictionLoader.getController();
                        fictionCard.setCard("icons/fictionicon.png", "FICTION");
                        categoriesBox.getChildren().add(fictionHBox);

                        ///Add history category
                        FXMLLoader historyLoader = new FXMLLoader();
                        historyLoader.setLocation(getClass().getResource("../card/CategoriesCard.fxml"));
                        HBox historyHBox = null;
                        try {
                            historyHBox = historyLoader.load();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        CategoriesCardController historyCard = historyLoader.getController();
                        historyCard.setCard("icons/historyicon.png", "HISTORY AND POLITICS");
                        categoriesBox.getChildren().add(historyHBox);


                        ///Add Philosophy category
                        FXMLLoader philosophyLoader = new FXMLLoader();
                        philosophyLoader.setLocation(getClass().getResource("../card/CategoriesCard.fxml"));
                        HBox philosophyHbox = null;
                        try {
                            philosophyHbox = philosophyLoader.load();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        CategoriesCardController philosophyCard = philosophyLoader.getController();
                        philosophyCard.setCard("icons/philosophyicon.png", "PHILOSOPHY");
                        categoriesBox.getChildren().add(philosophyHbox);


                        ///Add Science category
                        FXMLLoader scienceLoader = new FXMLLoader();
                        scienceLoader.setLocation(getClass().getResource("../card/CategoriesCard.fxml"));
                        HBox scienceHbox = null;
                        try {
                            scienceHbox = scienceLoader.load();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        CategoriesCardController scienceCard = scienceLoader.getController();
                        scienceCard.setCard("icons/scienceicon.png", "SCIENCE");
                        categoriesBox.getChildren().add(scienceHbox);


                        ///Add Psychology category
                        FXMLLoader psychologyLoader = new FXMLLoader();
                        psychologyLoader.setLocation(getClass().getResource("../card/CategoriesCard.fxml"));
                        HBox psychologyHBox = null;
                        try {
                            psychologyHBox = psychologyLoader.load();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        CategoriesCardController psychologyCard = psychologyLoader.getController();
                        psychologyCard.setCard("icons/psychologyicon.png", "PSYCHOLOGY");
                        categoriesBox.getChildren().add(psychologyHBox);


                        ///Add Education category
                        FXMLLoader educationLoader = new FXMLLoader();
                        educationLoader.setLocation(getClass().getResource("../card/CategoriesCard.fxml"));
                        HBox educationHbox = null;
                        try {
                            educationHbox = educationLoader.load();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        CategoriesCardController educationCard = educationLoader.getController();
                        educationCard.setCard("icons/educationicon.png", "EDUCATION");
                        categoriesBox.getChildren().add(educationHbox);

                    }
                });
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        t.start();
    }

    @Override
    public void setPage(StoreItem storeItem) {

    }

    @Override
    public void setPage(String input) {

    }

    /// All methods below are related to "functional" FX EventHandler
    public void returnToUserMainPage() {
        Main userMainPage = Main.getInstance();
        userMainPage.changeScene("../page/userpage/UserMainPageInterface.fxml");

        ///// Set UserMainPage
        UserMainPageController.getInstance().setPage();
    }

    public void onSearchButtonClicked() {
        Main searchPage = Main.getInstance();
        searchPage.changeScene("../page/userpage/SearchPageInterface.fxml");

        ///Set search Page
        SearchPageController.getInstance().setPage(this.searchTextField.getText());
    }

    public void logOutLabelClicked() {
        Main backToLogInPage = Main.getInstance();
        backToLogInPage.changeScene("../page/login/LoginInterface.fxml");

        ///Set logo image in LoginInterface
        LoginController.getInstance().setLogoImage();
    }

    public void userCartLabelClicked() {
        Main cartPage = Main.getInstance();
        cartPage.changeScene("../page/userpage/CartPageInterface.fxml");

        ///Set Cart Page
        CartPageController.getInstance().setPage();
    }

    public void onWishlistLabelClicked() {
        Main wishlistPage = Main.getInstance();
        wishlistPage.changeScene("../page/userpage/WishlistPage.fxml");

        ///Set search Page
        WishlistPageController.getInstance().setPage();
    }


    /// All methods below are related to "graphical" FX EventHandler
    public void onMouseEnterLogOutButton() {
        logOutLabel.setBackground(Background.fill(Color.web("D4D4D4")));
    }

    public void onMouseExitLogOutButton() {
        logOutLabel.setBackground(Background.fill(Color.web("FFFFFF")));
    }

    public void onMouseEnterCartButton() {
        cartLabel.setBackground(Background.fill(Color.web("D4D4D4")));
    }

    public void onMouseExitCartButton() {
        cartLabel.setBackground(Background.fill(Color.web("FFFFFF")));
    }

    public void onMouseEnterCategoriesButton() {
        categoriesLabel.setBackground(Background.fill(Color.web("D4D4D4")));
    }

    public void onMouseExitCategoriesButton() {
        categoriesLabel.setBackground(Background.fill(Color.web("FFFFFF")));
    }

    public void onMouseEnterWishListButton() {
        wishlistLabel.setBackground(Background.fill(Color.web("D4D4D4")));
    }

    public void onMouseExitWishListButton() {
        wishlistLabel.setBackground(Background.fill(Color.web("FFFFFF")));
    }

    public void onMouseEnterUserOrdersButton() {
        userOrdersLabel.setBackground(Background.fill(Color.web("D4D4D4")));
    }

    public void onMouseExitUserOrdersButton() {
        userOrdersLabel.setBackground(Background.fill(Color.web("FFFFFF")));
    }
}
