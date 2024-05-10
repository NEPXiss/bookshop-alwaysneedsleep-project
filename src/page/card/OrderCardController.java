package page.card;

import base.StoreItem;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import store.Order;

public class OrderCardController {
    @FXML
    private VBox detailBox;
    @FXML
    private Label orderIDLabel;
    @FXML
    private Label telephoneLabel;
    @FXML
    private TextArea addressTextArea;
    @FXML
    private Label priceLabel;
    @FXML
    private Label statusLabel;
    private Order order;

    public void setCard(Order order){
        this.order = order;
        orderIDLabel.setText(order.toString());
        telephoneLabel.setText(order.getTelNumber());
        addressTextArea.setText(order.getDeliveryAddress());
        addressTextArea.setDisable(true);
        priceLabel.setText(order.getTotalCost() + " ฿");
        statusLabel.setText(order.getDeliveryStatus().toString());

        for (StoreItem item : order.getOrderItems().keySet()){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/page/card/OrderDetailCard.fxml"));
            HBox itemCard = null;
            try {
                itemCard = fxmlLoader.load();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            OrderDetailCardController cardController = fxmlLoader.getController();
            cardController.setCard(item, order.getOrderItems().get(item));
            detailBox.getChildren().add(itemCard);
        }
    }

}
