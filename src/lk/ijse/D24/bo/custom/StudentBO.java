package lk.ijse.D24.bo.custom;

import lk.ijse.D24.bo.SuperBO;
import lk.ijse.D24.dto.StudentDTO;
import lk.ijse.D24.entity.Student;

import java.util.List;

public interface StudentBO extends SuperBO {
    List<StudentDTO> loadAll();
    boolean saveStudent(StudentDTO studentDTO);
    boolean updateStudent(StudentDTO studentDTO);
    boolean deleteStudent(Student student);
    Student getStudent(int id) throws Exception;

    int getStudentCount();
}
