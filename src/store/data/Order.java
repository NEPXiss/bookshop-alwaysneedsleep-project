package store.data;

import base.StoreItem;
import person.UserAccount;

import java.util.ArrayList;
import java.util.HashMap;

public class Order {
    private String username;
    private HashMap<StoreItem,Integer> orderItems;
    private double totalCost;
    private String deliveryAddress;

    public Order(String username, HashMap<StoreItem, Integer> orderItems, double totalCost, String deliveryAddress) {
        this.username = username;
        this.orderItems = orderItems;
        this.totalCost = totalCost;
        this.deliveryAddress = deliveryAddress;
    }

    public String getUsername() {
        return username;
    }

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
}
