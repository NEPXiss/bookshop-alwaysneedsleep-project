package store;

import base.StoreItem;
import item.Book;
import usage.ItemGenre;

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

        ////add example book database
        Book book1 = new Book("Siddhartha", "Herman Hesse", ItemGenre.FICTION, 550, 4, 50, "L4", "siddhartha.jpg" );
        this.shelfMap.put(book1,book1.getItemLocation());
        Book book2 = new Book("Crime and Punishment", "Fyodor Dostoevsky", ItemGenre.FICTION, 600, 5, 50, "L4", "crimeandpunishment.jpg" );
        this.shelfMap.put(book2,book2.getItemLocation());
        Book book3 = new Book("Les Miserables", "Victor Hugo", ItemGenre.FICTION, 750, 4, 50, "L4", "lesmiserable.jpg" );
        this.shelfMap.put(book3,book3.getItemLocation());
        Book book4 = new Book("The Stranger", "Albert Camus", ItemGenre.FICTION, 250, 5, 50, "L4", "thestranger.jpg" );
        this.shelfMap.put(book4,book4.getItemLocation());

        ///add example books to newArrivalList
        this.newArrivalList.add(book1);
        this.newArrivalList.add(book3);
        this.newArrivalList.add(book4);
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
