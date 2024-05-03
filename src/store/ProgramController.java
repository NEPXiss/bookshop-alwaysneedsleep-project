package store;

import base.Account;
import usage.ControllerInstance;

public class ProgramController {
    private ControllerInstance controllerInstance;
    private Account enteredAccount;
    private static ProgramController instance;

    public ProgramController() {
        ProgramController.instance = this;
    }

    public Account getEnteredAccount() {
        return enteredAccount;
    }

    public void setEnteredAccount(Account enteredAccount, ControllerInstance controllerInstance) {
        this.enteredAccount = enteredAccount;
        this.controllerInstance = controllerInstance;
    }

    public static ProgramController getInstance() {
        if (instance == null) {
            instance = new ProgramController();
        }
        return instance;
    }

    public ControllerInstance getControllerInstance() {
        return controllerInstance;
    }
}
