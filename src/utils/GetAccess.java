package utils;

import store.StoreAccountDataBase;
import usage.ControllerInstance;

public class GetAccess {
    public static boolean validateLogin(String username, String password){
        boolean isValid = false;
        if (StoreAccountDataBase.getStoreAccountDataBase().getAccountMap().get(username).getPassword().equals(password)){
            isValid = true;
        }
        return isValid;
    }
}
