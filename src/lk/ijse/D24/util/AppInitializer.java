package lk.ijse.D24.util;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppInitializer extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent parent =  FXMLLoader.load(getClass().getResource("LoginForm.fxml"));
        stage.setScene(new Scene(parent));
        stage.setTitle("LoginForm");
        stage.centerOnScreen();
        stage.show();
    }
}