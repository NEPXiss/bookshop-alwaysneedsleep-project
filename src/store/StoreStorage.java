package store;

import base.StoreItem;
import item.Book;
import usage.ItemGenre;
import utils.DatabaseInitializer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StoreStorage {
    private HashMap<StoreItem, String> shelfMap; //Map item to shelfLocation
    private ArrayList<StoreItem> newArrivalList;
    private ArrayList<StoreItem> recommendedItemsList;
    private static StoreStorage storeStorage;

    public StoreStorage() {
        this.shelfMap = new HashMap<>();
        this.newArrivalList = new ArrayList<>();
        this.recommendedItemsList = new ArrayList<>();
    }

    public static StoreStorage getStorage() {
        if (storeStorage == null) {
            storeStorage = new StoreStorage();
        }
        return storeStorage;
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
