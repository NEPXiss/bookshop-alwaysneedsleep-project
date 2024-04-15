package store;

import base.Account;
import person.AdminAccount;
import utils.Config;

import java.util.HashMap;

public class StoreAccountDataBase {
    private HashMap<String, Account> accountMap;  //map Account username to Account
    private static StoreAccountDataBase storeAccountDataBase;

    public StoreAccountDataBase() {
        this.accountMap = new HashMap<>();

        //put AdminAccount
        AdminAccount adminAccount = new AdminAccount();
        accountMap.put(adminAccount.getUsername(),adminAccount);
        //example accounts


    }

    public HashMap<String, Account> getAccountMap() {
        return accountMap;
    }

    public void setAccountMap(HashMap<String, Account> accountMap) {
        this.accountMap = accountMap;
    }

    public static void setStoreAccountDataBase(StoreAccountDataBase storeAccountDataBase) {
        StoreAccountDataBase.storeAccountDataBase = storeAccountDataBase;
    }

    public static StoreAccountDataBase getStoreAccountDataBase() {
        if (storeAccountDataBase == null) {
            storeAccountDataBase = new StoreAccountDataBase();
        }
        return storeAccountDataBase;
    }
}
