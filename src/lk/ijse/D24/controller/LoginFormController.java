package lk.ijse.D24.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.D24.bo.BOFactory;
import lk.ijse.D24.bo.custom.UserBO;
import lk.ijse.D24.dto.UserDTO;

import java.io.IOException;
import java.util.List;

public class LoginFormController  {
    public AnchorPane root;
    public AnchorPane anchorPane;
    public TextField username;
    public TextField txtpassword;
    public Button btnSignin;

    private UserBO userBO = (UserBO) BOFactory.getBO (BOFactory.BOTypes.USER);

    public boolean checkUserDetail(){
        String userName=username.getText();
        String password=txtpassword.getText();

        List<UserDTO> userDTOList= userBO.loadAll();

        for(UserDTO dto:userDTOList){
            if(dto.getUserName().equals(userName) && dto.getPassword().equals(password)){

                return true;

            }else{
                System.out.println("uncompleted");
            }
        }
        return false;
    }

    public void btnSignInOnAction(ActionEvent event) throws IOException {
        if(checkUserDetail()){
            Stage stage=(Stage) root.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/resources/view/MainForm.fxml"))));

            new Alert(Alert.AlertType.CONFIRMATION, "Login Successfully").show();
        }
    }

    public void fogotpasswordOnAction(MouseEvent mouseEvent) throws IOException {
        Stage stage=new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/resources/view/ForgotPasswordForm.fxml"))));
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
