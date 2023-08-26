package lk.ijse.D24.bo.custom;

import lk.ijse.D24.bo.SuperBO;
import lk.ijse.D24.dto.UserDTO;

import java.util.List;

public interface UserBO extends SuperBO {
    boolean saveUser(UserDTO dto);
    UserDTO getUser(int id) throws Exception;
    boolean updateUser(UserDTO dto);
    List<UserDTO> loadAll();

}
