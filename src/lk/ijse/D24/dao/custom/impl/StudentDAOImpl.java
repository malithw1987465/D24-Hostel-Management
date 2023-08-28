package lk.ijse.D24.dao.custom.impl;

import lk.ijse.D24.dao.custom.StudentDAO;
import lk.ijse.D24.entity.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    private Session session;
    @Override
    public void setSession(Session session) {
        this.session=session;
    }

    @Override
    public List<Student> loadAll() {
        String sqlQuery="FROM Student ";
        Query query = session.createQuery(sqlQuery);
        List list =query.list ();
        session.close();
        return list;
    }

    @Override
    public int save(Student student) {
        return (int) session.save (student);
    }

    @Override
    public void update(Student student) {
        session.update (student);
    }

    @Override
    public void delete(Student student) {
        session.delete (student);
    }

    @Override
    public Student getObject(int id) throws Exception {
        return session.get (Student.class,id);
    }
//
//
//    @Override
//    public Student getObject(String id) throws Exception {
//        return session.get(Student.class,id);
//    }
//
//    @Override
//    public List<String> getStIds() {
//        String hql = "SELECT id from Student ";
//        Query<String> query=session.createQuery (hql);
//        List<String> results = query.list();
//        session.close();
//        return results;
//
//    }
}
