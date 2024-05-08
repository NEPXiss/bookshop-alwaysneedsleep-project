package store;

import base.Account;
import person.AdminAccount;
import person.StaffAccount;
import person.UserAccount;
import utils.Config;

import java.util.ArrayList;
import java.util.HashMap;

public class StoreAccountDataBase {
    private HashMap<String, Account> accountMap;  //map Account username to Account
    private ArrayList<UserAccount> userAccountArrayList;
    private ArrayList<StaffAccount> staffAccountsArrayList;
    private static StoreAccountDataBase storeAccountDataBase;

    public StoreAccountDataBase() {
        this.accountMap = new HashMap<>();

        //put AdminAccount
        AdminAccount adminAccount = new AdminAccount();
        accountMap.put(adminAccount.getUsername(),adminAccount);
        //example accounts
        UserAccount userAccount1 = new UserAccount("suvijak", "12345");
        accountMap.put(userAccount1.getUsername(),userAccount1);

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

    public ArrayList<UserAccount> getUserAccountArrayList() {
        return userAccountArrayList;
    }

    public void setUserAccountArrayList(ArrayList<UserAccount> userAccountArrayList) {
        this.userAccountArrayList = userAccountArrayList;
    }

    public ArrayList<StaffAccount> getStaffAccountsArrayList() {
        return staffAccountsArrayList;
    }

    public void setStaffAccountsArrayList(ArrayList<StaffAccount> staffAccountsArrayList) {
        this.staffAccountsArrayList = staffAccountsArrayList;
    }
}
