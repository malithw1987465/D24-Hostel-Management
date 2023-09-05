package lk.ijse.D24.dao.custom;

import lk.ijse.D24.dao.CrudDAO;
import lk.ijse.D24.entity.Rooms;

import java.util.List;

public interface RoomDAO extends CrudDAO<Rooms> {
    List<Integer> roomIds();
}
