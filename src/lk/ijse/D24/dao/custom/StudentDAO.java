package lk.ijse.D24.dao.custom;

import lk.ijse.D24.dao.CrudDAO;
import lk.ijse.D24.entity.Student;

import java.util.List;

public interface StudentDAO extends CrudDAO<Student> {
    List<Integer> getStIds();
}
