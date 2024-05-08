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
        StoreStorage.getStorage().getOrderArrayList().add(this);
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getUsername() {return username;}

    public void setUsername(String username) {
        this.username = username;
    }

    public HashMap<StoreItem, Integer> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(HashMap<StoreItem, Integer> orderItems) {
        this.orderItems = orderItems;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public DeliveryStatus getDeliveryStatus() {return deliveryStatus;}

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {this.deliveryStatus = deliveryStatus;}
}
