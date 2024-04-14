package store;

import base.Account;

import java.util.HashMap;

public class StoreAccountDataBase {
    private HashMap<String, String> accountMap;
    private static StoreAccountDataBase storeAccountDataBase;

    public StoreAccountDataBase() {
        this.accountMap = new HashMap<>();
        //example accounts
    }

    public HashMap<String, String> getAccountMap() {
        return accountMap;
    }

    public void setAccountMap(HashMap<String, String> accountMap) {
        this.accountMap = accountMap;
    }

    public static StoreAccountDataBase getStoreAccountDataBase() {
        if (storeAccountDataBase == null) {
            storeAccountDataBase = new StoreAccountDataBase();
        }
        return storeAccountDataBase;
    }

    public static void setStoreAccountDataBase(StoreAccountDataBase storeAccountDataBase) {
        StoreAccountDataBase.storeAccountDataBase = storeAccountDataBase;
    }
}
