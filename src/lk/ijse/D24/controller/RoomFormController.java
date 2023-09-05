package lk.ijse.D24.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.D24.bo.BOFactory;
import lk.ijse.D24.bo.custom.RoomBO;
import lk.ijse.D24.dto.RoomDTO;
import lk.ijse.D24.dto.StudentDTO;
import lk.ijse.D24.entity.Rooms;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RoomFormController implements Initializable {
    public TableColumn colID;
    public TableView<RoomDTO> tblRoom;
    public TableColumn colType;
    public TableColumn colMoney;
    public TableColumn colQuantity;
    public AnchorPane anchorPane;
    public AnchorPane root;

    private RoomBO roomBO = (RoomBO) BOFactory.getBO (BOFactory.BOTypes.ROOM);

    public void onMouseClicked(MouseEvent mouseEvent) {
    }

    public void btnSaveOnAction(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/resources/view/RoomSaveForm.fxml"))));
        stage.setTitle("ROOMS");
        stage.centerOnScreen();
        stage.show();
    }

    public void btnDeleteOnAction(ActionEvent event) throws Exception {
        int id= tblRoom.getSelectionModel().getSelectedItem().getId();
        Rooms rooms=roomBO.getRoom(id);
        roomBO.deleteRoom(rooms);

        tblRoom.getItems().remove(tblRoom.getSelectionModel().getSelectedItem());
        tblRoom.getSelectionModel().clearSelection();
    }

    public void btnUpdateOnAction(ActionEvent event) {
    }

    public void btnBackOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/resources/view/MainForm.fxml"))));
        stage.setTitle("MainForm");
        stage.centerOnScreen();
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setTable();
        loadRooms();
    }

    private void setTable() {
        colID.setCellValueFactory (new PropertyValueFactory<>("id"));
        colType.setCellValueFactory (new PropertyValueFactory<> ("type"));
        colMoney.setCellValueFactory(new PropertyValueFactory<>("key_money"));
        colQuantity.setCellValueFactory (new PropertyValueFactory<> ("quantity"));

    }

    private void loadRooms() {
        try {
            List allRooms = roomBO.loadAll ();
            ObservableList observableList = FXCollections.observableArrayList (allRooms);
            tblRoom.setItems (observableList);

        } catch (Exception e) {
            System.out.println (e);
        }
    }
}
