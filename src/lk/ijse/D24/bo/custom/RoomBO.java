package lk.ijse.D24.bo.custom;

import lk.ijse.D24.bo.SuperBO;
import lk.ijse.D24.dto.RoomDTO;
import lk.ijse.D24.entity.Rooms;

import java.util.List;

public interface RoomBO extends SuperBO {
    List<RoomDTO> loadAll();
    boolean saveRoom(RoomDTO dto);
    boolean updateRoom(RoomDTO dto);
    boolean deleteRoom(Rooms dto);
    Rooms getRoom(int id) throws Exception;
}
