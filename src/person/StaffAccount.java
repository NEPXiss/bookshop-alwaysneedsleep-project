package person;

import base.Account;
import store.StoreDataBase;
import usage.Registrable;

public class StaffAccount extends Account implements Registrable {
    private int staffNumber;

    public StaffAccount(String username, String password, int staffNumber) {
        super(username, password);
        this.staffNumber = staffNumber;
    }

    @Override
    public void addAccountToDataBase() {
        StoreDataBase.getStoreAccountDataBase().getAccountMap().put(this.getUsername(), this);
    }

    @Override
    public String getDisplayUsername() {
        return "STAFF : " + super.getUsername() + " NO : " + getStaffNumber();
    }  /// OVERRIDE TO USE POLYMORPHISM

    @Override
    public String getAccountType(){
        return "STAFF"; /// OVERRIDE TO USE POLYMORPHISM
    }

    public int getStaffNumber() {
        return staffNumber;
    }
}
