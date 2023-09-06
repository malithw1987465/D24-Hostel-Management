package lk.ijse.D24.controller;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnterScreenController {
    public AnchorPane anchorPane;
    public ProgressBar progressBar;
    public ProgressIndicator ProgressRange;

    public void initialize() {
        new ShowSplashScreen().start();
    }

    class ShowSplashScreen extends Thread {
        public void run() {
            try {
                for (int i = 0; i <= 10; i++) {
                    double x = i * (0.1);
                    progressBar.setProgress(x);
                    ProgressRange.setProgress(x);

                    if (i * 10 == 100) {
                        ProgressRange.setVisible(true);
                        ProgressRange.setProgress(1);
                    }

                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                Platform.runLater(() -> {
                    Stage stage = new Stage();
                    Parent root = null;
                    try {
                        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/resources/view/LoginForm.fxml")));
                    } catch (IOException ex) {
                        Logger.getLogger(EnterScreenController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    assert root != null;
                    Scene scene = new Scene(root);
                    stage.setScene(scene);

                    stage.show();
                    anchorPane.getScene().getWindow().hide();
                });
            } catch (Exception ex) {
                Logger.getLogger(EnterScreenController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
