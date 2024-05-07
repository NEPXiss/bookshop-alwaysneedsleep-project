package person;

import base.Account;
import base.StoreItem;
import javafx.scene.image.Image;
import store.StoreAccountDataBase;
import store.data.Order;
import usage.ControllerInstance;
import usage.Registrable;

import java.util.ArrayList;
import java.util.HashMap;

public class UserAccount extends Account implements Registrable {
    private ArrayList<Order> orderList;
    private HashMap<StoreItem, Integer> cartMap;
    private ArrayList<StoreItem> wishList;

    public UserAccount(String username, String password) {
        super(username, password, ControllerInstance.USER);
        this.orderList = new ArrayList<Order>();
        this.cartMap = new HashMap<>();
        this.wishList = new ArrayList<>();
    }

    @Override
    public void addAccountToDataBase(){
        StoreAccountDataBase.getStoreAccountDataBase().getAccountMap().put(this.getUsername(),this);
    }

    public ArrayList<StoreItem> getWishList(){
        return wishList;
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public HashMap<StoreItem, Integer> getCartMap() {return cartMap;}

    public void setOrderList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }
}
