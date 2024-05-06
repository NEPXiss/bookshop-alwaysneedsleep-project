package page;

import application.Main;
import base.StoreItem;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import person.UserAccount;
import store.ProgramController;
import usage.ItemGenre;

public class CartCardController {
    @FXML
    private Label titleLabel;
    @FXML
    private Label authorBrandLabel;
    @FXML
    private Label genreLabel;
    @FXML
    private Label unitPriceLabel;
    @FXML
    private Label quantityLabel;
    @FXML
    private Label totalPriceLabel;
    @FXML
    private ImageView itemImage;
    private StoreItem storeItem;

    public void setCard(StoreItem storeItem, int quantity){
        this.storeItem = storeItem;
        this.titleLabel.setText(storeItem.getTitle());
        this.authorBrandLabel.setText(storeItem.getAuthorBrand());
        setGenreLabel(storeItem.getItemGenre());
        this.unitPriceLabel.setText(storeItem.getPrice() + " ฿");
        this.itemImage.setImage(storeItem.getImage());
        this.quantityLabel.setText(String.valueOf(quantity));
        double totalPrice = storeItem.getPrice()*quantity;
        this.totalPriceLabel.setText(totalPrice + " ฿");
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

    public void onDeleteLabelClicked(){
        UserAccount userAccount = (UserAccount) ProgramController.getInstance().getEnteredAccount();
        userAccount.getCartMap().remove(this.storeItem);
        Thread t = new Thread(() -> {
            try {
                Main cartPage = Main.getInstance();
                cartPage.changeScene("../page/CartPageInterface.fxml");
                CartPageController.getInstance().setPage();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        t.start();
    }

    public StoreItem getStoreItem() {
        return storeItem;
    }
}
