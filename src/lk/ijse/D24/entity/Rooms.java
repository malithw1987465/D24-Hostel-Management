package lk.ijse.D24.entity;


import javax.persistence.*;

@Entity
@Table(name = "rooms")
public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_type_ID")
    private int id;

    @Column(name = "type")
    private String type;

    @Column(name = "key_money")
    private double keyMoney;

    @Column(name = "quantity")
    private int quantity;

    public Rooms() {
    }

    public Rooms(int id, String type, double keyMoney, int quantity) {
        this.id = id;
        this.type = type;
        this.keyMoney = keyMoney;
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

    public double getKeyMoney() {
        return keyMoney;
    }

    public void setKeyMoney(double keyMoney) {
        this.keyMoney = keyMoney;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Rooms{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", keyMoney=" + keyMoney +
                ", quantity=" + quantity +
                '}';
    }
}
