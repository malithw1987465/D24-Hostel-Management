package lk.ijse.D24.dto;

import lk.ijse.D24.entity.Rooms;
import lk.ijse.D24.entity.Student;

import java.sql.Date;
import java.sql.Timestamp;

public class ReservationDTO {

    private int id;
    private Date date_time;
    private RoomDTO rooms;
    private StudentDTO student;
    private double advance;
    private String status;

    public ReservationDTO() {
    }

    public ReservationDTO(int id, Date date_time, RoomDTO rooms, StudentDTO student, double advance, String status) {
        this.id = id;
        this.date_time = date_time;
        this.rooms = rooms;
        this.student = student;
        this.advance=advance;
        this.status = status;
    }

    public double getAdvance() {
        return advance;
    }

    public void setAdvance(double advance) {
        this.advance = advance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate_time() {
        return date_time;
    }

    public void setDate_time(Date date_time) {
        this.date_time = date_time;
    }

    public RoomDTO getRooms() {
        return rooms;
    }

    public void setRooms(RoomDTO rooms) {
        this.rooms = rooms;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
