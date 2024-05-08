package person;

import base.Account;
import usage.ControllerInstance;
import utils.Config;

public class AdminAccount extends Account {
    public AdminAccount() {
        super(Config.adminUsernane, Config.adminPassword, ControllerInstance.ADMIN);
    }
}
