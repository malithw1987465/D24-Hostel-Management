package lk.ijse.D24.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import lk.ijse.D24.bo.BOFactory;
import lk.ijse.D24.bo.custom.UserBO;

import lk.ijse.D24.config.GenerateCode;
import lk.ijse.D24.config.SendMail;
import lk.ijse.D24.dto.UserDTO;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ForgotPasswordFormController implements Initializable {
    public Button btnChange;
    public TextField txtNewPass;
    public Label lblNew;
    public TextField txtVerification;
    public Label lblVerification;
    public Button btnSubmit;
    public TextField txtPassword;
    public TextField txtEmail;
    public TextField txtName;
    public ComboBox cmbID;
    public AnchorPane anchorPane;
    public  String verifyCode;

    private UserBO userBO = (UserBO) BOFactory.getBO (BOFactory.BOTypes.USER);


    public void cmbIDOnAction(ActionEvent event) throws Exception {
        int id= (int) cmbID.getValue();
        UserDTO uDto=userBO.getUser(id);
        txtName.setText(uDto.getUserName());
        txtEmail.setText(uDto.getEmail());
        txtPassword.setText(uDto.getPassword());
    }

    public void btnSubmitOnAction(ActionEvent event) {
        lblVerification.setVisible(true);
        lblNew.setVisible(true);
        txtVerification.setVisible(true);
        txtNewPass.setVisible(true);
        btnChange.setVisible(true);
        int userId= (int) cmbID.getValue();
        String userName=txtName.getText ();
        String pass=txtPassword.getText ();
        String email=txtEmail.getText ();
        String verfiytext="Your password verification code :";
        try {
            UserDTO u = userBO.getUser (userId);
            if (userName.equals (u.getUserName()) && pass.equals (u.getPassword ())){
                new Alert(Alert.AlertType.INFORMATION, "Check your email").show ();
                verifyCode = String.valueOf (GenerateCode.verifyCode());
                SendMail.outMail (verifyCode,email,verfiytext);

            }else{
                new Alert (Alert.AlertType.ERROR, "Invalid user details!!!! Please Try again.").show ();

            }
        } catch (Exception e) {
//            new Alert (Alert.AlertType.ERROR, "Invalid user details!!!! Please Try again.").show ();
//            clearFeild ();
//            System.out.println (e);
        }
    }

    private void clearFeild() {
        cmbID.setValue(0);
        txtName.clear();
        txtPassword.clear();
        txtEmail.clear();
    }

    public void btnChangeOnAction(ActionEvent event) {
        String textCode=txtVerification.getText ();
        int userId= (int) cmbID.getValue();
        String userName=txtName.getText ();
        String email=txtEmail.getText();
        String pass=txtPassword.getText ();
        String newPass=txtNewPass.getText ();


        if (textCode.equals (verifyCode)){
            userBO.updateUser (new UserDTO (userId,userName,newPass,email));
            new Alert (Alert.AlertType.INFORMATION, "YOUR PASSWORD CHANGED SUCCUSS").show ();
            clearFeild ();
        }else {
            new Alert (Alert.AlertType.WARNING, "CHECK YOUR VERIFY CODE").show ();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnChange.setVisible(false);
        lblNew.setVisible(false);
        lblVerification.setVisible(false);
        txtNewPass.setVisible(false);
        txtVerification.setVisible(false);
        setIDS();
    }

    private void setIDS() {
        List<Integer> userIds = userBO.getUserIds();
        ObservableList users = FXCollections.observableArrayList (userIds);
        cmbID.setItems (users);
    }
}
