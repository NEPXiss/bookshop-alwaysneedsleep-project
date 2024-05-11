package page.staffpage;

import base.StoreItem;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import page.staffpage.staffcard.NewArrivalCardController;
import page.staffpage.staffcard.NewArrivalSearchCardController;
import page.staffpage.staffcard.RecommCardController;
import page.staffpage.staffcard.RecommSearchCardController;
import store.ProgramController;
import store.StoreStorage;
import utils.Config;

public class UserPageManagementController extends StaffPage {
    @FXML
    private Label logOutLabel;
    @FXML
    private ImageView profileAvatarIcon;
    @FXML
    private Label usernameLabel;
    @FXML
    private ImageView topLeftIconLogo;
    @FXML
    private TextField newArrivalSearchTextField;
    @FXML
    private Button newArrivalSearchButton;
    @FXML
    private TextField recommTextField;
    @FXML
    private Button recommSearchButton;
    @FXML
    private VBox newArrivalBox;
    @FXML
    private VBox newArrivalSearchBox;
    @FXML
    private VBox recommBox;
    @FXML
    private VBox recommSearchBox;

    private static UserPageManagementController instance;

    public UserPageManagementController() {
        UserPageManagementController.instance = this;
    }

    public static UserPageManagementController getInstance() {
        if (instance == null) {
            UserPageManagementController.instance = new UserPageManagementController();
        }
        return instance;
    }

    public void setPage() {
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

        Thread t = new Thread(() -> {
            try {
                reloadRecommBox("");
                reloadNewArrivalBox("");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        t.start();
    }

    public void reloadNewArrivalBox(String input) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                newArrivalSearchBox.getChildren().clear();
                newArrivalBox.getChildren().clear();

                for (StoreItem item : StoreStorage.getStorage().getNewArrivalList()) {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("/page/staffpage/staffcard/NewArrivalCard.fxml"));
                    HBox itemCard = null;
                    try {
                        itemCard = fxmlLoader.load();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    NewArrivalCardController newArrivalCardController = fxmlLoader.getController();
                    newArrivalCardController.setCard(item);
                    newArrivalBox.getChildren().add(itemCard);
                }

                if (input.isEmpty()) {
                    for (StoreItem item : StoreStorage.getStorage().getShelfMap().keySet()) {
                        FXMLLoader fxmlLoader = new FXMLLoader();
                        fxmlLoader.setLocation(getClass().getResource("/page/staffpage/staffcard/NewArrivalSearchCard.fxml"));
                        HBox itemCard = null;
                        try {
                            itemCard = fxmlLoader.load();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        NewArrivalSearchCardController newArrivalSearchCardController = fxmlLoader.getController();
                        newArrivalSearchCardController.setCard(item);
                        newArrivalSearchBox.getChildren().add(itemCard);
                    }
                } else {
                    for (StoreItem item : StoreStorage.getStorage().getShelfMap().keySet()) {
                        if ((item.getTitle().toLowerCase().contains(input.toLowerCase())) || (item.getAuthorBrand().toLowerCase().contains(input.toLowerCase()))) {
                            FXMLLoader fxmlLoader = new FXMLLoader();
                            fxmlLoader.setLocation(getClass().getResource("/page/staffpage/staffcard/NewArrivalSearchCard.fxml"));
                            HBox itemCard = null;
                            try {
                                itemCard = fxmlLoader.load();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                            NewArrivalSearchCardController newArrivalSearchCardController = fxmlLoader.getController();
                            newArrivalSearchCardController.setCard(item);
                            newArrivalSearchBox.getChildren().add(itemCard);
                        }
                    }
                }
            }
        });
    }

    public void reloadRecommBox(String input) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                recommSearchBox.getChildren().clear();
                recommBox.getChildren().clear();

                for (StoreItem item : StoreStorage.getStorage().getRecommendedItemsList()) {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("/page/staffpage/staffcard/RecommCard.fxml"));
                    HBox itemCard = null;
                    try {
                        itemCard = fxmlLoader.load();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    RecommCardController recommCardController = fxmlLoader.getController();
                    recommCardController.setCard(item);
                    recommBox.getChildren().add(itemCard);
                }

                if (input.isEmpty()) {
                    for (StoreItem item : StoreStorage.getStorage().getShelfMap().keySet()) {
                        FXMLLoader fxmlLoader = new FXMLLoader();
                        fxmlLoader.setLocation(getClass().getResource("/page/staffpage/staffcard/RecommSearchCard.fxml"));
                        HBox itemCard = null;
                        try {
                            itemCard = fxmlLoader.load();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                        RecommSearchCardController recommSearchCardController = fxmlLoader.getController();
                        recommSearchCardController.setCard(item);
                        recommSearchBox.getChildren().add(itemCard);
                    }
                } else {
                    for (StoreItem item : StoreStorage.getStorage().getShelfMap().keySet()) {
                        if ((item.getTitle().toLowerCase().contains(input.toLowerCase())) || (item.getAuthorBrand().toLowerCase().contains(input.toLowerCase()))) {
                            FXMLLoader fxmlLoader = new FXMLLoader();
                            fxmlLoader.setLocation(getClass().getResource("/page/staffpage/staffcard/RecommSearchCard.fxml"));
                            HBox itemCard = null;
                            try {
                                itemCard = fxmlLoader.load();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                            RecommSearchCardController recommSearchCardController = fxmlLoader.getController();
                            recommSearchCardController.setCard(item);
                            recommSearchBox.getChildren().add(itemCard);
                        }
                    }
                }
            }
        });
    }

    public void onNewArrivalSearchButtonClicked() {
        Thread t = new Thread(() -> {
            reloadNewArrivalBox(newArrivalSearchTextField.getText());
        });
        t.start();
    }

    public void onRecommSearchButtonClicked() {
        Thread t = new Thread(() -> {
            reloadRecommBox(recommTextField.getText());
        });
        t.start();
    }

    public VBox getNewArrivalBox() {
        return newArrivalBox;
    }

    public VBox getRecommBox() {
        return recommBox;
    }

    public void logOutLabelClicked() {
        super.logOutLabelClicked();
    }

    public void topLeftLabelClicked() {
        super.topLeftLabelClicked();
    }

    /// All methods below are related to "graphical" FX EventHandler
    public void onMouseEnterLogOutButton() {
        logOutLabel.setBackground(Background.fill(Color.web("D4D4D4")));
    }

    public void onMouseExitLogOutButton() {
        logOutLabel.setBackground(Background.fill(Color.web("FFFFFF")));
    }
}
