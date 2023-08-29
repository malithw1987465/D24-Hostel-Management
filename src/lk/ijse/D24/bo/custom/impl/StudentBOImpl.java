package lk.ijse.D24.bo.custom.impl;

import lk.ijse.D24.bo.custom.StudentBO;
import lk.ijse.D24.config.SessionFactoryConfig;
import lk.ijse.D24.dao.DAOFactory;
import lk.ijse.D24.dao.custom.StudentDAO;
import lk.ijse.D24.dto.StudentDTO;
import lk.ijse.D24.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {
    private Session session;
    StudentDAO studentDAO=(StudentDAO) DAOFactory.getDaoFactory ().getDAO (DAOFactory.DAOTypes.STUDENT);
    @Override
    public List<StudentDTO> loadAll() {
        session=SessionFactoryConfig.getInstance ().getSession ();
        Transaction transaction=session.beginTransaction ();
        studentDAO.setSession (session);

        List<Student> stList=studentDAO.loadAll ();
        List<StudentDTO> list=new ArrayList<>();
        for (Student student:stList) {
            list.add(
                    new StudentDTO(
                            student.getId (),
                            student.getName (),
                            student.getNic(),
                            student.getAddress (),
                            student.getContact(),
                            student.getEmail(),
                            student.getGender(),
                            (Date) student.getDob()
                    )
            );
        }

        return list;
    }

    @Override
    public boolean saveStudent(StudentDTO dto) {
        session= SessionFactoryConfig.getInstance ().getSession ();
        Transaction transaction=session.beginTransaction ();

        try{
            studentDAO.setSession (session);
            int id=studentDAO.save (new Student (
                    dto.getId (),
                    dto.getName (),
                    dto.getNic(),
                    dto.getAddress (),
                    dto.getContact(),
                    dto.getEmail(),
                    dto.getGender(),
                    dto.getDob()
                    ));
            transaction.commit ();
            session.close ();
            if (studentDAO!=null){
                return true;
            }
        }catch (Exception e){
            transaction.rollback ();
        }
        return false;
    }

    @Override
    public boolean updateStudent(StudentDTO dto) {
        session=SessionFactoryConfig.getInstance ().getSession ();
        Transaction transaction=session.beginTransaction ();

        try {
            studentDAO.setSession (session);
            studentDAO.update (new Student (
                    dto.getId (),
                    dto.getName (),
                    dto.getNic(),
                    dto.getAddress (),
                    dto.getContact(),
                    dto.getEmail(),
                    dto.getGender(),
                    dto.getDob() ));

            transaction.commit ();
            session.close ();
            return true;
        }catch (Exception e){
            transaction.rollback ();;
        }
        return false;
    }

    @Override
    public boolean deleteStudent(StudentDTO dto) {
        session=SessionFactoryConfig.getInstance ().getSession ();
        Transaction transaction=session.beginTransaction ();

        try{
            studentDAO.setSession (session);
            studentDAO.delete (new Student (
                    dto.getId (),
                    dto.getName (),
                    dto.getNic(),
                    dto.getAddress (),
                    dto.getContact(),
                    dto.getEmail(),
                    dto.getGender(),
                    dto.getDob()
            ));
            transaction.commit ();
            session.close ();
            return true;
        }catch (Exception e){
            transaction.rollback ();
        }
        return false;
    }

    @Override
    public StudentDTO getStudent(int id) throws Exception {
        session= SessionFactoryConfig.getInstance ().getSession ();
        Transaction transaction=session.beginTransaction ();

        studentDAO.setSession (session);
        Student st=studentDAO.getObject (id);
        session.close ();
        return new StudentDTO (
                st.getId (),
                st.getName (),
                st.getNic(),
                st.getAddress (),
                st.getContact(),
                st.getEmail(),
                st.getGender(),
                (Date) st.getDob()
        );
    }

    @Override
    public int getStudentCount() {
        return 0;
    }
}
