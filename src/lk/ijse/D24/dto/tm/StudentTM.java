package lk.ijse.D24.dto.tm;

import java.sql.Date;
import java.sql.Timestamp;

public class StudentTM {

    private int id;
    private String name;
    private String nic;
    private String address;
    private String contact;
    private Date dob;
    private Timestamp loggedDateTime;
    private String email;
    private String gender;

    public StudentTM() {
    }

    public StudentTM(int id, String name, String nic, String address, String contact, Date dob, Timestamp loggedDateTime,String email,String gender) {
        this.id = id;
        this.name = name;
        this.nic = nic;
        this.address = address;
        this.contact = contact;
        this.dob = dob;
        this.loggedDateTime = loggedDateTime;
        this.email=email;
        this.gender=gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Timestamp getLoggedDateTime() {
        return loggedDateTime;
    }

    public void setLoggedDateTime(Timestamp loggedDateTime) {
        this.loggedDateTime = loggedDateTime;
    }
}
