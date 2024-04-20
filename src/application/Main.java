package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import page.LoginController;
import utils.Config;

import java.io.IOException;

public class Main extends Application {
    private static Stage stg;
    public static void main(String[] args) {
        launch();
    }
    private static Main instance;
    @Override
    public void start(Stage primaryStage) throws Exception {
        stg = primaryStage;
        instance = this;
        Parent root = FXMLLoader.load(getClass().getResource("../page/LoginInterface.fxml"));
        Scene scene = new Scene(root,1360,786);
        primaryStage.setScene(scene);

        try {
            String classLoaderPath = ClassLoader.getSystemResource(Config.logoImage2).toString();
            Image logoImage = new Image(classLoaderPath);
            primaryStage.getIcons().add(logoImage);
        } catch (Exception e) {}


        primaryStage.setTitle("BookSphere");
        primaryStage.setResizable(false);
        primaryStage.show();

        ///Set logo image in LoginInterface
        LoginController.getInstance().setLogoImage();

    }

    public static Main getInstance() {
        return instance;
    }

    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }



}
