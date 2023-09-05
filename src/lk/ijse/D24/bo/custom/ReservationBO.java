package lk.ijse.D24.bo.custom;

import lk.ijse.D24.bo.SuperBO;
import lk.ijse.D24.dto.ReservationDTO;
import lk.ijse.D24.dto.RoomDTO;
import lk.ijse.D24.dto.StudentDTO;
import lk.ijse.D24.entity.Reservation;

import java.util.List;

public interface ReservationBO extends SuperBO {

    List<Integer> getStudentIds();
    List<Integer> getRoomIds();
    List<Integer> getResIds();
    StudentDTO getStudent(int id);
    RoomDTO getRoom(int id);
    Reservation getRes(int resID);
    boolean updateRoom(RoomDTO dto);
    List<ReservationDTO> loadAllRes();
    boolean saveReservation(ReservationDTO dto);
    boolean updateReservation(ReservationDTO dto);
    boolean deleteReservation(Reservation dto);
    List<ReservationDTO> loadAll();
}
