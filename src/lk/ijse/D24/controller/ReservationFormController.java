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
import lk.ijse.D24.bo.custom.ReservationBO;
import lk.ijse.D24.bo.custom.RoomBO;
import lk.ijse.D24.dto.ReservationDTO;
import lk.ijse.D24.dto.tm.ReservationTM;
import lk.ijse.D24.entity.Reservation;
import lk.ijse.D24.entity.Rooms;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ReservationFormController implements Initializable {
    public AnchorPane anchorPane;
    public TableView<ReservationTM> tblReservation;
    public TableColumn colID;
    public TableColumn colDate;
    public TableColumn colStID;
    public TableColumn colRoomID;
    public TableColumn colAdvance;
    public TableColumn colStatus;

    private ReservationBO reservationBO = (ReservationBO) BOFactory.getBO (BOFactory.BOTypes.RESERVATION);

    public void onMouseClicked(MouseEvent mouseEvent) {
    }

    public void btnSaveOnAction(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/resources/view/ReservationSaveForm.fxml"))));
        stage.setTitle("RESERVATION");
        stage.centerOnScreen();
        stage.show();
    }

    public void btnDeleteOnAction(ActionEvent event) {
        int id= tblReservation.getSelectionModel().getSelectedItem().getId();
        Reservation reservation=reservationBO.getRes(id);
        reservationBO.deleteReservation(reservation);

        tblReservation.getItems().remove(tblReservation.getSelectionModel().getSelectedItem());
        tblReservation.getSelectionModel().clearSelection();
    }

    public void btnUpdateOnAction(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/resources/view/ReservationUpdateForm.fxml"))));
        stage.setTitle("RESERVATION");
        stage.centerOnScreen();
        stage.show();
    }

    public void btnBackOnAction(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/resources/view/MainForm.fxml"))));
        stage.setTitle("MainForm");
        stage.centerOnScreen();
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setTable();
        loadReservations();
    }

    private void loadReservations() {
        try {
            List<ReservationDTO> allReservations = reservationBO.loadAll ();

            ObservableList<ReservationTM> resList = FXCollections.observableArrayList ();

            for (ReservationDTO dto : allReservations) {
                resList.add (new ReservationTM(
                        dto.getId(),
                        dto.getDate_time(),
                        dto.getStudent().getId(),
                        dto.getStudent().getName(),
                        dto.getRooms().getId(),
                        dto.getRooms().getType(),
                        dto.getAdvance(),
                        dto.getStatus ()
                ));
            }

            tblReservation.setItems (resList);

            System.out.println (resList);


        } catch (Exception e) {
            System.out.println (e);
        }
    }

    private void setTable() {
        colID.setCellValueFactory (new PropertyValueFactory<>("id"));
        colDate.setCellValueFactory (new PropertyValueFactory<> ("date_time"));
        colStID.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        colRoomID.setCellValueFactory (new PropertyValueFactory<> ("room_id"));
        colAdvance.setCellValueFactory(new PropertyValueFactory<>("advance"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
    }
}
