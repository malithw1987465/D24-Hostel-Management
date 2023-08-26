package lk.ijse.D24.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.D24.bo.BOFactory;
import lk.ijse.D24.bo.custom.UserBO;
import lk.ijse.D24.dto.UserDTO;
import lk.ijse.D24.util.Notification;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class LoginFormController implements Initializable {
    public AnchorPane root;
    public TextField username;
    public TextField txtpassword;
    public Button btnSignin;

    private UserBO userBO = (UserBO) BOFactory.getBO (BOFactory.BOTypes.USER);


    public void txtPasswordOnAction(ActionEvent event) {
        
    }

    public void txtUsernameOnAction(ActionEvent event) {
    }
    public boolean checkUserDetail(){
        String userName = username.getText ();
        String pass=txtpassword.getText ();

        List<UserDTO> userList = userBO.loadAll ();

        for (UserDTO dto : userList) {
            if(dto.getUsername ().equals (userName) && dto.getPassword ().equals (pass)){
                return true;
            }
        }
        return false;
    }

    public void btnSignInOnAction(ActionEvent event) throws IOException {
        if (checkUserDetail ()){

            Stage stage= (Stage) root.getScene ().getWindow ();
            stage.setScene(new Scene (FXMLLoader.load(getClass().getResource("/resources/view/MainForm.fxml"))));

            lk.ijse.D24.util.Notification.notification ("Login Succussfully");
        }
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
