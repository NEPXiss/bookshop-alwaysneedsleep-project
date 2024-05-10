package store;

import base.StoreItem;
import person.UserAccount;
import store.StoreStorage;
import usage.DeliveryStatus;

import java.util.ArrayList;
import java.util.HashMap;

public class Order {
    private String username;
    private HashMap<StoreItem,Integer> orderItems;
    private double totalCost;
    private String telNumber;
    private String deliveryAddress;
    private DeliveryStatus deliveryStatus;

    public Order(String username, HashMap<StoreItem, Integer> orderItems, double totalCost, String deliveryAddress, String telNumber) {
        this.username = username;
        this.orderItems = orderItems;
        this.totalCost = totalCost;
        this.deliveryAddress = deliveryAddress;
        this.telNumber = telNumber;
        this.deliveryStatus = DeliveryStatus.AWAITING;
    }

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
    public String getTelNumber() {
        return telNumber;
    }

    public String getUsername() {return username;}

    public void setUsername(String username) {
        this.username = username;
    }

    public HashMap<StoreItem, Integer> getOrderItems() { return orderItems;}

    public double getTotalCost() {
        return totalCost;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }
}
