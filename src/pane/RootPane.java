package pane;

import javafx.scene.layout.VBox;

public class RootPane extends VBox {
    private static RootPane instance;

    public static RootPane getRootPane(){
        if (instance == null)
            instance = new RootPane();
        return instance;
    }

    public RootPane(){

    }
}
