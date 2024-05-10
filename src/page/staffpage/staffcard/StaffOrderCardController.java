package page.staffpage.staffcard;

import base.StoreItem;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import page.card.OrderDetailCardController;
import store.Order;
import usage.DeliveryStatus;

public class StaffOrderCardController {
    @FXML
    private ChoiceBox<DeliveryStatus> statusChoiceBox;
    @FXML
    private Label newStatusAlertLabel;
    @FXML
    private Label orderIDLabel;
    @FXML
    private Label telephoneLabel;
    @FXML
    private TextArea addressTextArea;
    @FXML
    private Label priceLabel;
    @FXML
    private VBox detailBox;
    private Order order;
    public void setCard(Order order){
        this.order = order;
        DeliveryStatus[] deliveryStatuses = {DeliveryStatus.AWAITING, DeliveryStatus.CONFIRMED, DeliveryStatus.DELIVERED};
        statusChoiceBox.getItems().addAll(deliveryStatuses);

        this.order = order;
        orderIDLabel.setText(order.toString());
        telephoneLabel.setText(order.getTelNumber());
        addressTextArea.setText(order.getDeliveryAddress());
        addressTextArea.setDisable(true);
        priceLabel.setText(order.getTotalCost() + " ฿");

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


        statusChoiceBox.setValue(order.getDeliveryStatus());
    }

    public void onSaveButtonClicked(){
        order.setDeliveryStatus(statusChoiceBox.getValue());
        newStatusAlertLabel.setText("Status has been set to : " + order.getDeliveryStatus());
    }

    public void onResetButtonClicked(){
        statusChoiceBox.setValue(order.getDeliveryStatus());
    }

}
