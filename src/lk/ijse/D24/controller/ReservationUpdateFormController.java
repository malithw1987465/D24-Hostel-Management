package lk.ijse.D24.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import lk.ijse.D24.bo.BOFactory;
import lk.ijse.D24.bo.custom.ReservationBO;
import lk.ijse.D24.dto.ReservationDTO;
import lk.ijse.D24.dto.RoomDTO;
import lk.ijse.D24.dto.StudentDTO;
import lk.ijse.D24.entity.Reservation;

import java.net.URL;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;

public class ReservationUpdateFormController implements Initializable {
    public AnchorPane anchorPane;
    public TextField txtAdvance;
    public Button btnSave;
    public ComboBox cmbStudentID;
    public Label lblName;
    public ComboBox cmbRoom;
    public Label lblType;
    public ComboBox cmbStatus;
    public DatePicker date;
    public ComboBox cmbReservation;

    private ReservationBO reservationBO = (ReservationBO) BOFactory.getBO (BOFactory.BOTypes.RESERVATION);


    public void btnSaveOnAction(ActionEvent event) {
        int stId = (int) cmbStudentID.getValue ();
        int roomID = (int) cmbRoom.getValue ();
        String status = cmbStatus.getValue ().toString ();
        double advance= Double.parseDouble(txtAdvance.getText());
        int resId = (int) cmbReservation.getValue();
        StudentDTO studentDTO = getStudentDetails ();
        RoomDTO roomDTO = getRoomDetails ();
        Date dt= Date.valueOf(date.getValue());

        try {
            boolean isUpdate = reservationBO.updateReservation (
                    new ReservationDTO (
                            resId,
                            dt,
                            roomDTO,
                            studentDTO,
                            advance,
                            status
                    ));
            new Alert(Alert.AlertType.CONFIRMATION, "Update Successfully").show();

        } catch (Exception e) {
            e.printStackTrace ();
        }

    }

    private RoomDTO getRoomDetails() {
        try {
            int roomId = (int) cmbRoom.getValue ();
            System.out.println ("This IS ROOM ID"+roomId);
            return reservationBO.getRoom (roomId);
        } catch (Exception e) {
            System.out.println (e);
        }
        return null;
    }

    private StudentDTO getStudentDetails() {
        int stId = (int) cmbStudentID.getValue ();
        return reservationBO.getStudent (stId);
    }

    public void btnBackOnAction(ActionEvent event) {
    }

    public void cmbStudentOnAction(ActionEvent event) {
        int stId = (int) cmbStudentID.getValue ();
        StudentDTO dto = reservationBO.getStudent (stId);
        lblName.setText (dto.getName());
    }

    public void cmbRoomOnAction(ActionEvent event) {
        int roomId = (int) cmbRoom.getValue ();
        RoomDTO dto = reservationBO.getRoom (roomId);
        lblType.setText (dto.getType ());
    }

    public void cmbReservationOnAction(ActionEvent event) {
        setData();
    }

    private void setData() {
        int resID= (int) cmbReservation.getValue();
        StudentDTO dto=reservationBO.getStudent(resID);
        RoomDTO rDto=reservationBO.getRoom(resID);
        Reservation dt=reservationBO.getRes(resID);
        cmbStudentID.setValue(dto.getId());
        lblName.setText(dto.getName());
        cmbRoom.setValue(rDto.getId());
        lblType.setText(rDto.getType());
        txtAdvance.setText(String.valueOf(dt.getAdvance()));
        cmbStatus.setValue(dt.getStatus());
        date.setPromptText(String.valueOf(dt.getDateTime()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setResIDS();
        loadStudentID();
        loadRoomID();
        loadStatus();
    }

    private void loadStatus() {
        ObservableList<String> data = FXCollections.observableArrayList ("Paid", "Not Paid","Fully Paid");
        cmbStatus.setItems (data);
    }

    private void loadRoomID() {
        List<Integer> RoomIds = reservationBO.getRoomIds();
        ObservableList rooms = FXCollections.observableArrayList (RoomIds);
        cmbRoom.setItems (rooms);
    }

    private void loadStudentID() {
        List<Integer> StIds = reservationBO.getStudentIds();
        ObservableList students = FXCollections.observableArrayList (StIds);
        cmbStudentID.setItems (students);
    }

    private void setResIDS() {
        List<Integer> ResIds = reservationBO.getResIds();
        ObservableList reservations = FXCollections.observableArrayList (ResIds);
        cmbReservation.setItems (reservations);
    }
}
