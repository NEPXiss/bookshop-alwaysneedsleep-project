package person;

import base.Account;
import store.StoreAccountDataBase;
import store.data.Order;
import usage.Registrable;

import java.util.ArrayList;

public class UserAccount extends Account implements Registrable {
    private String displayName;
    private ArrayList<Order> orderList;

    public UserAccount(String username, String password, String displayName) {
        super(username, password);
        this.displayName = displayName;
        this.orderList = new ArrayList<Order>();
    }

    @Override
    public void addAccountToDataBase(){
        StoreAccountDataBase.getStoreAccountDataBase().getAccountMap().put(this.getUsername(),this.getPassword());
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }
}
