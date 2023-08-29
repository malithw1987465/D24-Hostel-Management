package lk.ijse.D24.bo.custom;

import lk.ijse.D24.bo.SuperBO;
import lk.ijse.D24.dto.StudentDTO;

import java.util.List;

public interface StudentBO extends SuperBO {
    List<StudentDTO> loadAll();
    boolean saveStudent(StudentDTO studentDTO);
    boolean updateStudent(StudentDTO studentDTO);
    boolean deleteStudent(StudentDTO studentDTO);
    StudentDTO getStudent(int id) throws Exception;

    int getStudentCount();
}
