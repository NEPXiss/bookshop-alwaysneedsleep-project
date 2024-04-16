package person;

import base.Account;
import store.StoreAccountDataBase;
import store.data.Order;
import usage.ControllerInstance;
import usage.Registrable;

import java.util.ArrayList;

public class UserAccount extends Account implements Registrable {
    private ArrayList<Order> orderList;

    public UserAccount(String username, String password) {
        super(username, password, ControllerInstance.USER);
        this.orderList = new ArrayList<Order>();
    }

    @Override
    public void addAccountToDataBase(){
        StoreAccountDataBase.getStoreAccountDataBase().getAccountMap().put(this.getUsername(),this);
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }
}
