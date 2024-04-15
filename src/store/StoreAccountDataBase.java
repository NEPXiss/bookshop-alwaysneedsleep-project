package store;

import base.Account;
import person.AdminAccount;

import java.util.HashMap;

public class StoreAccountDataBase {
    private HashMap<String, String> accountMap;
    private static StoreAccountDataBase storeAccountDataBase;

    public StoreAccountDataBase() {
        this.accountMap = new HashMap<>();

        //put AdminAccount
        AdminAccount adminAccount = new AdminAccount();
        adminAccount.addAccountToDataBase();

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
}
