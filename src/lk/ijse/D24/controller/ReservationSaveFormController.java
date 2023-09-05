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
import lk.ijse.D24.dto.tm.ReservationTM;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class ReservationSaveFormController implements Initializable {

    public ComboBox cmbStatus;
    public Label lblType;
    public ComboBox cmbRoom;
    public Label lblName;
    public ComboBox cmbStudentID;
    public Button btnBack;
    public TextField txtAdvance;
    public Button btnSave;
    public AnchorPane anchorPane;
    public DatePicker date;

    private ReservationBO reservationBO = (ReservationBO) BOFactory.getBO (BOFactory.BOTypes.RESERVATION);

    public void btnSaveOnAction(ActionEvent event) {
        StudentDTO studentDTO = getStudentDetail ();
        RoomDTO roomDTO = getRoomDetail ();
        int id=0;
        String status = cmbStatus.getValue ().toString ();
        double advance= Double.parseDouble(txtAdvance.getText());
        Date dateTime= Date.valueOf(date.getValue());
        boolean isSaveReservation = reservationBO.saveReservation (
                new ReservationDTO(
                        id,
                        dateTime,
                        roomDTO,
                        studentDTO,
                        advance,
                        status
                ));
        if (isSaveReservation) {
            new Alert(Alert.AlertType.CONFIRMATION, "Saved Successfully").show();
            RoomDTO room = getRoomDetail ();

            System.out.println (room.getQuantity() - 1);
            room.setQuantity(room.getQuantity() - 1);
            reservationBO.updateRoom (room);
            // tblReservation.getItems ().clear ();
            loadAllReservations ();
        }
    }

    private void loadAllReservations() {
        try {
            List<ReservationDTO> allRoom = reservationBO.loadAll ();

            ObservableList<ReservationTM> resList = FXCollections.observableArrayList ();

            for (ReservationDTO dto : allRoom) {
                resList.add (new ReservationTM (
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

        } catch (Exception e) {
            System.out.println (e);
        }
    }

    private RoomDTO getRoomDetail() {
        try {
            int roomId = (int) cmbRoom.getValue ();
            System.out.println ("This IS ROOM ID"+roomId);
            return reservationBO.getRoom (roomId);
        } catch (Exception e) {
            System.out.println (e);
        }
        return null;
    }

    private StudentDTO getStudentDetail() {
        int stId = (int) cmbStudentID.getValue ();
        return reservationBO.getStudent (stId);
    }

    public void btnBackOnAction(ActionEvent event) {
    }

    public void cmbStudentOnAction(ActionEvent event) {
        int student_id = (int) cmbStudentID.getValue();
        StudentDTO dto = reservationBO.getStudent (student_id);
        lblName.setText (dto.getName());
    }

    public void cmbRoomOnAction(ActionEvent event) {
        int room_id = (int) cmbRoom.getValue();
        RoomDTO dto = reservationBO.getRoom(room_id);
        lblType.setText (dto.getType());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setData();
        setStatus();
    }

    private void setStatus() {
        ObservableList<String> data = FXCollections.observableArrayList ("Paid", "Not Paid","Fully Paid");
        cmbStatus.setItems (data);
    }

    private void setData() {
        List<Integer> studentIds = reservationBO.getStudentIds ();
        ObservableList student = FXCollections.observableArrayList (studentIds);
        cmbStudentID.setItems (student);

        List<Integer> roomIds = reservationBO.getRoomIds ();
        ObservableList room = FXCollections.observableArrayList (roomIds);
        cmbRoom.setItems (room);
    }
}
