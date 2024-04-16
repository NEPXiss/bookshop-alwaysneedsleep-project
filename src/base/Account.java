package base;

import javafx.scene.image.Image;
import store.data.Order;
import usage.ControllerInstance;

import java.util.ArrayList;

public abstract class Account {
    private String username;
    private String password;
    private ControllerInstance controllerInstance;

    public Account(String username, String password, ControllerInstance controllerInstance) {
        this.username = username;
        this.password = password;
        setControllerInstance(controllerInstance);
    }

    public void setControllerInstance(ControllerInstance controllerInstance) {
        this.controllerInstance = controllerInstance;
    }

    public ControllerInstance getControllerInstance() {
        return controllerInstance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
