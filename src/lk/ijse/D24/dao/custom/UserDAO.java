package lk.ijse.D24.dao.custom;

import lk.ijse.D24.dao.CrudDAO;
import lk.ijse.D24.entity.User;

import java.util.List;

public interface UserDAO extends CrudDAO<User> {
    List<Integer> userIds();
}
