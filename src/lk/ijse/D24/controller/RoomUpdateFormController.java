package lk.ijse.D24.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.D24.bo.BOFactory;
import lk.ijse.D24.bo.custom.RoomBO;
import lk.ijse.D24.dto.RoomDTO;
import lk.ijse.D24.dto.StudentDTO;
import lk.ijse.D24.entity.Rooms;
import lk.ijse.D24.entity.Student;
import org.hibernate.Session;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class RoomUpdateFormController implements Initializable {
    public AnchorPane anchorPane;
    public TextField txtMoney;
    public ComboBox cmbType;
    public ComboBox cmbQuantity;
    public ComboBox cmbID;

    private Session session;
    private RoomBO roomBO = (RoomBO) BOFactory.getBO (BOFactory.BOTypes.ROOM);
    public void btnUpdateOnAction(ActionEvent event) {
        int id= (int) cmbID.getValue();
        String type= String.valueOf(cmbType.getValue());
        double money= Double.parseDouble(txtMoney.getText());
        int quantity= (int) cmbQuantity.getValue();
        RoomDTO roomDTO = new RoomDTO (id,type,money,quantity);

        boolean isUpdate=roomBO.updateRoom (roomDTO);

        if (isUpdate){
            new Alert(Alert.AlertType.INFORMATION, "Student Update Succuss").show ();
            clearData ();
        }else {
            new Alert (Alert.AlertType.ERROR, "Something went Wrong").show ();
        }
    }

    private void clearData() {
        cmbID.setPromptText(String.valueOf(0));
        cmbType.setValue(null);
        cmbQuantity.setValue(null);
        txtMoney.clear();
    }

    public void btnBackOnAction(ActionEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setID();
        setQuantity();
        setType();
    }

    private void setType() {
        ObservableList<String> data = FXCollections.observableArrayList ("Non-AC", "AC", "Non-AC/Food","AC/Food");
        cmbType.setItems (data);
    }

    private void setQuantity() {
        ObservableList<Integer> obList = FXCollections.observableArrayList();
        int num[]=new int[100];
        for (int i = 1; i <=100 ; i++) {
            num[i-1]=i;
        }
        for (int number:num) {
            obList.add(number);
        }
        cmbQuantity.setItems(obList);
    }

    private void setID() {
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

    public void cmbIDOnAction(ActionEvent event) {
        int id= (int) cmbID.getValue();

        try{
            Rooms rooms=roomBO.getRoom(id);
            txtMoney.setText(String.valueOf(rooms.getKeyMoney()));
            cmbType.setPromptText(rooms.getType());
            cmbQuantity.setPromptText(String.valueOf(rooms.getQuantity()));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
