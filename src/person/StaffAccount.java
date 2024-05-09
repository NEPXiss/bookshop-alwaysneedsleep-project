package person;

import base.Account;
import store.StoreDataBase;
import usage.ControllerInstance;
import usage.Registrable;

public class StaffAccount extends Account implements Registrable {
    private int staffNumber;

    public StaffAccount(String username, String password, int staffNumber) {
        super(username, password, ControllerInstance.STAFF);
        this.staffNumber = staffNumber;
    }

    @Override
    public void addAccountToDataBase() {
        StoreDataBase.getStoreAccountDataBase().getAccountMap().put(this.getUsername(), this);
        StoreDataBase.getStoreAccountDataBase().getStaffAccountsArrayList().add(this);
    }

    @Override
    public String getDisplayUsername() {
        return "STAFF : " + super.getUsername() + " NO : " + getStaffNumber();
    }  /// OVERRIDE TO USE POLYMORPHISM

    public int getStaffNumber() {
        return staffNumber;
    }
}
