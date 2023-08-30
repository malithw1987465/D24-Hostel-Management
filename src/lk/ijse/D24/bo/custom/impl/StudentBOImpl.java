package lk.ijse.D24.bo.custom.impl;

import lk.ijse.D24.bo.custom.StudentBO;
import lk.ijse.D24.config.SessionFactoryConfig;
import lk.ijse.D24.dao.DAOFactory;
import lk.ijse.D24.dao.custom.StudentDAO;
import lk.ijse.D24.dto.StudentDTO;
import lk.ijse.D24.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {

    private Session session;

    StudentDAO studentDAO=(StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    @Override
    public List<StudentDTO> loadAll() {
        session= SessionFactoryConfig.getInstance().getSession();
        Transaction transaction= session.beginTransaction();

        studentDAO.setSession(session);
        List<Student> students=studentDAO.loadAll();
        List<StudentDTO> studentDTOList=new ArrayList<>();

        for(Student s:students){
            studentDTOList.add(
                    new StudentDTO(
                            s.getId(),
                            s.getName(),
                            s.getNic(),
                            s.getAddress(),
                            s.getContact(),
                            s.getDob(),
                            s.getEmail(),
                            s.getGender()
                    )
            );
        }
        return studentDTOList;
    }

    @Override
    public boolean saveStudent(StudentDTO studentDTO) {
        session= SessionFactoryConfig.getInstance().getSession();
        Transaction transaction= session.beginTransaction();

        try{
            studentDAO.setSession(session);
            int id=studentDAO.save(
                    new Student(studentDTO.getId(),
                            studentDTO.getName(),
                            studentDTO.getNic(),
                            studentDTO.getAddress(),
                            studentDTO.getContact(),
                            studentDTO.getDob(),
                            studentDTO.getEmail(),
                            studentDTO.getGender()
                    )
            );
            transaction.commit();
            session.close();
            if(studentDAO !=null){
                return true;
            }

        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        return false;
    }

    @Override
    public boolean updateStudent(StudentDTO studentDTO) {
        session=SessionFactoryConfig.getInstance().getSession();
        Transaction transaction= session.beginTransaction();

        try{
            studentDAO.setSession(session);
            studentDAO.update(new Student(
                    studentDTO.getId(),
                    studentDTO.getName(),
                    studentDTO.getNic(),
                    studentDTO.getAddress(),
                    studentDTO.getContact(),
                    studentDTO.getDob(),
                    studentDTO.getEmail(),
                    studentDTO.getGender()
            ));

            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            return false;
        }

    }



    @Override
    public boolean deleteStudent(Student student) {
        session=SessionFactoryConfig.getInstance ().getSession ();
        Transaction transaction= session.beginTransaction();

        try{
            session.delete(student);
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Student getStudent(int id) throws Exception {
        session=SessionFactoryConfig.getInstance ().getSession ();
        Transaction transaction=session.beginTransaction ();

        studentDAO.setSession (session);
        Student st=studentDAO.getObject (id);
        session.close ();
        return new Student (
                st.getId(),
                st.getName(),
                st.getNic(),
                st.getAddress(),
                st.getContact(),
                st.getDob(),
                st.getEmail(),
                st.getGender()
        );
    }

    @Override
    public int getStudentCount() {
        return 0;
    }
}
