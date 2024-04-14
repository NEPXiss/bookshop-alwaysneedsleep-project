package store;

import item.Book;

import java.util.ArrayList;
import java.util.HashMap;

public class StoreStorage {
    private HashMap<Book, String> shelfMap;
    private static StoreStorage storeStorage;

    public StoreStorage() {
        this.shelfMap = new HashMap<>();
        ////add example book database
    }

    public static StoreStorage getStorage() {
        if (storeStorage == null) {
            storeStorage = new StoreStorage();
        }
        return storeStorage;
    }

    public HashMap<Book, String> getShelfMap() {
        return shelfMap;
    }

    public void addBookToShelf(Book book, String shelf) {
        this.shelfMap.put(book, shelf);
    }
}
