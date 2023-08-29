package lk.ijse.D24.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class StudentDTO {
    private int id;
    private String name;
    private String nic;
    private String address;
    private String contact;
    private String email;
    private String gender;
    private Date dob;
    private Timestamp createdDateTime;

    public StudentDTO() {
    }

    public StudentDTO(int id, String name, String nic, String address, String contact, String email, String gender, Date dob, Timestamp createdDateTime) {
        this.id = id;
        this.name = name;
        this.nic = nic;
        this.address = address;
        this.contact = contact;
        this.email = email;
        this.gender = gender;
        this.dob = dob;
        this.createdDateTime = createdDateTime;
    }



    public String getId() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Timestamp getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Timestamp createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nic='" + nic + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", dob='" + dob + '\'' +
                ", createdDateTime=" + createdDateTime +
                '}';
    }
}
