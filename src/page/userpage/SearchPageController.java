package page.userpage;

import application.Main;
import base.StoreItem;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import page.card.SearchCardController;
import page.userpage.components.SearchFilter;
import store.ProgramController;
import store.StoreStorage;
import usage.ItemGenre;
import utils.Config;

import java.util.ArrayList;

public class SearchPageController extends UserPage {
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
    private VBox searchBox;
    @FXML
    private Label searchResultAlert;
    @FXML
    private TextField searchTextField;
    @FXML
    private HBox topHBox;
    private ArrayList<StoreItem> searchedStoreItems;
    private static SearchPageController instance;

    public SearchPageController() {
        SearchPageController.instance = this;
    }

    public static SearchPageController getInstance() {
        if (instance == null) {
            SearchPageController.instance = new SearchPageController();
        }
        return instance;
    }

    @Override
    public void setPage(String searchInput) {

        /// POLYMORPHISM
        usernameLabel.setText(ProgramController.getInstance().getEnteredAccount().getDisplayUsername());
        this.searchedStoreItems = new ArrayList<>();

        /// Add filterBox
        FXMLLoader filterLoader = new FXMLLoader();
        filterLoader.setLocation(getClass().getResource("../userpage/components/SearchFilter.fxml"));
        HBox filterBox = null;
        try {
            filterBox = filterLoader.load();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        SearchFilter searchFilter = filterLoader.getController();
        searchFilter.setFilterChoiceBox();
        topHBox.getChildren().add(filterBox);

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
                setSearchBox(searchInput);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        t.start();

    }

    /// this method works together with CategoriesPageController
    public void setSearchBox(String searchInput) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                /// the "if" statement is related to Categories
                if ((searchInput.equals("FICTION")) || (searchInput.equals("HISTORY AND POLITICS")) || (searchInput.equals("PHILOSOPHY")) || (searchInput.equals("SCIENCE")) || (searchInput.equals("PSYCHOLOGY")) || (searchInput.equals("EDUCATION"))) {
                    if ((searchInput.equals("FICTION"))){
                        searchResultAlert.setText("FICTION");
                        for (StoreItem item : StoreStorage.getStorage().getShelfMap().keySet()){
                            if (item.getItemGenre().equals(ItemGenre.FICTION)){
                                FXMLLoader fxmlLoader = new FXMLLoader();
                                fxmlLoader.setLocation(getClass().getResource("../card/SearchCard.fxml"));
                                HBox itemCard = null;
                                try {
                                    itemCard = fxmlLoader.load();
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                                SearchCardController searchCardController = fxmlLoader.getController();
                                searchCardController.setCard(item);
                                searchBox.getChildren().add(itemCard);
                                searchedStoreItems.add(item);
                            }
                        }
                    } else if ((searchInput.equals("PHILOSOPHY"))){
                        searchResultAlert.setText("PHILOSOPHY");
                        for (StoreItem item : StoreStorage.getStorage().getShelfMap().keySet()){
                            if (item.getItemGenre().equals(ItemGenre.PHILOSOPHY)){
                                FXMLLoader fxmlLoader = new FXMLLoader();
                                fxmlLoader.setLocation(getClass().getResource("../card/SearchCard.fxml"));
                                HBox itemCard = null;
                                try {
                                    itemCard = fxmlLoader.load();
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                                SearchCardController searchCardController = fxmlLoader.getController();
                                searchCardController.setCard(item);
                                searchBox.getChildren().add(itemCard);
                                searchedStoreItems.add(item);
                            }
                        }
                    } else if ((searchInput.equals("SCIENCE"))){
                        searchResultAlert.setText("SCIENCE");
                        for (StoreItem item : StoreStorage.getStorage().getShelfMap().keySet()){
                            if (item.getItemGenre().equals(ItemGenre.SCIENCE)){
                                FXMLLoader fxmlLoader = new FXMLLoader();
                                fxmlLoader.setLocation(getClass().getResource("../card/SearchCard.fxml"));
                                HBox itemCard = null;
                                try {
                                    itemCard = fxmlLoader.load();
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                                SearchCardController searchCardController = fxmlLoader.getController();
                                searchCardController.setCard(item);
                                searchBox.getChildren().add(itemCard);
                                searchedStoreItems.add(item);
                            }
                        }
                    }else if ((searchInput.equals("PSYCHOLOGY"))){
                        searchResultAlert.setText("PSYCHOLOGY");
                        for (StoreItem item : StoreStorage.getStorage().getShelfMap().keySet()){
                            if (item.getItemGenre().equals(ItemGenre.PSYCHOLOGY)){
                                FXMLLoader fxmlLoader = new FXMLLoader();
                                fxmlLoader.setLocation(getClass().getResource("../card/SearchCard.fxml"));
                                HBox itemCard = null;
                                try {
                                    itemCard = fxmlLoader.load();
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                                SearchCardController searchCardController = fxmlLoader.getController();
                                searchCardController.setCard(item);
                                searchBox.getChildren().add(itemCard);
                                searchedStoreItems.add(item);
                            }
                        }
                    }else if ((searchInput.equals("EDUCATION"))) {
                        searchResultAlert.setText("EDUCATION");
                        for (StoreItem item : StoreStorage.getStorage().getShelfMap().keySet()){
                            if (item.getItemGenre().equals(ItemGenre.EDUCATION)){
                                FXMLLoader fxmlLoader = new FXMLLoader();
                                fxmlLoader.setLocation(getClass().getResource("../card/SearchCard.fxml"));
                                HBox itemCard = null;
                                try {
                                    itemCard = fxmlLoader.load();
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                                SearchCardController searchCardController = fxmlLoader.getController();
                                searchCardController.setCard(item);
                                searchBox.getChildren().add(itemCard);
                                searchedStoreItems.add(item);
                            }
                        }
                    }else {
                        searchResultAlert.setText("HISTORY AND POLITICS");
                        for (StoreItem item : StoreStorage.getStorage().getShelfMap().keySet()){
                            if (item.getItemGenre().equals(ItemGenre.HISTORY)){
                                FXMLLoader fxmlLoader = new FXMLLoader();
                                fxmlLoader.setLocation(getClass().getResource("../card/SearchCard.fxml"));
                                HBox itemCard = null;
                                try {
                                    itemCard = fxmlLoader.load();
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                                SearchCardController searchCardController = fxmlLoader.getController();
                                searchCardController.setCard(item);
                                searchBox.getChildren().add(itemCard);
                                searchedStoreItems.add(item);
                            }
                        }
                    }
                    /// the "else" statement return the search result
                } else {
                    if (searchInput.isEmpty()) {
                        searchResultAlert.setText("Search Result for  ...");
                    } else {
                        searchResultAlert.setText("Search Result for  ..." + searchInput + "...");
                    }
                    for (StoreItem item : StoreStorage.getStorage().getShelfMap().keySet()) {
                        if ((item.getTitle().toLowerCase().contains(searchInput.toLowerCase())) || ((item.getAuthorBrand().toLowerCase().contains(searchInput.toLowerCase())))) {
                            FXMLLoader fxmlLoader = new FXMLLoader();
                            fxmlLoader.setLocation(getClass().getResource("../card/SearchCard.fxml"));
                            HBox itemCard = null;
                            try {
                                itemCard = fxmlLoader.load();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                            SearchCardController searchCardController = fxmlLoader.getController();
                            searchCardController.setCard(item);
                            searchBox.getChildren().add(itemCard);
                            searchedStoreItems.add(item);
                        }
                    }
                }
            }
        });
    }

    public void setSearchBoxByArrayList(ArrayList<StoreItem> storeItems) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Node topHBox = searchBox.getChildren().get(0);
                Node separator = searchBox.getChildren().get(1);
                searchBox.getChildren().clear();
                searchBox.getChildren().add(topHBox);
                searchBox.getChildren().add(separator);

                for (StoreItem item : storeItems) {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("../card/SearchCard.fxml"));
                    HBox itemCard = null;
                    try {
                        itemCard = fxmlLoader.load();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    SearchCardController searchCardController = fxmlLoader.getController();
                    searchCardController.setCard(item);
                    searchBox.getChildren().add(itemCard);
                }
            }
        });
    }

    public ArrayList<StoreItem> getSearchedStoreItems() {
        return searchedStoreItems;
    }

    /// All methods below are related to "functional" FX EventHandler
    public void userCartLabelClicked() {
        super.userCartLabelClicked();
    }

    public void onWishlistLabelClicked() {
        super.onWishlistLabelClicked();
    }

    public void returnToUserMainPage() {
       super.returnToUserMainPage();
    }

    public void logOutLabelClicked() {
        super.logOutLabelClicked();
    }

    public void onUserOrderLabelClicked() {super.onUserOrderLabelClicked();}

    public void onSearchButtonClicked() {
        Main searchPage = Main.getInstance();
        searchPage.changeScene("../page/userpage/SearchPageInterface.fxml");

        ///Set search Page
        SearchPageController.getInstance().setPage(this.searchTextField.getText());
    }

    public void categoriesLabelClicked() {
        super.categoriesLabelClicked();
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
