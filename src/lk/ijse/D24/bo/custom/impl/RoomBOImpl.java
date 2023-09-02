package lk.ijse.D24.bo.custom.impl;

import lk.ijse.D24.bo.custom.RoomBO;
import lk.ijse.D24.config.SessionFactoryConfig;
import lk.ijse.D24.dao.DAOFactory;
import lk.ijse.D24.dao.custom.RoomDAO;
import lk.ijse.D24.dao.custom.StudentDAO;
import lk.ijse.D24.dto.RoomDTO;
import lk.ijse.D24.dto.StudentDTO;
import lk.ijse.D24.entity.Rooms;
import lk.ijse.D24.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class RoomBOImpl implements RoomBO {

    private Session session;

    RoomDAO roomDAO=(RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ROOM);

    @Override
    public List<RoomDTO> loadAll() {
        session= SessionFactoryConfig.getInstance().getSession();
        Transaction transaction= session.beginTransaction();

        roomDAO.setSession(session);
        List<Rooms> rooms=roomDAO.loadAll();
        List<RoomDTO> roomDTOList=new ArrayList<>();

        for(Rooms r:rooms){
            roomDTOList.add(
                    new RoomDTO(
                            r.getId(),
                            r.getType(),
                            r.getKeyMoney(),
                            r.getQuantity()
                    )
            );
        }
        return roomDTOList;
    }

    @Override
    public boolean saveRoom(RoomDTO dto) {
        session= SessionFactoryConfig.getInstance().getSession();
        Transaction transaction= session.beginTransaction();

        try{
            roomDAO.setSession(session);
            int id=roomDAO.save(
                    new Rooms(dto.getId(),
                            dto.getType(),
                            dto.getKey_money(),
                            dto.getQuantity()
                    )
            );
            transaction.commit();
            session.close();
            if(roomDAO !=null){
                return true;
            }

        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        return false;
    }

    @Override
    public boolean updateRoom(RoomDTO dto) {
        session=SessionFactoryConfig.getInstance().getSession();
        Transaction transaction= session.beginTransaction();

        try{
            roomDAO.setSession(session);
            roomDAO.update(new Rooms(
                    dto.getId(),
                    dto.getType(),
                    dto.getKey_money(),
                    dto.getQuantity()
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
    public boolean deleteRoom(Rooms dto) {
        session=SessionFactoryConfig.getInstance ().getSession ();
        Transaction transaction= session.beginTransaction();

        try{
            session.delete(dto);
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
    public Rooms getRoom(int id) throws Exception {
        session=SessionFactoryConfig.getInstance ().getSession ();
        Transaction transaction=session.beginTransaction ();

        roomDAO.setSession (session);
        Rooms st=roomDAO.getObject (id);
        session.close ();
        return new Rooms (
                st.getId(),
                st.getType(),
                st.getKeyMoney(),
                st.getQuantity()
        );
    }
}
