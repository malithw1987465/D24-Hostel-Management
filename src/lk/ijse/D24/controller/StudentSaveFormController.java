package lk.ijse.D24.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.D24.bo.BOFactory;
import lk.ijse.D24.bo.custom.StudentBO;
import lk.ijse.D24.dto.StudentDTO;
import org.hibernate.Session;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class StudentSaveFormController implements Initializable {
    public AnchorPane anchorPane;
    public TextField txtName;
    public TextField txtNIC;
    public TextField txtEmail;
    public ComboBox cmbGender;
    public TextField txtAddress;
    public TextField txtContact;
    public DatePicker date;
    public TextField txtPath;

    private Session session;
    private StudentBO studentBO = (StudentBO) BOFactory.getBO (BOFactory.BOTypes.STUDENT);


    public void btnChooseOnAction(ActionEvent event) {
    }

    public void btnSaveOnAction(ActionEvent event) {
        int id=0;
        String name=txtName.getText();
        String nic=txtNIC.getText();
        String contact=txtContact.getText();
        String address=txtAddress.getText();
        String email=txtEmail.getText();
        String gender= (String) cmbGender.getValue();
        Date dob= Date.valueOf(date.getValue());
        StudentDTO studentDTO = new StudentDTO (id,name,nic,address,contact,dob,email,gender);

        boolean isCheckValidate=checkValidation ();
        if(isCheckValidate){
            studentBO.saveStudent (studentDTO);
            new Alert(Alert.AlertType.CONFIRMATION, "Student saved").show ();
        }


    }

    public void btnBackOnAction(ActionEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setGender();
    }

    private void setGender() {
        ObservableList<String> data = FXCollections.observableArrayList ("Male", "Female", "Other");
        cmbGender.setItems (data);
    }

    private boolean checkValidation(){
        String nameText = txtName.getText();
        String addressText = txtAddress.getText();
        String contactText = txtContact.getText();

        if (!addressText.matches(".{2,}")) {
            new Alert(Alert.AlertType.ERROR, "Address should be at least 3 characters long").show();
            txtAddress.requestFocus();
            return false;
            //} else if (!contactText.matches(".*(?:7|0|(?:\\\\\\\\+94))[0-9]{9,10}")) {
        } else if (!contactText.matches("\\d{10}")) {
            new Alert(Alert.AlertType.ERROR, "Invalid Contact").show();
            txtContact.requestFocus();
            return false;
        }else {
            return true;
        }

    }
}
