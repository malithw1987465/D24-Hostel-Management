package lk.ijse.D24.dao.custom.impl;

import lk.ijse.D24.config.SessionFactoryConfig;
import lk.ijse.D24.dao.custom.QueryDAO;
import lk.ijse.D24.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class QueryDAOImpl implements QueryDAO {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session=session;
    }

    @Override

    public List<Student> loadFullStudents() {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<Student> allPay = session.createQuery("select student from Reservation where status like: ID").setParameter("ID","Fully Paid").list();

        transaction.commit();
        session.close();
        return allPay;
    }
//    select Student .id, Student .name, Student .nic,Student .address,Student .email,Student .contact,Reservation .advance from Student inner join Reservation ON Student .id=Reservation .student.id where Reservation .advance=Reservation .room.keyMoney order by 1 asc
    @Override
    public List<Student> loadPaidStudents() {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<Student> allPay = session.createQuery("select student from Reservation where status like: ID").setParameter("ID","Paid").list();

        transaction.commit();
        session.close();
        return allPay;
    }

    @Override
    public List<Student> loadNotPaidStudents() {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<Student> allPay = session.createQuery("select student from Reservation where status like: ID").setParameter("ID","Not Paid").list();

        transaction.commit();
        session.close();
        return allPay;
    }
}
