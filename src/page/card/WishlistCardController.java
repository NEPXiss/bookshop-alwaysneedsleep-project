package page.card;

import application.Main;
import base.StoreItem;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import page.userpage.BookPageController;
import page.userpage.CartPageController;
import page.userpage.WishlistPageController;
import person.UserAccount;
import store.ProgramController;
import usage.ItemGenre;

public class WishlistCardController {
    @FXML
    private Label titleLabel;
    @FXML
    private Label authorBrandLabel;
    @FXML
    private Label genreLabel;
    @FXML
    private Label unitPriceLabel;
    @FXML
    private ImageView itemImage;
    @FXML
    private HBox cardBox;
    private StoreItem storeItem;

    public void setCard(StoreItem storeItem){
        this.storeItem = storeItem;
        this.titleLabel.setText(storeItem.getTitle());
        this.authorBrandLabel.setText(storeItem.getAuthorBrand());
        setGenreLabel(storeItem.getItemGenre());
        this.unitPriceLabel.setText(storeItem.getPrice() + " ฿");
        this.itemImage.setImage(storeItem.getImage());
    }

    public void setGenreLabel(ItemGenre itemGenre) {
        if (itemGenre.equals(ItemGenre.FICTION)) {
            genreLabel.setText("Fiction");
        } else if (itemGenre.equals(ItemGenre.EDUCATION)) {
            genreLabel.setText("Education");
        } else if (itemGenre.equals(ItemGenre.HISTORY)) {
            genreLabel.setText("History & Politics");
        } else if (itemGenre.equals(ItemGenre.SCIENCE)) {
            genreLabel.setText("Science");
        } else if (itemGenre.equals(ItemGenre.PSYCHOLOGY)) {
            genreLabel.setText("Psychology");
        } else if (itemGenre.equals(ItemGenre.PHILOSOPHY)) {
            genreLabel.setText("Philosophy");
        } else if (itemGenre.equals(ItemGenre.STATIONERY)) {
            genreLabel.setText("Stationery");
        }
    }

    public void onMouseClickTitleLabel(){
        Main bookPage = Main.getInstance();
        bookPage.changeScene("../page/userpage/BookPageInterface.fxml");

        ///Set up -> setPage and setMoreFromThisAuthor
        BookPageController.getInstance().setPage(this.storeItem);
        Thread t = new Thread(() -> {
            try {
                BookPageController.getInstance().setMoreFromThisBox(this.storeItem);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        t.start();
    }

    public void onDeleteLabelClicked(){
        UserAccount userAccount = (UserAccount) ProgramController.getInstance().getEnteredAccount();
        userAccount.getWishList().remove(this.storeItem);
        Thread t = new Thread(() -> {
            try {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        /// remove wishlist card
                        WishlistPageController.getInstance().getWishlistBox().getChildren().remove(cardBox);
                    }
                });
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        t.start();
    }

    public void onEnterTitleLabel(){
        titleLabel.setTextFill(Color.web("3737D5"));
    }
    public void onExitTitleLabel() {
        titleLabel.setTextFill(Color.BLACK);
    }
}
