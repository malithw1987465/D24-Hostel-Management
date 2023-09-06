package lk.ijse.D24.util;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppInitializer extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setScene(new Scene (FXMLLoader.load(getClass().getResource("/resources/view/LoadScreen.fxml"))));
        primaryStage.setTitle ("LOGIN");
        primaryStage.show();
    }
}