package store;

import base.StoreItem;

import java.util.ArrayList;
import java.util.HashMap;

public class StoreStorage {
    /// this class manages StoreItems and Orders
    private HashMap<StoreItem, String> shelfMap; //Map item to shelfLocation
    private ArrayList<StoreItem> newArrivalList;
    private ArrayList<StoreItem> recommendedItemsList;
    private static StoreStorage storeStorage;
    private ArrayList<Order> orderArrayList;

    public StoreStorage() {
        this.shelfMap = new HashMap<>();
        this.newArrivalList = new ArrayList<>();
        this.recommendedItemsList = new ArrayList<>();
        this.orderArrayList = new ArrayList<>();
    }

    public static StoreStorage getStorage() {
        if (storeStorage == null) {
            storeStorage = new StoreStorage();
        }
        return storeStorage;
    }

    public ArrayList<Order> getOrderArrayList() {
        return orderArrayList;
    }

    public HashMap<StoreItem, String> getShelfMap() {
        return shelfMap;
    }

    public ArrayList<StoreItem> getNewArrivalList() {
        return newArrivalList;
    }

    public ArrayList<StoreItem> getRecommendedItemsList() {
        return recommendedItemsList;
    }

    public void addItemToShelf(StoreItem storeItem, String shelf) {
        this.shelfMap.put(storeItem, shelf);
    }
}
