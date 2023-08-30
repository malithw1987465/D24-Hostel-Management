package lk.ijse.D24.dto;

public class RoomDTO {

    private int id;
    private String type;
    private double key_money;
    private int quantity;

    public RoomDTO() {
    }

    public RoomDTO(int id, String type, double key_money, int quantity) {
        this.id = id;
        this.type = type;
        this.key_money = key_money;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getKey_money() {
        return key_money;
    }

    public void setKey_money(double key_money) {
        this.key_money = key_money;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
