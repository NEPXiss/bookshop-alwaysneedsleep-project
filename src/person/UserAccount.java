package person;

import base.Account;
import base.StoreItem;
import store.StoreDataBase;
import store.Order;
import usage.Registrable;

import java.util.ArrayList;
import java.util.HashMap;

public class UserAccount extends Account implements Registrable {
    private ArrayList<Order> orderList;
    private HashMap<StoreItem, Integer> cartMap;
    private ArrayList<StoreItem> wishList;
    public UserAccount(String username, String password) {
        super(username, password);
        this.orderList = new ArrayList<Order>();
        this.cartMap = new HashMap<>();
        this.wishList = new ArrayList<>();
    }

    @Override
    public String getDisplayUsername(){
        return "USER : " + super.getUsername();
    }  /// POLYMORPHISM

    @Override
    public String getAccountType(){
        return "USER";
    } /// POLYMORPHISM

    public ArrayList<Order> getOrderList() {return orderList;}

    public HashMap<StoreItem, Integer> getCartMap() {
        return cartMap;
    }

    public ArrayList<StoreItem> getWishList() {
        return wishList;
    }

    @Override
    public void addAccountToDataBase(){
        StoreDataBase.getStoreAccountDataBase().getAccountMap().put(this.getUsername(),this);
    }
}
