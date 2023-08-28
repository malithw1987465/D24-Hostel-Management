package lk.ijse.D24.dto;

import java.sql.Timestamp;

public class UserDTO {

    private int id;
    private String userName;
    private String password;
    private String email;

    public UserDTO() {
    }

    public UserDTO(int id, String userName, String password,String email) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email=email;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
