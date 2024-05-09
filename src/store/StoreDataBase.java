package store;

import base.Account;
import person.AdminAccount;
import person.StaffAccount;
import person.UserAccount;

import java.util.ArrayList;
import java.util.HashMap;

public class StoreDataBase {
    /// This class manages everything related to accounts
    private HashMap<String, Account> accountMap;  //map Account username to Account
    private ArrayList<UserAccount> userAccountArrayList;
    private ArrayList<StaffAccount> staffAccountsArrayList;
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

    public void setAccountMap(HashMap<String, Account> accountMap) {
        this.accountMap = accountMap;
    }

    public static void setStoreAccountDataBase(StoreDataBase storeDataBase) {
        StoreDataBase.storeDataBase = storeDataBase;
    }

    public static StoreDataBase getStoreAccountDataBase() {
        if (storeDataBase == null) {
            storeDataBase = new StoreDataBase();
        }
        return storeDataBase;
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
