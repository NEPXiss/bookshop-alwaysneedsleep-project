package person;

import base.Account;
import store.StoreAccountDataBase;
import usage.Registrable;

public class StaffAccount extends Account implements Registrable {
    private int staffNumber;
    private String staffDisplayName;

    public StaffAccount(String username, String password, int staffNumber, String staffDisplayName) {
        super(username, password);
        this.staffNumber = staffNumber;
        this.staffDisplayName = staffDisplayName;
    }

    @Override
    public void addAccountToDataBase(){
        StoreAccountDataBase.getStoreAccountDataBase().getAccountMap().put(this.getUsername(),this);
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
