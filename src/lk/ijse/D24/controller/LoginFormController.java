package lk.ijse.D24.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    @FXML
    private AnchorPane root;

    public void txtPasswordOnAction(ActionEvent event) {
        
    }

    public void txtUsernameOnAction(ActionEvent event) {
    }

    public void btnSignInOnAction(ActionEvent event) {
    }

    public void fogotpasswordOnAction(MouseEvent mouseEvent) throws IOException {
        Stage stage=new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/resources/view/fogotPassword.fxml"))));
        stage.setTitle("CreateAcc");
        stage.centerOnScreen();
        stage.show();
    }

    public void createAccOnAction(MouseEvent mouseEvent) throws IOException {
        Stage stage=new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/resources/view/createAccount.fxml"))));
        stage.setTitle("CreateAcc");
        stage.centerOnScreen();
        stage.show();
    }
}
