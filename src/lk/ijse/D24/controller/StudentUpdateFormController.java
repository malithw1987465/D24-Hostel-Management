package lk.ijse.D24.controller;

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
import lk.ijse.D24.entity.Student;
import org.hibernate.Session;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class StudentUpdateFormController implements Initializable {

    public ComboBox cmbID;
    public ComboBox cmbGender;
    public DatePicker date;
    public TextField txtContact;
    public TextField txtAddress;
    public TextField txtEmail;
    public TextField txtNIC;
    public TextField txtName;
    public AnchorPane anchorPane;

    private Session session;
    private StudentBO studentBO = (StudentBO) BOFactory.getBO (BOFactory.BOTypes.STUDENT);

    public void btnBackOnAction(ActionEvent event) {
    }

    public void cmbIDOnAction(ActionEvent event) throws Exception {
        int id= (int) cmbID.getValue();

        try{
            Student studentDTO=studentBO.getStudent(id);
            txtName.setText(studentDTO.getName());
            txtNIC.setText(studentDTO.getNic());
            txtAddress.setText(studentDTO.getAddress());
            txtContact.setText(studentDTO.getContact());
            txtEmail.setText(studentDTO.getEmail());
            cmbGender.setPromptText(studentDTO.getGender());
            date.setPromptText(String.valueOf(studentDTO.getDob()));

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void btnUpdateOnAction(ActionEvent event) {
        int id= (int) cmbID.getValue();
        String name=txtName.getText();
        String nic=txtNIC.getText();
        String address=txtAddress.getText();
        String contact=txtContact.getText();
        String email=txtEmail.getText();
        String gender= cmbGender.getValue().toString();
        Date dob= Date.valueOf(date.getValue());
       StudentDTO studentDTO = new StudentDTO (id,name,nic,address,contact,dob,email,gender);

        boolean isUpdate=studentBO.updateStudent (studentDTO);

        if (isUpdate){
            new Alert (Alert.AlertType.INFORMATION, "Student Update Succuss").show ();
            clearData ();
        }else {
            new Alert (Alert.AlertType.ERROR, "Something went Wrong").show ();
        }
    }

    public void clearData() {
        cmbID.setPromptText(String.valueOf(0));
        txtName.clear ();
        txtNIC.clear();
        txtEmail.clear();
        txtAddress.clear ();
        txtContact.clear ();
        date.setValue (null);
        cmbGender.setValue(null);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadStudentID();
        loadGender();
    }

    private void loadGender() {
        ObservableList<String> data = FXCollections.observableArrayList ("Male", "Female", "Other");
        cmbGender.setItems (data);
    }

    private void loadStudentID() {
        ObservableList<Integer> obList = FXCollections.observableArrayList();
        int num[]=new int[100];
        for (int i = 1; i <=100 ; i++) {
            num[i-1]=i;
        }
        for (int number:num) {
            obList.add(number);
        }
        cmbID.setItems(obList);
    }
}
