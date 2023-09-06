package lk.ijse.D24.dao.custom;

import lk.ijse.D24.dao.SuperDAO;
import lk.ijse.D24.entity.Student;

import java.util.List;

public interface QueryDAO extends SuperDAO {
    List<Student> loadFullStudents();
    List<Student> loadPaidStudents();
    List<Student> loadNotPaidStudents();
}
