package lk.ijse.D24.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private int id;

    @Column(name = "date_time")
    private Date dateTime;

    @ManyToOne
    @JoinColumn(name = "room_type_ID")
    private Rooms room;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(name = "advance")
    private double advance;

    @Column(name = "status")
    private String status;

    public Reservation() {
    }

    public Reservation(int id,Date date_time, Rooms room, Student student, double advance, String status) {
        this.id = id;
        this.dateTime=date_time;
        this.room = room;
        this.student = student;
        this.advance = advance;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Rooms getRoom() {
        return room;
    }

    public void setRoom(Rooms room) {
        this.room = room;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", room=" + room +
                ", student=" + student +
                ", advance=" + advance +
                ", status='" + status + '\'' +
                '}';
    }
}
