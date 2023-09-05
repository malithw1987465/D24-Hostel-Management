package lk.ijse.D24.dao.custom.impl;

import lk.ijse.D24.config.SessionFactoryConfig;
import lk.ijse.D24.dao.custom.ReservationDAO;
import lk.ijse.D24.entity.Reservation;
import lk.ijse.D24.entity.Rooms;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {
    private Session session;


    @Override
    public List<Reservation> loadAll() {
        List<Reservation> allReserve = null;
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery(" FROM Reservation");
        allReserve = (List<Reservation>) query.list();
        transaction.commit();
        session.close();
        return allReserve;
    }

    @Override
    public int save(Reservation reservation) {
        return (int) session.save (reservation);
    }

    @Override
    public void update(Reservation reservation) {
        session.update (reservation);
    }

    @Override
    public void delete(Reservation reservation) {
        session.delete (reservation);
    }

    @Override
    public Reservation getObject(int id) throws Exception {
        return session.get (Reservation.class,id);
    }

    @Override
    public void setSession(Session session) {
        this.session=session;
    }


    @Override
    public List<Integer> resIds() {
        String hql = "SELECT id from Reservation ";
        Query<Integer> query=session.createQuery (hql);
        List<Integer> results = query.list();
        session.close();
        return results;
    }
}
