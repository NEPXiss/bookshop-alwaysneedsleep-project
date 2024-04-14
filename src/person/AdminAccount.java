package person;

import base.Account;
import store.StoreAccountDataBase;
import usage.Registrable;
import utils.Config;

public class AdminAccount extends Account implements Registrable {
    public AdminAccount() {
        super(Config.adminUsernane, Config.adminPassword);
    }

    @Override
    public void addAccountToDataBase(){
        StoreAccountDataBase.getStoreAccountDataBase().getAccountMap().put(this.getUsername(),this.getPassword());
    }
}
