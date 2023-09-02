package lk.ijse.D24.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class RoomUpdateFormController implements Initializable {
    public AnchorPane anchorPane;
    public TextField txtMoney;
    public ComboBox cmbType;
    public ComboBox cmbQuantity;
    public ComboBox cmbID;

    public void btnUpdateOnAction(ActionEvent event) {
    }

    public void btnBackOnAction(ActionEvent event) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
