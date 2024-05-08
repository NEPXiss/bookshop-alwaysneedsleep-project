package page.card;

import application.Main;
import base.StoreItem;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import page.userpage.SearchPageController;
import usage.CardSettable;

public class CategoriesCardController implements CardSettable {
    @FXML
    private Label genreLabel;
    @FXML
    private ImageView genreIcon;

    @Override
    public void setCard(StoreItem storeItem) {

    }

    @Override
    public void setCard(StoreItem storeItem, int quantity) {

    }

    @Override
    public void setCard(String genreIconPath, String genreLabel) {
        this.genreLabel.setText(genreLabel);
        try {
            String classLoaderPath = ClassLoader.getSystemResource(genreIconPath).toString();
            this.genreIcon.setImage(new Image(classLoaderPath));
        } catch (Exception e) {
        }
    }

    public void onGenreLabelClicked() {
        Main searchPage = Main.getInstance();
        searchPage.changeScene("../page/userpage/SearchPageInterface.fxml");

        ///Set search Page
        SearchPageController.getInstance().setPage(this.genreLabel.getText());
    }

    public void onEnterGenreLabel() {
        genreLabel.setTextFill(Color.web("3737D5"));
    }

    public void onExitGenreLabel() {
        genreLabel.setTextFill(Color.BLACK);
    }
}
