package person;

import base.Account;
import store.StoreDataBase;
import usage.ControllerInstance;
import usage.Registrable;

public class StaffAccount extends Account implements Registrable {
    private int staffNumber;
    private String staffDisplayName;

    public StaffAccount(String username, String password, int staffNumber, String staffDisplayName) {
        super(username, password, ControllerInstance.STAFF);
        this.staffNumber = staffNumber;
        this.staffDisplayName = staffDisplayName;
    }

    @Override
    public void addAccountToDataBase(){
        StoreDataBase.getStoreAccountDataBase().getAccountMap().put(this.getUsername(),this);
        StoreDataBase.getStoreAccountDataBase().getStaffAccountsArrayList().add(this);
    }

    public int getStaffNumber() {
        return staffNumber;
    }

    public void setStaffNumber(int staffNumber) {
        this.staffNumber = staffNumber;
    }

    public String getStaffDisplayName() {
        return staffDisplayName;
    }

    public void setStaffDisplayName(String staffDisplayName) {
        this.staffDisplayName = staffDisplayName;
    }
}
