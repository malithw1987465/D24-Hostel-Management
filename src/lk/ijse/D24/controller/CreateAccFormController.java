package lk.ijse.D24.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateAccFormController {
    public TextField txtUsername;
    public AnchorPane adminpass;
    public PasswordField txtPassword;

    private String name="Malith";
    private String password="1234";


    public void btnCreateAccOnAction(ActionEvent event) throws IOException {

        String Password=txtPassword.getText ();
        String userName=txtUsername.getText ();
        if (userName.equals (name) && password.equals (password)){
            Stage stage3 = new Stage();
            stage3.setScene(new Scene(FXMLLoader.load(getClass().getResource("/resources/view/CreateUserAcc.fxml"))));
            stage3.show();

            Stage stage4 = (Stage) adminpass.getScene().getWindow();
            stage4.close();
        }else{
            new Alert(Alert.AlertType.ERROR, "INVALID ADMIN ATHUENTICATION").show ();
            txtPassword.clear ();
            txtUsername.clear ();
        }

    }



}

