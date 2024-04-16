package person;

import base.Account;
import store.StoreAccountDataBase;
import usage.ControllerInstance;
import usage.Registrable;
import utils.Config;

public class AdminAccount extends Account {
    public AdminAccount() {
        super(Config.adminUsernane, Config.adminPassword, ControllerInstance.ADMIN);
    }
}
