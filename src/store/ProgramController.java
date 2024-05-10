package store;

import base.Account;

public class ProgramController {
    private Account enteredAccount;
    private static ProgramController instance;

    public ProgramController() {
        ProgramController.instance = this;
    }

    public Account getEnteredAccount() {
        return enteredAccount;
    }

    public void setEnteredAccount(Account enteredAccount) {
        this.enteredAccount = enteredAccount;
    }

    public static ProgramController getInstance() {
        if (instance == null) {
            instance = new ProgramController();
        }
        return instance;
    }
}
