package page.staffpage;

import application.Main;
import base.StoreItem;
import item.Book;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import store.ProgramController;
import store.StoreStorage;
import usage.ItemGenre;
import utils.Config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Optional;

public class ItemStaffPageController extends StaffPage {
    @FXML
    private Label logOutLabel;
    @FXML
    private ImageView profileAvatarIcon;
    @FXML
    private Label usernameLabel;
    @FXML
    private ImageView topLeftIconLogo;
    private static ItemStaffPageController instance;

    /// Item related fields
    private StoreItem storeItem;
    @FXML
    private ImageView itemImage;
    @FXML
    private TextField productTextField;
    @FXML
    private TextField authorBrandTextField;
    @FXML
    private TextField priceTextField;
    @FXML
    private TextField quantityTextField;
    @FXML
    private TextField locationTextField;
    @FXML
    private TextArea descriptionTextArea;
    @FXML
    private Label imagePathLabel;
    @FXML
    private ChoiceBox<ItemGenre> genreChoiceBox;
    @FXML
    private ChoiceBox<String> ratingChoiceBox;

    public ItemStaffPageController() {
        ItemStaffPageController.instance = this;
    }

    public static ItemStaffPageController getInstance() {
        if (instance == null) {
            ItemStaffPageController.instance = new ItemStaffPageController();
        }
        return instance;
    }

    public void setPage(StoreItem item) {
        /// POLYMORPHISM
        usernameLabel.setText(ProgramController.getInstance().getEnteredAccount().getDisplayUsername());
        this.storeItem = item;

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

        ItemGenre[] genreChoices = {ItemGenre.FICTION, ItemGenre.HISTORY, ItemGenre.PHILOSOPHY, ItemGenre.PSYCHOLOGY, ItemGenre.EDUCATION, ItemGenre.SCIENCE};
        genreChoiceBox.getItems().addAll(genreChoices);

        String[] ratingChoice = {"1", "2", "3", "4", "5"};
        ratingChoiceBox.getItems().addAll(ratingChoice);

        /// Set item detail
        itemImage.setImage(this.storeItem.getImage());
        productTextField.setText(this.storeItem.getTitle());
        authorBrandTextField.setText(this.storeItem.getAuthorBrand());
        priceTextField.setText(String.valueOf(this.storeItem.getPrice()));
        quantityTextField.setText(String.valueOf(this.storeItem.getQuantity()));
        locationTextField.setText(this.storeItem.getItemLocation());
        genreChoiceBox.setValue(this.storeItem.getItemGenre());
        ratingChoiceBox.setValue(String.valueOf(this.storeItem.getRating()));
        imagePathLabel.setText(this.storeItem.getImagePath());
        descriptionTextArea.setText(storeItem.getDescription());
    }

    public void onChangeImageButtonClicked() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open a file");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPEG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png"),
                new FileChooser.ExtensionFilter("All images", "*.jpg", "*png."));
        File selectedFile = fileChooser.showOpenDialog(new Stage());
        if (selectedFile != null) {
            try {
                FileInputStream inputStream = new FileInputStream(selectedFile);
                Image newImage = new Image(inputStream);
                this.itemImage.setImage(newImage);
                this.imagePathLabel.setText(selectedFile.getName());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("ERROR LOADING FILES");
        }
    }

    public void onSaveButtonClicked() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Product Detail Confirmation Dialog");
        alert.setContentText("Do you want to proceed?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            storeItem.setTitle(productTextField.getText());
            storeItem.setAuthorBrand(authorBrandTextField.getText());
            storeItem.setRating(Integer.parseInt(ratingChoiceBox.getValue()));
            storeItem.setQuantity(Integer.parseInt(quantityTextField.getText()));
            storeItem.setPrice(Double.parseDouble(priceTextField.getText()));
            storeItem.setItemLocation(locationTextField.getText());
            storeItem.setItemGenre(genreChoiceBox.getValue());
            storeItem.setImage(this.itemImage.getImage());
            storeItem.setDescription(descriptionTextArea.getText());

            goToProductManagementPage();
        } else {
            alert.close();
        }
    }

    public void onDeleteProductButtonClicked() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Product Removal Confirmation Dialog");
        alert.setContentText("Do you want to proceed? : Removing product '" + this.storeItem.getTitle() + "'");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            this.storeItem.removeItself();
            goToProductManagementPage();
        } else {
            alert.close();
        }
    }

    @Override
    public void logOutLabelClicked() {
        super.logOutLabelClicked();
    }

    @Override
    public void topLeftLabelClicked() {
        super.topLeftLabelClicked();
    }

    public void backButtonClicked() {
        Main productManagementPage = Main.getInstance();
        productManagementPage.changeScene("/page/staffpage/ProductManagementPage.fxml");

        ///// Set StaffPage
        ProductManagementController.getInstance().setPage("");
    }


    /// All methods below are related to "graphical" FX EventHandler
    public void onMouseEnterLogOutButton() {
        logOutLabel.setBackground(Background.fill(Color.web("D4D4D4")));
    }

    public void onMouseExitLogOutButton() {
        logOutLabel.setBackground(Background.fill(Color.web("FFFFFF")));
    }


}
