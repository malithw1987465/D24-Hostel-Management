package lk.ijse.D24.dto.tm;

import lk.ijse.D24.dto.RoomDTO;
import lk.ijse.D24.dto.StudentDTO;

import java.sql.Date;
import java.sql.Timestamp;

public class ReservationTM {

    private int id;
    private Date date_time;
    private int student_id;
    private String name;
    private int room_id;
    private String type;
    private double advance;
    private String status;

    public ReservationTM() {
    }

    public ReservationTM(int id, Date date_time, int student_id, String name, int room_id, String type, double advance, String status) {
        this.id = id;
        this.date_time = date_time;
        this.student_id = student_id;
        this.name=name;
        this.room_id = room_id;
        this.type=type;
        this.advance = advance;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public double getAdvance() {
        return advance;
    }

    public void setAdvance(double advance) {
        this.advance = advance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
