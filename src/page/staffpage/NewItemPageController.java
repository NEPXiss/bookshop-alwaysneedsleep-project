package page.staffpage;

import base.StoreItem;
import item.Book;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import store.ProgramController;
import store.StoreStorage;
import usage.ItemGenre;
import utils.Config;

import java.util.Optional;

public class NewItemPageController extends ItemStaffPageController{
    @FXML
    private Label logOutLabel;
    @FXML
    private ImageView profileAvatarIcon;
    @FXML
    private Label usernameLabel;
    @FXML
    private ImageView topLeftIconLogo;
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
    private static NewItemPageController instance;

    public NewItemPageController() {NewItemPageController.instance = this;}
    public static NewItemPageController getInstance() {
        if (instance == null) {
            NewItemPageController.instance = new NewItemPageController();
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

        ItemGenre[] genreChoices = {ItemGenre.FICTION, ItemGenre.HISTORY, ItemGenre.PHILOSOPHY, ItemGenre.PSYCHOLOGY, ItemGenre.EDUCATION, ItemGenre.SCIENCE, ItemGenre.STATIONERY};
        genreChoiceBox.getItems().addAll(genreChoices);

        String[] ratingChoice = {"1", "2", "3", "4", "5"};
        ratingChoiceBox.getItems().addAll(ratingChoice);
    }

    @Override
    public void onSaveButtonClicked() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Product Detail Confirmation Dialog");
        alert.setContentText("Do you want to proceed?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            if (genreChoiceBox.getValue().equals(ItemGenre.STATIONERY)) {
                ////
            } else {
                Book newBook = new Book(productTextField.getText(), authorBrandTextField.getText(), genreChoiceBox.getValue(), Double.parseDouble(priceTextField.getText()),
                        Integer.parseInt(ratingChoiceBox.getValue()), Integer.parseInt(quantityTextField.getText()), locationTextField.getText(), this.imagePathLabel.getText(), descriptionTextArea.getText());
                newBook.setImage(this.itemImage.getImage());
                StoreStorage.getStorage().getShelfMap().put(newBook,newBook.getItemLocation());
            }
            goToProductManagementPage();
        } else {
            alert.close();
        }
    }

    @Override
    public void onChangeImageButtonClicked() {
        super.onChangeImageButtonClicked();
    }

    @Override
    public void backButtonClicked() {
        super.backButtonClicked();
    }

    @Override
    public void logOutLabelClicked() {
        super.logOutLabelClicked();
    }

    @Override
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



