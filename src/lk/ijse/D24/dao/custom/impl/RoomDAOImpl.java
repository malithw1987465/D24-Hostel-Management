package lk.ijse.D24.dao.custom.impl;

import lk.ijse.D24.dao.custom.RoomDAO;
import lk.ijse.D24.entity.Rooms;
import lk.ijse.D24.entity.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class RoomDAOImpl implements RoomDAO {

    private Session session;

    @Override
    public List<Rooms> loadAll() {
        String hql="FROM Rooms";
        Query query = session.createQuery(hql);
        List<Rooms> list =query.list ();
        session.close();
        return list;
    }

    @Override
    public int save(Rooms rooms) {
        return (int) session.save (rooms);
    }

    @Override
    public void update(Rooms rooms) {
        session.update (rooms);
    }

    @Override
    public void delete(Rooms rooms) {

    }

    @Override
    public Rooms getObject(int id) throws Exception {
        return session.get (Rooms.class,id);
    }

    @Override
    public void setSession(Session session) {
        this.session=session;
    }

    @Override
    public List<Integer> roomIds() {
        String hql = "SELECT id from Rooms ";
        Query<Integer> query=session.createQuery (hql);
        List<Integer> results = query.list();
        session.close();
        return results;
    }
}
