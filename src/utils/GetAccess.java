package utils;

import store.StoreDataBase;

public class GetAccess {
    public static boolean validateLogin(String username, String password){
        boolean isValid = false;
        if (StoreDataBase.getStoreAccountDataBase().getAccountMap().get(username).getPassword().equals(password)){
            isValid = true;
        }
        return isValid;
    }

    public static boolean isAccountExist(String username){
        return StoreDataBase.getStoreAccountDataBase().getAccountMap().containsKey(username);
    }
}
