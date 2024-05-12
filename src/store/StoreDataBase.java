package store;

import base.Account;
import person.AdminAccount;
import person.StaffAccount;
import person.UserAccount;

import java.util.ArrayList;
import java.util.HashMap;

public class StoreDataBase {
    /// This class manages accounts
    private HashMap<String, Account> accountMap;  //maps an account’s username to itself.
    private static StoreDataBase storeDataBase;

    public StoreDataBase() {
        this.accountMap = new HashMap<>();

        //put AdminAccount
        AdminAccount adminAccount = new AdminAccount();
        accountMap.put(adminAccount.getUsername(),adminAccount);
        //example accounts
        UserAccount userAccount1 = new UserAccount("suvijak", "12345");
        accountMap.put(userAccount1.getUsername(),userAccount1);
        StaffAccount staffAccount1 = new StaffAccount("staff@Steven", "12345", 2005);
        accountMap.put(staffAccount1.getUsername(),staffAccount1);
    }

    public HashMap<String, Account> getAccountMap() {
        return accountMap;
    }

    public static StoreDataBase getStoreAccountDataBase() {
        if (storeDataBase == null) {
            storeDataBase = new StoreDataBase();
        }
        return storeDataBase;
    }
}
