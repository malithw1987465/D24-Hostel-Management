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
import org.hibernate.Session;

import java.net.URL;
import java.util.ResourceBundle;

public class RoomSaveFormController implements Initializable {
    public TextField txtMoney;
    public AnchorPane anchorPane;
    public ComboBox cmbType;
    public ComboBox cmbQuantity;

    private Session session;
    private RoomBO roomBO = (RoomBO) BOFactory.getBO (BOFactory.BOTypes.ROOM);

    public void btnSaveOnAction(ActionEvent event) {
        int id=0;
        String type= String.valueOf(cmbType.getValue());
        double money= Double.parseDouble(txtMoney.getText());
        int quantity= (int) cmbQuantity.getValue();
        RoomDTO roomDTO = new RoomDTO (id,type,money,quantity);

        boolean isCheckValidate=checkValidation ();
        if(isCheckValidate){
            roomBO.saveRoom(roomDTO);
            new Alert(Alert.AlertType.CONFIRMATION, "Room saved").show ();
        }
    }

    private boolean checkValidation() {
        String type = String.valueOf(cmbType.getValue());
        String money= txtMoney.getText();
        int quantity= (int) cmbQuantity.getValue();
        String quanty= String.valueOf(quantity);

        if (!money.matches("^[0-9]+[.]?[0-9]*$")) {
            new Alert (Alert.AlertType.ERROR, "invalid key money").show ();
            txtMoney.requestFocus ();
            return false;
        } else if (!quanty.matches("^\\d+$")) {
            //} else if (!qtyText.matches("[0-9]")) {
            new Alert(Alert.AlertType.ERROR, "Invalid qty").show();
            cmbQuantity.requestFocus();
            return false;
        }else {
            return true;
        }
    }

    public void btnBackOnAction(ActionEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setType();
        setQuantity();
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

    private void setType() {
        ObservableList<String> data = FXCollections.observableArrayList ("Non-AC", "AC", "Non-AC/Food","AC/Food");
        cmbType.setItems (data);
    }
}
